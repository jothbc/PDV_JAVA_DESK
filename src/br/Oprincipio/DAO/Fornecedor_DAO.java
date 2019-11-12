/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Banco_Bean;
import br.Oprincipio.Bean.Fornecedor_Bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Fornecedor_DAO {

    Connection con = null;

    public Fornecedor_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean addFornecedor(Fornecedor_Bean f) {
        String sql = "INSERT INTO fornecedor (nome,chave) VALUES (?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setInt(2, f.getChave());
            stmt.execute();
            if (f.areInfo()) {
                if (!new Fornecedor_DAO().addInfoFornecedor(f)) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar salvar info do fornecedor: " + f.getNome());
                }
            }
            stmt = con.prepareStatement("INSERT INTO fornecedor_conta (chave) VALUES (?)");
            stmt.setInt(1, f.getChave());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
        return false;
    }

    public boolean addInfoFornecedor(Fornecedor_Bean f) {
        String sql = "INSERT INTO fornecedor_info (chave,cnpj,cpf,telefone,email,ie) VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getChave());
            stmt.setString(2, f.getCnpj());
            stmt.setString(3, f.getCpf());
            stmt.setString(4, f.getTelefone());
            stmt.setString(5, f.getEmail());
            stmt.setString(6, f.getIe());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
        return false;
    }

    public boolean addContaFornecedor(Fornecedor_Bean f, Banco_Bean b) {
        String sql = "INSERT INTO fornecedor_conta (chave,banco,numero) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getChave());
            stmt.setInt(2, b.getBanco());
            stmt.setString(3, b.getNumero());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
        return false;
    }

    public boolean atualizarFornecedor(Fornecedor_Bean f) {
        String sql = "UPDATE fornecedor SET nome = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setInt(2, f.getId());
            stmt.executeUpdate();
            if (f.areInfo()) {
                stmt = con.prepareStatement("DELETE FROM fornecedor_info WHERE chave = ?");
                stmt.setInt(1, f.getChave());
                stmt.execute();
                if (!new Fornecedor_DAO().addInfoFornecedor(f)) {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar informações do fornecedor.");
                }
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean atualizarFornecedor_BancoENumero(Fornecedor_Bean f, Banco_Bean b) {
        String sql = "UPDATE fornecedor_conta SET banco = ?, numero = ? WHERE chave = ? and id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, b.getBanco());
            stmt.setString(2, b.getNumero());
            stmt.setInt(3, f.getChave());
            stmt.setInt(4, b.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public int getNewChave() {
        String sql = "SELECT MAX(chave) FROM fornecedor";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.first();
            return rs.getInt("MAX(chave)") + 1;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return 0;
    }

    public Fornecedor_Bean getInfo(Fornecedor_Bean f) {
        String sql = "SELECT * FROM fornecedor_info WHERE chave = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getChave());
            rs = stmt.executeQuery();
            rs.first();
            if (rs.isFirst()) {
                f.setCnpj(rs.getString("cnpj"));
                f.setCpf(rs.getString("cpf"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setIe(rs.getString("ie"));
                return f;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return f;
    }

    public List<Banco_Bean> getContas(Fornecedor_Bean f) {
        List<Banco_Bean> bancos = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor_conta WHERE chave = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, f.getChave());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Banco_Bean b = new Banco_Bean();
                b.setId(rs.getInt("id"));
                b.setBanco(rs.getInt("banco"));
                b.setNumero(rs.getString("numero"));
                bancos.add(b);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return bancos;
    }

    public List<Fornecedor_Bean> getFornecedoresSeco() {
        List<Fornecedor_Bean> fornecedores = new ArrayList<>();
        String sql = "SELECT * FROM fornecedor";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor_Bean f = new Fornecedor_Bean();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setChave(rs.getInt("chave"));
                fornecedores.add(f);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return fornecedores;
    }

    public List<Fornecedor_Bean> findAll() {
        List<Fornecedor_Bean> fornecedores = new Fornecedor_DAO().getFornecedoresSeco();
        for (Fornecedor_Bean f : fornecedores) {
            f = new Fornecedor_DAO().getInfo(f);
            f.setBanco(new Fornecedor_DAO().getContas(f));
        }
        return fornecedores;
    }

    public Fornecedor_Bean getFornecedorByChave(int chave) {
        String sql = "SELECT * FROM fornecedor WHERE chave = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, chave);
            rs = stmt.executeQuery();
            rs.first();
            Fornecedor_Bean f = new Fornecedor_Bean();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setChave(rs.getInt("chave"));
            f.setBanco(new Fornecedor_DAO().getContas(f));
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
    }

    public Fornecedor_Bean getFornecedorByID(int id) {
        String sql = "SELECT * FROM fornecedor WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.first();
            Fornecedor_Bean f = new Fornecedor_Bean();
            f.setId(id);
            f.setNome(rs.getString("nome"));
            f.setChave(rs.getInt("chave"));
            f.setBanco(new Fornecedor_DAO().getContas(f));
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
    }

    public Fornecedor_Bean getFornecedorByNome(String text) {
        String sql = "SELECT * FROM fornecedor WHERE nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, text.toUpperCase());
            rs = stmt.executeQuery();
            rs.first();
            Fornecedor_Bean f = new Fornecedor_Bean();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setChave(rs.getInt("chave"));
            f.setBanco(new Fornecedor_DAO().getContas(f));
            return f;
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedor_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
    }
}
