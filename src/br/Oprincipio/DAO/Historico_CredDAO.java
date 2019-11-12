/*
 * Copyright (c) 2019, Jonathan
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package br.Oprincipio.DAO;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Cliente_Bean;
import br.Oprincipio.Bean.Historico_Cred;
import funcoes.CDate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan
 */
public class Historico_CredDAO extends DAO {

    public Historico_CredDAO() {
        con = ConnectionFactoryMySQL.getConnection();
    }

    public boolean addHist(Historico_Cred hist) {
        sql = "INSERT INTO historiro_cred (nome,valor,dia) VALUES (?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, hist.getCliente().getNome());
            stmt.setDouble(2, hist.getValor());
            stmt.setString(3, CDate.DataPTBRtoDataMySQL(hist.getData()));
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Historico_CredDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt);
        }
    }

    public List<Historico_Cred> getHistPeriodo(String inicio, String fim) {
        List<Historico_Cred> historico = new ArrayList<>();
        sql = "SELECT * FROM historiro_cred WHERE dia>= ? AND dia<= ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, CDate.DataPTBRtoDataMySQL(inicio));
            stmt.setString(2, CDate.DataPTBRtoDataMySQL(fim));
            rs = stmt.executeQuery();
            while (rs.next()) {
                historico.add(getHistoricoResultSet(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Historico_CredDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactoryMySQL.closeConnection(con, stmt, rs);
        }
        return historico;
    }

    private Historico_Cred getHistoricoResultSet(ResultSet rs) {
        try {
            Historico_Cred hist = new Historico_Cred();
            hist.setId(rs.getInt("id"));
            hist.setCliente(new Cliente_Bean(rs.getString("nome")));
            hist.setValor(rs.getDouble("valor"));
            hist.setData(CDate.DataMySQLtoDataStringPT(rs.getString("dia")));
            return hist;
        } catch (SQLException e) {
            return null;
        }
    }

}
