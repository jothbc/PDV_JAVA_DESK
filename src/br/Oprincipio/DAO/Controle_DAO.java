/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Controle_DAO {

    Connection con = null;

    public Controle_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean PDVAutomatico() {
        String sql = "SELECT ativo FROM controle WHERE id = 1";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.first();
            return rs.getBoolean("ativo");
        } catch (SQLException ex) {
            Logger.getLogger(Controle_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
    }
    public boolean setPDVAutomatico(boolean status) {
        String sql = "UPDATE controle SET ativo = ? WHERE id = 1";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setBoolean(1, status);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Controle_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

}
