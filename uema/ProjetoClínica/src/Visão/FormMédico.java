
package Visão;

import ModeloConnection.ConexãoDB;
import ModeloDao.DaoMedico;
import ModeloBeans.BeansMedico;
import ModeloBeans.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class FormMédico extends javax.swing.JFrame {

   BeansMedico mod = new BeansMedico();
   DaoMedico control = new DaoMedico();
   ConexãoDB conex = new ConexãoDB();
   int flag = 0;
    
    public FormMédico() {
        initComponents();
        preencherTabela("select *from medicos order by nome_medico");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelID = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelCRM = new javax.swing.JLabel();
        jLabelEspecialização = new javax.swing.JLabel();
        jFormattedTextFieldCRM = new javax.swing.JFormattedTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxEspecialização = new javax.swing.JComboBox<>();
        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMédico = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jLabelCadMédicos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelNome.setText("Nome:");

        jLabelCRM.setText("CRM:");

        jLabelEspecialização.setText("Especialização:");

        jFormattedTextFieldCRM.setEnabled(false);
        jFormattedTextFieldCRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldCRMActionPerformed(evt);
            }
        });

        jTextFieldNome.setEnabled(false);
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jComboBoxEspecialização.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cirurgião", "Oncólogo", "Anestesista", "Pediatra", "Ortopedista" }));
        jComboBoxEspecialização.setEnabled(false);
        jComboBoxEspecialização.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEspecializaçãoActionPerformed(evt);
            }
        });

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTableMédico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMédico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMédicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMédico);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jTextFieldID.setEnabled(false);
        jTextFieldID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelIDLayout = new javax.swing.GroupLayout(jPanelID);
        jPanelID.setLayout(jPanelIDLayout);
        jPanelIDLayout.setHorizontalGroup(
            jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIDLayout.createSequentialGroup()
                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIDLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIDLayout.createSequentialGroup()
                                .addComponent(jLabelCRM)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelIDLayout.createSequentialGroup()
                                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNome)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(105, 105, 105)
                                .addComponent(jLabelEspecialização)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEspecialização, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelIDLayout.createSequentialGroup()
                                .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonPesquisar))))
                    .addGroup(jPanelIDLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanelIDLayout.setVerticalGroup(
            jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelIDLayout.createSequentialGroup()
                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIDLayout.createSequentialGroup()
                        .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelIDLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelEspecialização)
                                    .addComponent(jComboBoxEspecialização, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIDLayout.createSequentialGroup()
                                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCRM)
                            .addComponent(jFormattedTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelIDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar)))
                .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelIDLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelIDLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanelIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonPesquisar))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))))
        );

        jLabelCadMédicos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelCadMédicos.setText("Cadastro de Médicos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(367, 367, 367)
                        .addComponent(jLabelCadMédicos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelCadMédicos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        setSize(new java.awt.Dimension(959, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jFormattedTextFieldCRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldCRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldCRMActionPerformed

    private void jComboBoxEspecializaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEspecializaçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEspecializaçãoActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha com o NOME para continuar!");
            jTextFieldNome.requestFocus();
        }else if(jFormattedTextFieldCRM.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha com o CRM para continuar!");
            jFormattedTextFieldCRM.requestFocus();
        }else
        if(flag==1){
        mod.setNome(jTextFieldNome.getText());
        mod.setEspecialização((String) jComboBoxEspecialização.getSelectedItem());
        mod.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
        control.Salvar(mod);
        jTextFieldNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldNome.setEnabled(false);
        jFormattedTextFieldCRM.setEnabled(false);
        jComboBoxEspecialização.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        preencherTabela("select *from medicos order by nome_medico");
        }else{
            mod.setCodigo(Integer.parseInt(jTextFieldID.getText()));
            mod.setNome(jTextFieldNome.getText());
            mod.setEspecialização((String)jComboBoxEspecialização.getSelectedItem());
            mod.setCrm(Integer.parseInt(jFormattedTextFieldCRM.getText()));
            control.Editar(mod);
            jTextFieldID.setText("");
            jTextFieldNome.setText("");
            jFormattedTextFieldCRM.setText("");
            jTextFieldPesquisar.setText("");
            jTextFieldNome.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxEspecialização.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonCancelar.setEnabled(false);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        flag=1;
        jTextFieldNome.setEnabled(true);
        jFormattedTextFieldCRM.setEnabled(true);
        jComboBoxEspecialização.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jTextFieldNome.setText("");
        jFormattedTextFieldCRM.setText("");
        jTextFieldPesquisar.setText("");
        jTextFieldID.setText("");
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        mod.setPesquisa(jTextFieldPesquisar.getText());
        BeansMedico model = control.buscaMedico(mod);
        jTextFieldNome.setText(model.getNome());
        jTextFieldID.setText(String.valueOf(model.getCodigo()));
        jFormattedTextFieldCRM.setText(String.valueOf(model.getCrm()));
        jComboBoxEspecialização.setSelectedItem(model.getEspecialização());
        preencherTabela("select *from medicos where nome_medico like'%"+mod.getPesquisa()+"%'");
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTextFieldNome.setEnabled(!true);
        jFormattedTextFieldCRM.setEnabled(!true);
        jComboBoxEspecialização.setEnabled(!true);
        jButtonSalvar.setEnabled(!true);
        jButtonCancelar.setEnabled(!true);
        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jTextFieldID.setText("");
        jTextFieldNome.setText("");
        jFormattedTextFieldCRM.setText("");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        flag=2;
        jTextFieldNome.setEnabled(true);
        jFormattedTextFieldCRM.setEnabled(true);
        jComboBoxEspecialização.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonNovo.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        preencherTabela("select *from medicos order by nome_medico");
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jTextFieldIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if(resposta == JOptionPane.YES_OPTION){
            mod.setCodigo(Integer.parseInt(jTextFieldID.getText()));
            control.Excluir(mod);
            jTextFieldID.setText("");
            jTextFieldNome.setText("");
            jFormattedTextFieldCRM.setText("");
            jTextFieldNome.setEnabled(false);
            jFormattedTextFieldCRM.setEnabled(false);
            jComboBoxEspecialização.setEnabled(false);
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonCancelar.setEnabled(false);
            jButtonEditar.setEnabled(false);
            jButtonExcluir.setEnabled(false);
            preencherTabela("select *from medicos order by nome_medico");
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableMédicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMédicoMouseClicked
        String nome_medico =""+jTableMédico.getValueAt(jTableMédico.getSelectedRow(), 1);
        conex.conexao();
        conex.executaSQL("select *from medicos where nome_medico='"+nome_medico+"'");
       try {
           conex.rs.first();
           jTextFieldID.setText(String.valueOf(conex.rs.getInt("cod_medico")));
           jTextFieldNome.setText(conex.rs.getString("nome_medico"));
           jComboBoxEspecialização.setSelectedItem(conex.rs.getString("especializacao_medico"));
           jFormattedTextFieldCRM.setText(conex.rs.getString("crm_medico"));
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados!"+ex);
       }
        conex.desconect();
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
    }//GEN-LAST:event_jTableMédicoMouseClicked

    public void preencherTabela(String Sql){
           ArrayList dados = new ArrayList();
           String [] colunas = new String []{"ID","Nome","Especialização","Crm"};
           conex.conexao();
           conex.executaSQL(Sql);
           
           try{
               conex.rs.first();
               do{
                   dados.add(new Object[]{conex.rs.getInt("cod_medico"),conex.rs.getString("nome_medico"),conex.rs.getString("especializacao_medico"),conex.rs.getInt("crm_medico")});       
               }while(conex.rs.next());
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(rootPane, "Busque um nome válido!");
           }
           ModeloTabela modelo = new ModeloTabela(dados, colunas);
           
           jTableMédico.setModel(modelo);
           jTableMédico.getColumnModel().getColumn(0).setPreferredWidth(30);
           jTableMédico.getColumnModel().getColumn(0).setResizable(false);
           jTableMédico.setModel(modelo);
           jTableMédico.getColumnModel().getColumn(1).setPreferredWidth(280);
           jTableMédico.getColumnModel().getColumn(1).setResizable(false);
           jTableMédico.setModel(modelo);
           jTableMédico.getColumnModel().getColumn(2).setPreferredWidth(115);
           jTableMédico.getColumnModel().getColumn(2).setResizable(false);
           jTableMédico.setModel(modelo);
           jTableMédico.getColumnModel().getColumn(3).setPreferredWidth(115);
           jTableMédico.getColumnModel().getColumn(3).setResizable(false);
           jTableMédico.getTableHeader().setReorderingAllowed(false);
           jTableMédico.setAutoResizeMode(jTableMédico.AUTO_RESIZE_OFF);
           jTableMédico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
           conex.desconect();
    }
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
            java.util.logging.Logger.getLogger(FormMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMédico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxEspecialização;
    private javax.swing.JFormattedTextField jFormattedTextFieldCRM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCRM;
    private javax.swing.JLabel jLabelCadMédicos;
    private javax.swing.JLabel jLabelEspecialização;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanelID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMédico;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    // End of variables declaration//GEN-END:variables
}
