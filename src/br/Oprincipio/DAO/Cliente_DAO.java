/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Cliente_Bean;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Cliente_DAO {

    Connection con = null;

    public Cliente_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean insertInto(Cliente_Bean cliente) {
        String sql = "INSERT INTO cliente(nome,cpf,telefone,email,crediario,aniversario,credito) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setDouble(5, cliente.getCrediario());
            stmt.setString(6, cliente.getAniversario(cliente.SQL));
            stmt.setDouble(7, cliente.getCredito());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

//    @Deprecated
//    public boolean setCrediario(Cliente_Bean c) {
//        String sql = "UPDATE cliente SET crediario = ? WHERE id = ?";
//        PreparedStatement stmt = null;
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setDouble(1, c.getCrediario());
//            stmt.setInt(2, c.getId());
//            stmt.executeUpdate();
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        } finally {
//            ConnectionFactoryMySQL.closeConnection(con, stmt);
//        }
//    }

    public boolean injetarCredito(int id, double valor) {
        String sql = "UPDATE cliente SET credito = credito + ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    
//    @Deprecated
//    public double getCrediario(int id) {
//        String sql = "SELECT crediario FROM cliente WHERE id = ?";
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setInt(1, id);
//            rs = stmt.executeQuery();
//            rs.first();
//            return rs.getDouble("crediario");
//        } catch (SQLException ex) {
//            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
//            return 0;
//        } finally {
//            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
//        }
//    }

    public double getCredito(int id) {
        String sql = "SELECT credito FROM cliente WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.first();
            return rs.getDouble("credito");
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
    }

    public boolean update(Cliente_Bean c) {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ?, aniversario = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getCpf());
            stmt.setString(3, c.getTelefone());
            stmt.setString(4, c.getEmail());
            stmt.setString(5, c.getAniversario(c.SQL));
            stmt.setInt(6, c.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Cliente_Bean> findAll() throws SQLException, Exception {
        List<Cliente_Bean> cl = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente_Bean nv = new Cliente_Bean();
                nv.setId(rs.getInt("id"));
                nv.setNome(rs.getString("nome"));
                nv.setCpf(rs.getString("cpf"));
                nv.setTelefone(rs.getString("telefone"));
                nv.setEmail(rs.getString("email"));
                //nv.setCrediario(rs.getDouble("crediario"));
                nv.setAniversario(rs.getString("aniversario"), nv.SQL);
                nv.setCredito(rs.getDouble("credito"));
                cl.add(nv);
            }
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return cl;
    }

    public boolean delete(int i) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, i);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public Cliente_Bean getCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            rs.first();
            Cliente_Bean nv = new Cliente_Bean();
            nv.setId(rs.getInt("id"));
            nv.setNome(rs.getString("nome"));
            nv.setCpf(rs.getString("cpf"));
            nv.setTelefone(rs.getString("telefone"));
            nv.setEmail(rs.getString("email"));
            //nv.setCrediario(rs.getDouble("crediario"));
            nv.setAniversario(rs.getString("aniversario"), nv.SQL);
            nv.setCredito(rs.getDouble("credito"));
            return nv;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public boolean debitarCredito(int id, double credito) {
        String sql = "UPDATE cliente SET credito = credito - ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, credito);
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

}
