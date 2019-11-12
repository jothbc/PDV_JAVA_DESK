/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Usuario_Bean;
import funcoes.CriptografiaMD5;
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
public class Usuario_DAO {

    Connection con = null;

    public Usuario_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean addUsuario(Usuario_Bean u) {
        String sql = "INSERT INTO usuario (nome,senha,privilegio) VALUES (?,?,?)";
        PreparedStatement stmt= null;
        try {
            stmt= con.prepareStatement(sql);
            stmt.setString(1, u.getNome().toUpperCase());
            stmt.setString(2, CriptografiaMD5.criptografar(u.getSenha()));
            stmt.setBoolean(3, u.isPrivilegio());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    
    public boolean removeUsuario (int id){
        String sql = "DELETE FROM usuario WHERE id= ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    
    public List<Usuario_Bean> findAll(){
        List<Usuario_Bean> users = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()){
                Usuario_Bean u = new Usuario_Bean();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome").toUpperCase());
                u.setSenha(rs.getString("senha"));  //retorna senha criptografada em MD5
                u.setPrivilegio(rs.getBoolean("privilegio"));
                users.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return users;
    }

    public Usuario_Bean getUsuario(int id){
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                Usuario_Bean u = new Usuario_Bean();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome").toUpperCase());
                u.setSenha(rs.getString("senha")); //retorna senha criptografada em MD5
                u.setPrivilegio(rs.getBoolean("privilegio"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }
    
    public Usuario_Bean getUsuario(String nome){
        String sql = "SELECT * FROM usuario WHERE nome = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome.toUpperCase());
            rs = stmt.executeQuery();
            while (rs.next()){
                Usuario_Bean u = new Usuario_Bean();
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome").toUpperCase());
                u.setSenha(rs.getString("senha"));  //retorna senha criptografada em MD5
                u.setPrivilegio(rs.getBoolean("privilegio"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return null;
    }

    public boolean updateUsuario(Usuario_Bean u) {
        String sql = "UPDATE usuario SET senha = ?, privilegio = ? WHERE id = ?";
        PreparedStatement stmt= null;
        try {
            stmt= con.prepareStatement(sql);
            stmt.setString(1, CriptografiaMD5.criptografar(u.getSenha()));
            stmt.setBoolean(2, u.isPrivilegio());
            stmt.setInt(3, u.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    
}
