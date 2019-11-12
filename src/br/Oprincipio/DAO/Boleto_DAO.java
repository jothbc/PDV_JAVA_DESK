/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Boleto_Bean;
import br.Oprincipio.Bean.Fornecedor_Bean;
import funcoes.CDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Boleto_DAO {

    Connection con = null;

    public Boleto_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean addBoleto(Boleto_Bean b) {
        String sql = "INSERT INTO boleto (fornecedor,codigo,valor,vencimento) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, b.getFornecedor().getChave());
            stmt.setString(2, b.getCd_barras());
            stmt.setDouble(3, b.getValor());
            stmt.setString(4, CDate.DataPTBRtoDataMySQL(b.getVencimento()));
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Boleto_Bean> findAll() {
        List<Boleto_Bean> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boleto ORDER BY vencimento";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Boleto_Bean b = new Boleto_Bean();
                b.setId(rs.getInt("id"));
                Fornecedor_Bean f = new Fornecedor_Bean();
                f.setChave(rs.getInt("fornecedor"));
                b.setFornecedor(f);
                if (!"".equals(rs.getString("pago")) && rs.getString("pago") != null) {
                    b.setPago(CDate.DataMySQLtoDataStringPT(rs.getString("pago")));
                } else {
                    b.setPago(null);
                }
                b.setCd_barras(rs.getString("codigo"));
                b.setVencimento(CDate.DataMySQLtoDataStringPT(rs.getString("vencimento")));
                b.setValor(rs.getDouble("valor"));
                boletos.add(b);
            }
            for (Boleto_Bean b : boletos) {
                b.setFornecedor(new br.Oprincipio.DAO.Fornecedor_DAO().getFornecedorByChave(b.getFornecedor().getChave()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return boletos;
    }

    public List<Boleto_Bean> findAllByFornecedor(int chave) {
        List<Boleto_Bean> boletos = new ArrayList<>();
        String sql = "SELECT * FROM boleto WHERE fornecedor = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, chave);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Boleto_Bean b = new Boleto_Bean();
                try {
                    b.setAll(rs.getString("codigo"));
                } catch (Exception e) {
                }
                b.setId(rs.getInt("id"));
                Fornecedor_Bean f = new Fornecedor_Bean();
                f.setChave(rs.getInt("fornecedor"));
                b.setFornecedor(f);
                if (!"".equals(rs.getString("pago")) && rs.getString("pago") != null) {
                    b.setPago(CDate.DataMySQLtoDataStringPT(rs.getString("pago")));
                } else {
                    b.setPago(null);
                }
                b.setCd_barras(rs.getString("codigo"));
                b.setVencimento(CDate.DataMySQLtoDataStringPT(rs.getString("vencimento")));
                b.setValor(rs.getDouble("valor"));
                boletos.add(b);
            }
            for (Boleto_Bean b : boletos) {
                b.setFornecedor(new br.Oprincipio.DAO.Fornecedor_DAO().getFornecedorByChave(b.getFornecedor().getChave()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return boletos;
    }

    public boolean pagarBoleto(int id) {
        String sql = "UPDATE boleto SET pago = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CDate.DataPTBRtoDataMySQL(CDate.DataPTBRAtual()));
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public Double getContasHoje() {
        String sql = "SELECT valor FROM boleto where pago is null and vencimento = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        double valor = 0;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CDate.DataPTBRtoDataMySQL(CDate.DataPTBRAtual()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                valor += rs.getDouble("valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return valor;
    }

    public Boleto_Bean getBoletoByID(int idBoleto) {
        String sql = "SELECT * FROM boleto WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idBoleto);
            rs = stmt.executeQuery();
            rs.first();
            Boleto_Bean b = new Boleto_Bean();
            try {
                b.setAll(rs.getString("codigo"));
            } catch (Exception e) {
            }
            b.setId(rs.getInt("id"));
            Fornecedor_Bean f = new Fornecedor_Bean();
            f.setChave(rs.getInt("fornecedor"));
            b.setFornecedor(f);
            if (!"".equals(rs.getString("pago")) && rs.getString("pago") != null) {
                b.setPago(CDate.DataMySQLtoDataStringPT(rs.getString("pago")));
            } else {
                b.setPago(null);
            }
            b.setCd_barras(rs.getString("codigo"));
            b.setVencimento(CDate.DataMySQLtoDataStringPT(rs.getString("vencimento")));
            b.setValor(rs.getDouble("valor"));
            b.setFornecedor(new Fornecedor_DAO().getFornecedorByChave(b.getFornecedor().getChave()));
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public boolean updateBoleto(Boleto_Bean b){
        String sql = "UPDATE boleto SET fornecedor = ?,codigo = ?,valor= ?,vencimento=? WHERE id = ?";
        PreparedStatement stmt =null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, b.getFornecedor().getChave());
            stmt.setString(2, b.getCd_barras());
            stmt.setDouble(3, b.getValor());
            stmt.setString(4, CDate.DataPTBRtoDataMySQL(b.getVencimento()));
            stmt.setInt(5, b.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean deletarBoleto(int id) {
        String sql = "DELETE FROM boleto WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Boleto_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

}
