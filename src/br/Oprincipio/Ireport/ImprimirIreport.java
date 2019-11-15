/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Ireport;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.DAO.Venda_DAO;
import br.Oprincipio.PDV.JF_PDV;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class ImprimirIreport {

    public static void thisMov(int mov) {
        boolean cred = new Venda_DAO().movCred(mov);
        Connection c = ConnectionFactoryMySQL.getConnection();
        String src;
        if (cred) {
            src = "res/CrediarioJs.jasper";
        } else {
            src = "res/CupomJs.jasper";
        }
        JasperPrint js;
        HashMap<String, Object> map = new HashMap<>();
        map.put("mov", mov);
        try {
            js = JasperFillManager.fillReport(src, map, c);
            JasperViewer vw = new JasperViewer(js, false);
            vw.setTitle("Cupom - O Principio");
            vw.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(JF_PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactoryMySQL.closeConnection(c);
    }

    public static void thisRelatorioEstoque(int i) {
        Connection c = ConnectionFactoryMySQL.getConnection();
        String src;
        switch (i) {
            case 1:
                src = "res/RelatórioTotal.jasper";
                break;
            case 2:
                src = "res/RelatórioPositivo.jasper";
                break;
            case 3:
                src = "res/RelatórioNegativo.jasper";
                break;
            case 4:
                src = "res/RelatórioMinimo.jasper";
                break;
            default:
                src = "res/RelatórioTotal.jasper";
                break;
        }
        JasperPrint js;
        try {
            js = JasperFillManager.fillReport(src, null, c);
            JasperViewer vw = new JasperViewer(js, false);
            vw.setTitle("Relatório do Estoque - O Principio");
            vw.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(JF_PDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnectionFactoryMySQL.closeConnection(c);
    }
    
    public static void RelatorioVenda(String data_inicio,String data_fim){
        
    }
}
