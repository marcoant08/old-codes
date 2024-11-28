
package Visão;

import ModeloConnection.ConexãoDB;

public class TelaPrincipal extends javax.swing.JFrame {

    ConexãoDB conect = new ConexãoDB();
    
    public TelaPrincipal() {
        initComponents();
        conect.conexao();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrameBemVindo = new javax.swing.JInternalFrame();
        jPanelInternal = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCadMed = new javax.swing.JButton();
        jButtonCadEnf = new javax.swing.JButton();
        jButtonCadPac = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonAgenda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPainelFundo = new javax.swing.JLabel();
        jButtonFecharBemVindo = new javax.swing.JButton();
        jLabelFundoPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuItemMédicos = new javax.swing.JMenuItem();
        jMenuItemPacientes = new javax.swing.JMenuItem();
        jMenuItemEnfermeiras = new javax.swing.JMenuItem();
        jMenuItemCadUsuarios = new javax.swing.JMenuItem();
        jMenuRelatórios = new javax.swing.JMenu();
        jMenuFerramentas = new javax.swing.JMenu();
        jMenuItemTelaBemVindo = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jInternalFrameBemVindo.setTitle("Bem-Vindo");
        jInternalFrameBemVindo.setVisible(true);
        jInternalFrameBemVindo.getContentPane().setLayout(null);

        jPanelInternal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelInternal.setLayout(null);

        jLabel2.setText("Cadastros -");
        jPanelInternal.add(jLabel2);
        jLabel2.setBounds(10, 0, 70, 14);

        jButtonCadMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Doctor_Male_icon-icons.com_75051.png"))); // NOI18N
        jButtonCadMed.setToolTipText("Médicos");
        jButtonCadMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadMedActionPerformed(evt);
            }
        });
        jPanelInternal.add(jButtonCadMed);
        jButtonCadMed.setBounds(10, 20, 100, 120);

        jButtonCadEnf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/nurse_icon-icons.com_66062.png"))); // NOI18N
        jButtonCadEnf.setToolTipText("Enfermeiras");
        jButtonCadEnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadEnfActionPerformed(evt);
            }
        });
        jPanelInternal.add(jButtonCadEnf);
        jButtonCadEnf.setBounds(110, 20, 100, 120);

        jButtonCadPac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cadPacientes.png"))); // NOI18N
        jButtonCadPac.setToolTipText("Pacientes");
        jPanelInternal.add(jButtonCadPac);
        jButtonCadPac.setBounds(210, 20, 100, 120);

        jLabel3.setText("Agenda - ");
        jPanelInternal.add(jLabel3);
        jLabel3.setBounds(10, 150, 60, 14);

        jButtonAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Agenda.png"))); // NOI18N
        jButtonAgenda.setToolTipText("Agendamentos");
        jPanelInternal.add(jButtonAgenda);
        jButtonAgenda.setBounds(10, 170, 110, 110);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fundo-de-grade-hexagonal_52683-327.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanelInternal.add(jLabel4);
        jLabel4.setBounds(0, 0, 550, 310);

        jInternalFrameBemVindo.getContentPane().add(jPanelInternal);
        jPanelInternal.setBounds(0, 70, 550, 320);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sistema de Gerenciamento de:");
        jInternalFrameBemVindo.getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 250, 30);
        jInternalFrameBemVindo.getContentPane().add(jLabelPainelFundo);
        jLabelPainelFundo.setBounds(10, 70, 550, 310);

        jButtonFecharBemVindo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/exit.png"))); // NOI18N
        jButtonFecharBemVindo.setToolTipText("Fechar Tela de Bem-Vindo");
        jButtonFecharBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharBemVindoActionPerformed(evt);
            }
        });
        jInternalFrameBemVindo.getContentPane().add(jButtonFecharBemVindo);
        jButtonFecharBemVindo.setBounds(390, 10, 50, 40);

        getContentPane().add(jInternalFrameBemVindo);
        jInternalFrameBemVindo.setBounds(0, 60, 570, 410);

        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/esboco-de-conceito-de-educacao_1284-7335.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, -10, 570, 470);

        jMenuCadastro.setText("Cadastro");

        jMenuItemMédicos.setText("Médicos");
        jMenuItemMédicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMédicosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemMédicos);

        jMenuItemPacientes.setText("Pacientes");
        jMenuItemPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPacientesActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemPacientes);

        jMenuItemEnfermeiras.setText("Enfermeiras");
        jMenuItemEnfermeiras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEnfermeirasActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemEnfermeiras);

        jMenuItemCadUsuarios.setText("Usuarios");
        jMenuItemCadUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadUsuariosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuItemCadUsuarios);

        jMenuBar1.add(jMenuCadastro);

        jMenuRelatórios.setText("Relatórios");
        jMenuBar1.add(jMenuRelatórios);

        jMenuFerramentas.setText("Ferramentas");

        jMenuItemTelaBemVindo.setText("Tela Bem-Vindo");
        jMenuItemTelaBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTelaBemVindoActionPerformed(evt);
            }
        });
        jMenuFerramentas.add(jMenuItemTelaBemVindo);

        jMenuBar1.add(jMenuFerramentas);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(586, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemMédicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMédicosActionPerformed
       FormMédico tela = new FormMédico();
       tela.setVisible(true);
       
    }//GEN-LAST:event_jMenuItemMédicosActionPerformed

    private void jMenuItemPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPacientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemPacientesActionPerformed

    private void jMenuItemEnfermeirasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEnfermeirasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemEnfermeirasActionPerformed

    private void jButtonCadMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadMedActionPerformed
        FormMédico tela = new FormMédico();
        tela.setVisible(true);
    }//GEN-LAST:event_jButtonCadMedActionPerformed

    private void jButtonCadEnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadEnfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCadEnfActionPerformed

    private void jButtonFecharBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharBemVindoActionPerformed
        jInternalFrameBemVindo.dispose();
    }//GEN-LAST:event_jButtonFecharBemVindoActionPerformed

    private void jMenuItemTelaBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTelaBemVindoActionPerformed
        jInternalFrameBemVindo.setVisible(true);
    }//GEN-LAST:event_jMenuItemTelaBemVindoActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void jMenuItemCadUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadUsuariosActionPerformed
        FormUsuario tela = new FormUsuario();
        tela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgenda;
    private javax.swing.JButton jButtonCadEnf;
    private javax.swing.JButton jButtonCadMed;
    private javax.swing.JButton jButtonCadPac;
    private javax.swing.JButton jButtonFecharBemVindo;
    private javax.swing.JInternalFrame jInternalFrameBemVindo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelFundoPrincipal;
    private javax.swing.JLabel jLabelPainelFundo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuFerramentas;
    private javax.swing.JMenuItem jMenuItemCadUsuarios;
    private javax.swing.JMenuItem jMenuItemEnfermeiras;
    private javax.swing.JMenuItem jMenuItemMédicos;
    private javax.swing.JMenuItem jMenuItemPacientes;
    private javax.swing.JMenuItem jMenuItemTelaBemVindo;
    private javax.swing.JMenu jMenuRelatórios;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JPanel jPanelInternal;
    // End of variables declaration//GEN-END:variables
}
