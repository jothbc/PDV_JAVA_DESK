/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Movimento;

import JDBC.ConnectionFactoryMySQL;
import br.Oprincipio.Bean.Crediario;
import br.Oprincipio.Bean.Historico_Cred;
import br.Oprincipio.Bean.Parcela;
import br.Oprincipio.Bean.Venda_Bean;
import br.Oprincipio.DAO.Historico_CredDAO;
import br.Oprincipio.DAO.Venda_DAO;
import br.Oprincipio.Ireport.ImprimirIreport;
import br.Oprincipio.PDV.JF_PDV;
import funcoes.CDate;
import funcoes.Conv;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class RelatorioVendas extends javax.swing.JFrame {

    DefaultTableModel tableVenda, tablePOS, tableCred;
    List<ItemRelatorio> paraRelatorio;

    /**
     * Creates new form RelatorioVendas
     */
    public RelatorioVendas() {
        initComponents();
        iniciotxt.setText(CDate.DataPTBRAtual());
        fimtxt.setText(CDate.DataPTBRAtual());
        tableVenda = (DefaultTableModel) JTableVenda.getModel();
        tablePOS = (DefaultTableModel) JTablePOS.getModel();
        tableCred = (DefaultTableModel) JTableCred.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTablePOS = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        quantidadeVendastxt = new javax.swing.JTextField();
        txt_valor_total_bruto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        valorReal_dinheirotxt = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valorReal_postxt = new javax.swing.JTextField();
        valorReal_crediariotxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        valorReal_totaltxt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        valorReal_descontostxt = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        valorReal_c_descontos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        iniciotxt = new javax.swing.JFormattedTextField();
        fimtxt = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableVenda = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTableCred = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório de Vendas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("POS Recebido no Periodo"));

        JTablePOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movimento", "Origem", "Data", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTablePOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablePOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JTablePOS);
        if (JTablePOS.getColumnModel().getColumnCount() > 0) {
            JTablePOS.getColumnModel().getColumn(0).setMinWidth(50);
            JTablePOS.getColumnModel().getColumn(0).setMaxWidth(100);
            JTablePOS.getColumnModel().getColumn(0).setHeaderValue("Movimento");
        }

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Quantidade de Vendas no Período:");

        jLabel2.setText("Valor Bruto s/ desconto");

        jLabel3.setText("Valor Líquido Recebido");

        jLabel4.setText("Dinheiro");

        jLabel5.setText("POS");

        jLabel9.setText("Crediário");

        jLabel10.setText("Total");

        jLabel11.setText("Descontos:");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/1x/ic_print_24px.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setText("Total Bruto:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 8)); // NOI18N
        jLabel8.setText("*Representa totas as vendas feitas no período incluindo crediários e POS.");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorReal_totaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(60, 60, 60)
                                .addComponent(valorReal_dinheirotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorReal_postxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorReal_crediariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantidadeVendastxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorReal_descontostxt, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_valor_total_bruto, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(valorReal_c_descontos, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidadeVendastxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_valor_total_bruto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(valorReal_descontostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorReal_c_descontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(valorReal_dinheirotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(valorReal_postxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(valorReal_crediariotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(valorReal_totaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        try {
            iniciotxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        iniciotxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        iniciotxt.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        iniciotxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        try {
            fimtxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fimtxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fimtxt.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        fimtxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Data Inicial");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Data final");

        JTableVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Movimento", "Cliente", "T. Bruto", "Desc.", "Total", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableVendaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableVenda);
        if (JTableVenda.getColumnModel().getColumnCount() > 0) {
            JTableVenda.getColumnModel().getColumn(0).setMinWidth(50);
            JTableVenda.getColumnModel().getColumn(0).setMaxWidth(100);
            JTableVenda.getColumnModel().getColumn(2).setMinWidth(50);
            JTableVenda.getColumnModel().getColumn(2).setMaxWidth(100);
            JTableVenda.getColumnModel().getColumn(5).setMinWidth(100);
            JTableVenda.getColumnModel().getColumn(5).setMaxWidth(150);
        }

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/NV/check-circle-07.png"))); // NOI18N
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iniciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(fimtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(iniciotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(fimtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Crediários Recebidos no Periodo"));

        JTableCred.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Data", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableCred.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableCredMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(JTableCred);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JTableVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableVendaMouseClicked
        if (evt.getClickCount() == 2) {
            verMovimento(JTableVenda);
        }
    }//GEN-LAST:event_JTableVendaMouseClicked

    private void JTablePOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePOSMouseClicked
        if (evt.getClickCount() == 2) {
            verMovimento(JTablePOS);
        }
    }//GEN-LAST:event_JTablePOSMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        imprimirRelatorio();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        atualizarVenda();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void JTableCredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableCredMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_JTableCredMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RelatorioVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableCred;
    private javax.swing.JTable JTablePOS;
    private javax.swing.JTable JTableVenda;
    private javax.swing.JFormattedTextField fimtxt;
    private javax.swing.JFormattedTextField iniciotxt;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField quantidadeVendastxt;
    private javax.swing.JTextField txt_valor_total_bruto;
    private javax.swing.JTextField valorReal_c_descontos;
    private javax.swing.JTextField valorReal_crediariotxt;
    private javax.swing.JTextField valorReal_descontostxt;
    private javax.swing.JTextField valorReal_dinheirotxt;
    private javax.swing.JTextField valorReal_postxt;
    private javax.swing.JTextField valorReal_totaltxt;
    // End of variables declaration//GEN-END:variables

    private void atualizarVenda() {
        String inicio = iniciotxt.getText();
        String fim = fimtxt.getText();
        paraRelatorio = new ArrayList<>();
        tableVenda.setRowCount(0);
        tablePOS.setRowCount(0);
        tableCred.setRowCount(0);

        double valor_venda_total = 0;
        double valor_em_pos = 0;
        double valor_em_dinheiro = 0;
        double valor_em_crediario = 0;
        double valor_desconto = 0;

        //List<Crediario> crediarios = new Venda_DAO().findAll_CrediarioData(CDate.DataPTBRtoDataMySQL(inicio), CDate.DataPTBRtoDataMySQL(fim));
        List<Venda_Bean> vendas_periodo = new Venda_DAO().getVendasPorData(CDate.DataPTBRtoDataMySQL(inicio), CDate.DataPTBRtoDataMySQL(fim), false);
        if (!vendas_periodo.isEmpty()) {
            for (Venda_Bean v : vendas_periodo) {
                Object[] dado = {v.getMovimento(), v.getCliente().getNome(), Conv.validarValue(v.getTotal()), Conv.validarValue(v.getDesconto()), Conv.validarValue(v.getTotal() - v.getDesconto()), v.getData()};
                tableVenda.addRow(dado);
                valor_desconto += v.getDesconto();
                valor_venda_total += v.getTotal();
                valor_em_dinheiro += v.getDinheiro() - v.getTroco();
                if (v.getDinheiro() - v.getTroco() > 0) {
                    /*
                    Isso me garante que para o meu relatório eu vou informar
                    as vendas que foram recebidas em dinheiro, pois é a necessidade do cliente.
                    Vendas recebidas em forma de crediário nao entram necessáriamente no relatório
                    pois esses valores ainda nao foram recebidos no periodo.
                     */
                    paraRelatorio.add(new ItemRelatorio(ItemRelatorio.TIPO_DINHEIRO, v.getMovimento(), v.getDinheiro() - v.getTroco(), v.getData(), v.getCliente().getNome()));
                }
            }
        }
        List<Historico_Cred> hist_cred = new Historico_CredDAO().getHistPeriodo(inicio, fim);
        if (!hist_cred.isEmpty()) {
            for (Historico_Cred h : hist_cred) {
                Object[] dado = {h.getCliente().getNome(), h.getData(), "R$ " + Conv.validarValue(h.getValor())};
                tableCred.addRow(dado);
                valor_em_crediario += h.getValor();
                paraRelatorio.add(new ItemRelatorio(ItemRelatorio.TIPO_CREDIARIO,0,h.getValor(),h.getData(),h.getCliente().getNome()));
            }
        }
        List<Parcela> parcelas = new Venda_DAO().getParcelas_Periodo(CDate.DataPTBRtoDataMySQL(inicio), CDate.DataPTBRtoDataMySQL(fim));
        if (!parcelas.isEmpty()) {
            for (Parcela p : parcelas) {
                valor_em_pos += p.getValor();
                Object[] dado = {p.getMov(), "POS", p.getData(), p.getValor()};
                tablePOS.addRow(dado);
                paraRelatorio.add(new ItemRelatorio(ItemRelatorio.TIPO_POS, p.getMov(), p.getValor(), p.getData(), p.getNome_cliente()));
            }
        }
        valorReal_dinheirotxt.setText("R$ " + Conv.validarValue(valor_em_dinheiro));
        //valores vindos de outras datas
        valorReal_postxt.setText("R$ " + Conv.validarValue(valor_em_pos));
        valorReal_crediariotxt.setText("R$ " + Conv.validarValue(valor_em_crediario));
        //**//
        valorReal_totaltxt.setText("R$ " + Conv.validarValue((valor_em_dinheiro + valor_em_pos + valor_em_crediario)));
        valorReal_descontostxt.setText("R$ " + Conv.validarValue(valor_desconto));
        quantidadeVendastxt.setText(Integer.toString(tableVenda.getRowCount()));
        txt_valor_total_bruto.setText("R$ " + Conv.validarValue(valor_venda_total));
        valorReal_c_descontos.setText("R$ " + Conv.validarValue(valor_venda_total - valor_desconto));

    }

    private void verMovimento(JTable j) {
        int mov = (int) j.getValueAt(j.getSelectedRow(), 0);
        Venda_Bean venda_ = new Venda_DAO().getVenda(mov);
        JD_Movimento jd = new JD_Movimento(this, true, venda_);
        jd.setVisible(true);
    }

    private void imprimirMovimentoVendas() {
        if (JTableVenda.getSelectedRow() >= 0) {
            ImprimirIreport.thisMov((int) JTableVenda.getValueAt(JTableVenda.getSelectedRow(), 0));
        }
    }

    private void imprimirMovimentoPOSCrediario() {
        if (JTablePOS.getSelectedRow() >= 0) {
            ImprimirIreport.thisMov((int) JTablePOS.getValueAt(JTablePOS.getSelectedRow(), 0));
        }
    }

    private void imprimirRelatorio() {
        try {
            String src = "res/RelatorioVendas.jasper";
            JasperPrint js;
            /*
                para nao dar erro quando abrir o relatorio caso o "paraRelatorio" seja nulo
                é instanciado novamente e adicionado uma venda vazia.
             */
            if (paraRelatorio == null) {
                paraRelatorio = new ArrayList<>();
                paraRelatorio.add(new ItemRelatorio());
            }
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(paraRelatorio);

            HashMap<String, Object> map = new HashMap<>();
            map.put("inicial", iniciotxt.getText());
            map.put("final", fimtxt.getText());
            map.put("v_bruto_vendas", valorReal_c_descontos.getText());
            map.put("vendas_periodo", quantidadeVendastxt.getText());
            map.put("v_liquido_dinheiro", valorReal_dinheirotxt.getText());
            map.put("v_liquido_crediario", valorReal_crediariotxt.getText());
            map.put("v_liquido_desconto", valorReal_descontostxt.getText());
            map.put("v_liquido_pos", valorReal_postxt.getText());
            map.put("v_liquido_total", valorReal_totaltxt.getText());
            js = JasperFillManager.fillReport(src, map, ds);
            JasperViewer vw = new JasperViewer(js, false);
            vw.setTitle("Relatório de Vendas");
            vw.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
