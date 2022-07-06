/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansAgenda;
import modeloBeans.ModeloTabela;
import modeloConnection.conexaoBD;
import modeloDao.DaoAgenda;
import java.awt.Toolkit;





/**
 *
 * @author rafa
 */
public class FormAgendamento extends javax.swing.JFrame {
      conexaoBD conex = new conexaoBD();
      BeansAgenda agenda = new BeansAgenda();
     
       
  
    public FormAgendamento() {
        initComponents();
          try {
              preencherTabela("select *from pacientes order by nome_paci");
          } catch (SQLException ex) {
              Logger.getLogger(FormAgendamento.class.getName()).log(Level.SEVERE, null, ex);
          }
        preencherMedicos();
       
    }
          public void preencherMedicos(){
           conex.conexao();
           conex.executaSql("select *from medicos order by nome_medico");
            try {
                conex.rs.first();
                jComboBoxMedicos.removeAllItems();
                do{
           jComboBoxMedicos.addItem(conex.rs.getString("nome_medico"));
                }while(conex.rs.next());
            }catch (SQLException ex){ 
                JOptionPane.showMessageDialog(rootPane,"Erro ao preencher Médicos"+ex);
            }
                conex.desconecta();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jButtonBuscaPaciente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePaciente = new javax.swing.JTable();
        jComboBoxMedicos = new javax.swing.JComboBox<>();
        jButtonAgendar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextField3 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendamento de Consulta");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Sistema_Mais_Saude/icone3.png"));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agendamento de Consulta", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Paciente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 60, 70, 30);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Médico");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 240, 60, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Data");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(340, 240, 40, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Observações");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 340, 100, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Horário");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(340, 280, 60, 50);
        jPanel1.add(jTextFieldPaciente);
        jTextFieldPaciente.setBounds(90, 60, 210, 30);

        jComboBoxHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));
        jComboBoxHorario.setEnabled(false);
        jPanel1.add(jComboBoxHorario);
        jComboBoxHorario.setBounds(400, 290, 110, 30);

        jButtonBuscaPaciente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonBuscaPaciente.setText("Pesquisar");
        jButtonBuscaPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscaPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscaPaciente);
        jButtonBuscaPaciente.setBounds(310, 60, 100, 30);

        jTablePaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePaciente);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 500, 120);

        jComboBoxMedicos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxMedicos.setEnabled(false);
        jComboBoxMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMedicosActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxMedicos);
        jComboBoxMedicos.setBounds(80, 240, 180, 30);

        jButtonAgendar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAgendar.setText("Agendar");
        jButtonAgendar.setEnabled(false);
        jButtonAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgendarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgendar);
        jButtonAgendar.setBounds(190, 480, 90, 35);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelar);
        jButtonCancelar.setBounds(290, 480, 90, 35);

        jDateChooser1.setEnabled(false);
        jPanel1.add(jDateChooser1);
        jDateChooser1.setBounds(380, 240, 130, 30);

        jTextField3.setEnabled(false);
        jScrollPane2.setViewportView(jTextField3);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(20, 360, 500, 110);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 570, 530);

        setSize(new java.awt.Dimension(620, 602));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscaPacienteActionPerformed
          try {
              preencherTabela("select  nome_paci, nasci_paci,rg_paci, tel_paci from pacientes where nome_paci like '%"+jTextFieldPaciente.getText()+"%'");
          } catch (SQLException ex) {
              Logger.getLogger(FormAgendamento.class.getName()).log(Level.SEVERE, null, ex);
          }
        
        
    }//GEN-LAST:event_jButtonBuscaPacienteActionPerformed

    private void jTablePacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteMouseClicked
       String nome_paci=""+jTablePaciente.getValueAt(jTablePaciente.getSelectedRow(),0);
        conex.conexao();
        conex.executaSql("select *from pacientes where nome_paci='"+nome_paci+"'");
        try {
            conex.rs.first();
            jTextFieldPaciente.setText(conex.rs.getString("nome_paci"));
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane,"Erro ao inserir Paciente"+ex);
        
        }
                
         
            conex.desconecta();
        
            jComboBoxHorario.setEnabled(true);
            jComboBoxMedicos.setEnabled(true);
            jDateChooser1.setEnabled(true);
            jTextField3.setEnabled(true);
            jButtonAgendar.setEnabled(true);
            jButtonCancelar.setEnabled(true);
            
    }//GEN-LAST:event_jTablePacienteMouseClicked

    private void jButtonAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgendarActionPerformed
       if(jTextFieldPaciente.getText().isEmpty()){
           JOptionPane.showMessageDialog(null, "Selecione um Paciente para Agendar a Consulta!");
       }else{   
        agenda.setNomePac(jTextFieldPaciente.getText());
        agenda.setNomeMed((String) jComboBoxMedicos.getSelectedItem());
        agenda.setMotivo(jTextField3.getText());
        agenda.setHorario((String)jComboBoxHorario.getSelectedItem());
        agenda.setData(jDateChooser1.getDate());
        agenda.setStatus("Aberto");
        DaoAgenda dao = new DaoAgenda();
        dao.Salvar(agenda);
        
        jTextFieldPaciente.setText("");
        jComboBoxHorario.setSelectedItem(null);
        jComboBoxMedicos.setSelectedItem(null);
        jDateChooser1.setDate(null);
        jTextField3.setText("");
        jButtonAgendar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        dispose();
        }
    }//GEN-LAST:event_jButtonAgendarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        int resposta = 0;
        resposta =JOptionPane.showConfirmDialog(rootPane,"Deseja Realmente Cancelar o Agendamento?");
        if(resposta==JOptionPane.YES_OPTION){
        jTextFieldPaciente.setText("");
        jComboBoxHorario.setSelectedItem(null);
        jComboBoxMedicos.setSelectedItem(null);
        jDateChooser1.setDate(null);
        jTextField3.setText("");
        jButtonAgendar.setEnabled(true);
        jButtonCancelar.setEnabled(false);
         jComboBoxHorario.setEnabled(false);
            jComboBoxMedicos.setEnabled(false);
            jDateChooser1.setEnabled(false);
            jTextField3.setEnabled(false);
            jButtonAgendar.setEnabled(false);
           
        
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMedicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMedicosActionPerformed
    
           private void preencherTabela(String Sql) throws SQLException{
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"Nome", "Nacimento", "RG", "Telefone"};
        conex.conexao();
        conex.executaSql(Sql);
        conex.rs.first(); //JOptionPane.showMessageDialog(rootPane,"Erro ao Preencher ArrayList\n"+ex.getMessage());
        do{
            dados.add(new Object[]{conex.rs.getString("nome_paci"), conex.rs.getString("nasci_paci"),conex.rs.getInt("rg_paci"), conex.rs.getString("tel_paci")});
        }while(conex.rs.next());//Enquanto houver dados ele vai percorrer o registro.
        ModeloTabela modelo = new ModeloTabela(dados, colunas) {};
        
        jTablePaciente.setModel(modelo);
        jTablePaciente.getColumnModel().getColumn(0).setPreferredWidth(180);
        jTablePaciente.getColumnModel().getColumn(0).setResizable(false);
        jTablePaciente.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTablePaciente.getColumnModel().getColumn(1).setResizable(false);
        jTablePaciente.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTablePaciente.getColumnModel().getColumn(2).setResizable(false);
        jTablePaciente.getColumnModel().getColumn(3).setPreferredWidth(101);
        jTablePaciente.getColumnModel().getColumn(3).setResizable(false);
        jTablePaciente.getTableHeader().setReorderingAllowed(false);
        jTablePaciente.setAutoResizeMode(jTablePaciente.AUTO_RESIZE_OFF);// Bloqueia Tabela para redimensionamento.
        jTablePaciente.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Usuário só pode selecionar um campo da tabela por vez.
        conex.desconecta();
    }
    
     
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
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgendar;
    private javax.swing.JButton jButtonBuscaPaciente;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JComboBox<String> jComboBoxMedicos;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePaciente;
    private javax.swing.JTextPane jTextField3;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}