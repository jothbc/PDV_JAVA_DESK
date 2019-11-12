/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.Oprincipio.Cliente;

import br.Oprincipio.Bean.Cliente_Bean;
import br.Oprincipio.DAO.Cliente_DAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JD_CadastroCliente extends javax.swing.JDialog {

    List<Cliente_Bean> clientes;
    boolean existente;

    /**
     * Creates new form Cadastro_JD
     *
     * @param parent
     * @param modal
     * @param c
     */
    public JD_CadastroCliente(java.awt.Frame parent, boolean modal, Cliente_Bean c) {
        super(parent, modal);
        initComponents();
        iniciaFrm();
        testarCliente(c);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        novobtn = new javax.swing.JButton();
        gravarbtn = new javax.swing.JButton();
        cancelarbtn = new javax.swing.JButton();
        excluirbtn = new javax.swing.JButton();
        procurarbtn = new javax.swing.JButton();
        anivertf = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cdSpinner = new javax.swing.JSpinner();
        nomelbl = new javax.swing.JTextField();
        cpflbl = new javax.swing.JFormattedTextField();
        telefonelbl = new javax.swing.JTextField();
        emaillbl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        novotxt = new javax.swing.JLabel();
        procurartxt = new javax.swing.JLabel();
        gravartxt = new javax.swing.JLabel();
        cancelartxt = new javax.swing.JLabel();
        excluirtxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        novobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novobtnActionPerformed(evt);
            }
        });

        gravarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gravarbtnActionPerformed(evt);
            }
        });

        cancelarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarbtnActionPerformed(evt);
            }
        });

        excluirbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirbtnActionPerformed(evt);
            }
        });

        procurarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarbtnActionPerformed(evt);
            }
        });

        try {
            anivertf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        anivertf.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("CPF");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telefone");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("E-Mail");

        cdSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        try {
            cpflbl.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cpflbl.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Aniversário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Código");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        novotxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        novotxt.setForeground(new java.awt.Color(255, 255, 255));
        novotxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        novotxt.setText("Novo");
        novotxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                novotxtMouseClicked(evt);
            }
        });

        procurartxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        procurartxt.setForeground(new java.awt.Color(255, 255, 255));
        procurartxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        procurartxt.setText("Procurar");
        procurartxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                procurartxtMouseClicked(evt);
            }
        });

        gravartxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        gravartxt.setForeground(new java.awt.Color(255, 255, 255));
        gravartxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gravartxt.setText("Gravar");
        gravartxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gravartxtMouseClicked(evt);
            }
        });

        cancelartxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelartxt.setForeground(new java.awt.Color(255, 255, 255));
        cancelartxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelartxt.setText("Cancelar");
        cancelartxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelartxtMouseClicked(evt);
            }
        });

        excluirtxt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        excluirtxt.setForeground(new java.awt.Color(255, 255, 255));
        excluirtxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        excluirtxt.setText("Excluir");
        excluirtxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                excluirtxtMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(novotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(procurartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(gravartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(cancelartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(excluirtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(novotxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(procurartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gravartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelartxt, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(excluirtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomelbl)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cdSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpflbl)
                            .addComponent(telefonelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anivertf, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(emaillbl))
                .addGap(154, 154, 154)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cancelarbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(gravarbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(procurarbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(novobtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(excluirbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(novobtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(procurarbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gravarbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelarbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(excluirbtn)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cdSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nomelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(anivertf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cpflbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(telefonelbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(emaillbl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void novobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novobtnActionPerformed
        // TODO add your handling code here:
        int max = 0;
        for (Cliente_Bean c : clientes) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        max++;
        cdSpinner.setValue(max);
        statusLbls(true);
        cdSpinner.setEnabled(false);
        statusBtn(false);
        
        gravarbtn.setEnabled(true);
        gravartxt.setVisible(true);
        
        cancelarbtn.setEnabled(true);
        cancelartxt.setVisible(true);
        
        existente = false;
        nomelbl.requestFocus();
    }//GEN-LAST:event_novobtnActionPerformed

    private void gravarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gravarbtnActionPerformed
        gravar();
    }//GEN-LAST:event_gravarbtnActionPerformed

    private void cancelarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarbtnActionPerformed
        limparLbls();
        statusLbls(false);
        statusBtnInicial();
        existente = false;
    }//GEN-LAST:event_cancelarbtnActionPerformed

    private void excluirbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirbtnActionPerformed
        if (existente) {
            int op = -1;
            op = JOptionPane.showOptionDialog(null, "Deseja realmente excluir esse cliente?\nCaso tenha valores em aberto tudo sera apagado!", "Exclusão Segura", JOptionPane.YES_NO_CANCEL_OPTION, 1, null, null, null);
            if (op == 0) {
                if (new Cliente_DAO().delete((int) cdSpinner.getValue())) {
                    JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao tentar excluir cliente do banco de dados!");
                }
            }
        }
        statusBtnInicial();
    }//GEN-LAST:event_excluirbtnActionPerformed

    private void procurarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarbtnActionPerformed
        JD_BuscaCliente jd = new JD_BuscaCliente(null, true,false);
        jd.setVisible(true);
        if (jd.cliente != null) {
            testarCliente(jd.cliente);
        }
        //
    }//GEN-LAST:event_procurarbtnActionPerformed

    private void novotxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_novotxtMouseClicked
        novobtnActionPerformed(null);
    }//GEN-LAST:event_novotxtMouseClicked

    private void procurartxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_procurartxtMouseClicked
        procurarbtnActionPerformed(null);
    }//GEN-LAST:event_procurartxtMouseClicked

    private void gravartxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gravartxtMouseClicked
        gravarbtnActionPerformed(null);
    }//GEN-LAST:event_gravartxtMouseClicked

    private void cancelartxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelartxtMouseClicked
        cancelarbtnActionPerformed(null);
    }//GEN-LAST:event_cancelartxtMouseClicked

    private void excluirtxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_excluirtxtMouseClicked
        excluirbtnActionPerformed(null);
    }//GEN-LAST:event_excluirtxtMouseClicked

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
            java.util.logging.Logger.getLogger(JD_CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JD_CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JD_CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JD_CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JD_CadastroCliente dialog = new JD_CadastroCliente(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField anivertf;
    private javax.swing.JButton cancelarbtn;
    private javax.swing.JLabel cancelartxt;
    private javax.swing.JSpinner cdSpinner;
    private javax.swing.JFormattedTextField cpflbl;
    private javax.swing.JTextField emaillbl;
    private javax.swing.JButton excluirbtn;
    private javax.swing.JLabel excluirtxt;
    private javax.swing.JButton gravarbtn;
    private javax.swing.JLabel gravartxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nomelbl;
    private javax.swing.JButton novobtn;
    private javax.swing.JLabel novotxt;
    private javax.swing.JButton procurarbtn;
    private javax.swing.JLabel procurartxt;
    private javax.swing.JTextField telefonelbl;
    // End of variables declaration//GEN-END:variables
    private void iniciaFrm() {
        statusLbls(false);
        statusBtnInicial();
        try {
            clientes = new Cliente_DAO().findAll();
        } catch (Exception ex) {
            Logger.getLogger(JD_CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void statusLbls(boolean status) {
        cdSpinner.setEnabled(status);
        nomelbl.setEnabled(status);
        cpflbl.setEnabled(status);
        telefonelbl.setEnabled(status);
        emaillbl.setEnabled(status);
        anivertf.setEnabled(status);
    }

    private void statusBtn(boolean status) {
        novobtn.setEnabled(status);
        novotxt.setVisible(status);
        
        procurarbtn.setEnabled(status);
        procurartxt.setVisible(status);
        
        gravarbtn.setEnabled(status);
        gravartxt.setVisible(status);
        
        cancelarbtn.setEnabled(status);
        cancelartxt.setVisible(status);
        
        excluirbtn.setEnabled(status);
        excluirtxt.setVisible(status);
    }

    private void limparLbls() {
        nomelbl.setText("");
        cpflbl.setText("");
        telefonelbl.setText("");
        emaillbl.setText("");
        anivertf.setText("");
    }

    private void statusBtnInicial() {
        limparLbls();
        statusLbls(false);
        
        novobtn.setEnabled(true);
        novotxt.setVisible(true);
        
        procurarbtn.setEnabled(true);
        procurartxt.setVisible(true);
        
        gravarbtn.setEnabled(false);
        gravartxt.setVisible(false);
        
        cancelarbtn.setEnabled(false);
        cancelartxt.setVisible(false);
        
        excluirbtn.setEnabled(false);
        excluirtxt.setVisible(false);
    }

    private void testarCliente(Cliente_Bean c) {
        if (c != null) {
            cdSpinner.setValue(c.getId());
            nomelbl.setText(c.getNome());
            cpflbl.setText(c.getCpf());
            telefonelbl.setText(c.getTelefone());
            emaillbl.setText(c.getEmail());
            anivertf.setText(c.getAniversario(c.BR));
            existente = true;
            statusBtn(true);
            
            novobtn.setEnabled(false);
            novotxt.setVisible(false);
            
            statusLbls(true);
            cdSpinner.setEnabled(false);
        }
    }

    private void gravar() {
        try {
            Cliente_Bean nv = new Cliente_Bean();
            nv.setNome(nomelbl.getText());
            if (!cpflbl.getText().equals("   .   .   -  ")) {
                nv.setCpf(cpflbl.getText());
            }
            if (!telefonelbl.getText().equals("")) {
                nv.setTelefone(telefonelbl.getText());
            }
            if (!emaillbl.getText().equals("")) {
                nv.setEmail(emaillbl.getText());
            }
            if (!anivertf.getText().equals("  /  /    ")) {
                nv.setAniversario(anivertf.getText(), nv.BR);
            }
            if (!existente) {
                if (new Cliente_DAO().insertInto(nv)) {
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                    statusBtnInicial();
                    clientes = new Cliente_DAO().findAll();
                }
            } else if (existente) {
                nv.setId((int) cdSpinner.getValue());
                if (new Cliente_DAO().update(nv)) {
                    JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
                    statusBtnInicial();
                    clientes = new Cliente_DAO().findAll();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JF_CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro ao Gravar", JOptionPane.ERROR_MESSAGE);
        }
    }
}
