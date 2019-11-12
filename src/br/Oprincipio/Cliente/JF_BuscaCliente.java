/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Cliente;

import br.Oprincipio.Bean.Cliente_Bean;
import br.Oprincipio.DAO.Cliente_DAO;
import funcoes.CDate;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class JF_BuscaCliente extends javax.swing.JFrame {

    List<Cliente_Bean> clientes;
    DefaultTableModel tb;

    /**
     * Creates new form Busca_JF
     */
    public JF_BuscaCliente() {
        initComponents();
        try {
            clientes = new Cliente_DAO().findAll();
        } catch (Exception ex) {
            Logger.getLogger(JF_BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        tb = (DefaultTableModel) jTable1.getModel();
        jTable1.setRowSorter(new TableRowSorter<>(tb));
        preencherTB();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jC = new javax.swing.JComboBox<>();
        tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "E-Mail", "Aniversario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.util.Date.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(1);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(100);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(120);
        }

        jC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "CPF", "Telefone", "E-Mail" }));

        tf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jC, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tf)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfKeyPressed
        atualizarTB();
    }//GEN-LAST:event_tfKeyPressed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jTable1.getSelectedRow() >= 0) {
                try {
                    Cliente_Bean c = new Cliente_Bean();
                    int index = jTable1.getSelectedRow();
                    c.setId((int) jTable1.getValueAt(index, 0));
                    c.setNome((String) jTable1.getValueAt(index, 1));
                    c.setCpf((String) jTable1.getValueAt(index, 2));
                    c.setTelefone((String) jTable1.getValueAt(index, 3));
                    c.setEmail((String) jTable1.getValueAt(index, 4));
                    c.setAniversario(CDate.DataMySQLtoDataStringPT((Date) jTable1.getValueAt(index, 5)), c.BR);
                    JF_CadastroCliente fm = new JF_CadastroCliente(c);
                    fm.setVisible(true);
                    this.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(JF_BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }//GEN-LAST:event_jTable1KeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JF_BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JF_BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JF_BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JF_BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JF_BuscaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tf;
    // End of variables declaration//GEN-END:variables
    private void preencherTB() {
        tb.setRowCount(0);
        for (Cliente_Bean c : clientes) {
            try {
                Object[] dado = {c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail(),c.getAniversarioDate()};
                tb.addRow(dado);
            } catch (Exception ex) {
                Logger.getLogger(JF_BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Cliente nao pode ser exibido devido a um erro no c.getAniversarioDate()\n"+c.getNome());
            }
        }
    }

    private void preencherTB(int op) {
        String compara = tf.getText();
        tb.setRowCount(0);
        for (Cliente_Bean c : clientes) {
            Object[] dado = {c.getId(), c.getNome(), c.getCpf(), c.getTelefone(), c.getEmail(),c.getAniversario(c.BR)};
            if (op == 0 && c.getNome().contains(compara.toUpperCase())) {
                tb.addRow(dado);
            } else if (op == 1 && c.getCpf().contains(compara)) {
                tb.addRow(dado);
            } else if (op == 2 && c.getTelefone().contains(compara)) {
                tb.addRow(dado);
            } else if (op == 3 && c.getEmail().toUpperCase().contains(compara.toUpperCase())) {
                tb.addRow(dado);
            }
        }
    }

    private void atualizarTB() {
        preencherTB(jC.getSelectedIndex());
    }
}