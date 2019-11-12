/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.ContasOutros;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 *
 * @author User
 */
public class CellRenderPago extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1); //To change body of generated methods, choose Tools | Templates.
        Object ref = jtable.getValueAt(i, 4);
        if (ref != null) {
            setBackground(Color.yellow);
            setForeground(Color.red);
        }else{
            setBackground(Color.white);
            setForeground(Color.black);
        }
        return this;
    }
}
