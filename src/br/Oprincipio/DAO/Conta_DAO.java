/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Conta_Bean;
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
public class Conta_DAO {

    Connection con = null;

    public Conta_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean addConta(Conta_Bean c) {
        String sql = "INSERT INTO contas (descricao,valor,vencimento) VALUES (?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, c.getDescricao());
            stmt.setDouble(2, c.getValor());
            if (c.getVencimento(Conta_Bean.SQL) != null) {
                stmt.setString(3, c.getVencimento(Conta_Bean.SQL));
            }else{
                stmt.setString(3, null);
            }
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean pagarConta(int id) {
        String sql = "UPDATE contas SET pago = ? WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CDate.DataPTBRtoDataMySQL(CDate.DataPTBRAtual()));
            stmt.setInt(2, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public boolean removerConta(int id) {
        String sql = "DELETE FROM contas WHERE id = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conta_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Conta_Bean> findAll() {
        String sql = "SELECT * FROM contas ORDER BY vencimento";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Conta_Bean> contas = new ArrayList<>();
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Conta_Bean c = new Conta_Bean();
                c.setId(rs.getInt("id"));
                c.setDescricao(rs.getString("descricao"));
                c.setValor(rs.getDouble("valor"));
                String vencimento, pago;
                vencimento = rs.getString("vencimento");
                pago = rs.getString("pago");
                if (vencimento != null) {
                    c.setVencimento(CDate.DataMySQLtoDataStringPT(vencimento));
                }
                if (pago != null) {
                    c.setPago(CDate.DataMySQLtoDataStringPT(pago));
                }
                contas.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conta_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return contas;
    }

    public double getTotalAberto(){
        String sql = "SELECT valor FROM contas WHERE pago is null";
        PreparedStatement stmt = null;
        ResultSet rs= null;
        double total =0;
        try {
            stmt= con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                total+=rs.getDouble("valor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conta_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return total;
    }
}
