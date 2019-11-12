/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.POS_Bean;
import br.Oprincipio.Bean.Parcela;
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
public class POS_DAO {

    Connection con;
    PreparedStatement stmt;
    String sql;
    ResultSet rs;

    public POS_DAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public POS_Bean getPOS(int mov) {
        POS_Bean pos = null;
        sql = "SELECT * FROM pagamento_pos WHERE movimento = ? ORDER BY parcela_data";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mov);
            rs = stmt.executeQuery();
            pos = new POS_Bean();
            while (rs.next()) {
                if (rs.isFirst()) {
                    pos.setSeq_ini(rs.getInt("seq"));
                } else if (rs.isLast()) {
                    pos.setSeq_final(rs.getInt("seq"));
                }
                pos.setTotal(rs.getDouble("valor_total"));
                pos.addParcela(CDate.DataMySQLtoDataStringPT(rs.getString("parcela_data")), rs.getDouble("valor_parcela"));
            }
            pos.setMovimento(mov);
        } catch (SQLException ex) {
            Logger.getLogger(POS_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return pos;
    }

    public boolean setPOS(POS_Bean p) {
        sql = "INSERT INTO pagamento_pos (movimento,parcela_data,valor_total,valor_parcela) VALUES (?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, p.getMovimento());
            stmt.setDouble(3, p.getTotal());
            for (Parcela pa : p.getParcela()) {
                stmt.setString(2, CDate.DataPTBRtoDataMySQL(pa.getData()));
                stmt.setDouble(4, pa.getValor());
                stmt.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(POS_DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

}
