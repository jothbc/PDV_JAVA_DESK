/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Caixa_Bean;
import br.Oprincipio.Bean.Usuario_Bean;
import funcoes.CDate;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
public class Caixa_DAO {

    Connection con = null;

    public Caixa_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean fecharCaixa(Caixa_Bean c, double dinheiro, double pos, double crediario) {   //arrumar pois é update pra fechar caixa
        String sql = "UPDATE caixa SET dinheiro_inf = ? , pos_inf = ?, crediario_inf = ?, status = 0 WHERE seq = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, dinheiro);
            stmt.setDouble(2, pos);
            stmt.setDouble(3, crediario);
            stmt.setInt(4, c.getSeq());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
        return false;
    }

    public boolean abrirCaixa(Usuario_Bean u, int movimentoInicial, String dataPTBR, double fundo) {
        String sql = "INSERT INTO caixa(usuario_id,fundo,inicial,data,ip) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, u.getId());
            stmt.setDouble(2, fundo);
            stmt.setInt(3, movimentoInicial);
            stmt.setString(4, CDate.DataPTBRtoDataMySQL(dataPTBR));
            stmt.setString(5, InetAddress.getLocalHost().getHostAddress());
            stmt.execute();
            return true;
        } catch (SQLException | UnknownHostException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
        return false;
    }

    /*
    *retorna true se tiver um caixa aberto e false se nao estiver
     */
    public boolean verificarSeEstaEmAberto() {
        String sql = "SELECT * FROM caixa where ip = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, InetAddress.getLocalHost().getHostAddress());
            rs = stmt.executeQuery();
            rs.last();
            return rs.getBoolean("status");
        } catch (SQLException | UnknownHostException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return false;
    }

    public Caixa_Bean getCaixaAberto() {
        String sql = "SELECT * FROM caixa where ip = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Caixa_Bean caixa = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, InetAddress.getLocalHost().getHostAddress());
            rs = stmt.executeQuery();
            rs.last();
            caixa = new Caixa_Bean();
            caixa.setSeq(rs.getInt("seq"));
            caixa.setCrediario(rs.getDouble("crediario"));
            caixa.setCredito(rs.getDouble("credito"));
            caixa.setData(CDate.DataMySQLtoDataStringPT(rs.getString("data")));
            caixa.setDebito(rs.getDouble("debito"));
            caixa.setDinheiro(rs.getDouble("dinheiro"));
            caixa.setFundo(rs.getDouble("fundo"));
            caixa.setIp(rs.getString("ip"));
            caixa.setMovimento_final(rs.getInt("final"));
            caixa.setMovimento_inicial(rs.getInt("inicial"));
            caixa.setSangria(rs.getDouble("sangria"));
            caixa.setSituacao(rs.getBoolean("status"));
            caixa.setSuprimento(rs.getDouble("suprimento"));
            Usuario_Bean usuario = new Usuario_Bean();
            usuario.setId(rs.getInt("usuario_id"));
            caixa.setUsuario(usuario);

        } catch (SQLException | UnknownHostException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        caixa.setUsuario(new Usuario_DAO().getUsuario(caixa.getUsuario().getId()));
        return caixa;
    }

    public boolean addinfoCaixa(Caixa_Bean caixa) {
        String sql = "UPDATE caixa SET dinheiro = dinheiro + ?, credito = credito + ?"
                + ",debito = debito + ?, crediario = crediario + ? WHERE seq = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, caixa.getDinheiro());
            stmt.setDouble(2, caixa.getCredito());
            stmt.setDouble(3, caixa.getDebito());
            stmt.setDouble(4, caixa.getCrediario());
            stmt.setInt(5, caixa.getSeq());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    public boolean fazerSangria(double valor,int seq){
        String sql = "UPDATE caixa SET sangria = sangria + ? WHERE seq = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setInt(2, seq);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }
    public boolean colocarSuprimento(double valor,int seq){
        String sql = "UPDATE caixa SET suprimento = suprimento+ ? WHERE seq = ?";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDouble(1, valor);
            stmt.setInt(2, seq);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Caixa_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

}
