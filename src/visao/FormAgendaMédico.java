/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.ModeloTabela;
import modeloConnection.conexaoBD;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import modeloDao.DaoAgenda;

/**
 *
 * @author rafa
 */
public class FormAgendaMédico extends javax.swing.JFrame {
    conexaoBD conex = new conexaoBD();
    String dtHoje;
    String status;
    DaoAgenda daoAgenda = new DaoAgenda();
    String cod_agenda;
   
    public FormAgendaMédico() {
        initComponents();
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format (d);
        
       
        dtHoje = dateFormat.format(d);
        
        status ="Em Atendimento";
        
        preencherMedicos();
       
    }

   
        public void preencherMedicos(){
           conex.conexao();
           conex.executaSql("select *from medicos order by nome_medico");
            try {
                conex.rs.first();
                jComboBoxMédicos.removeAllItems();
                do{
           jComboBoxMédicos.addItem(conex.rs.getString("nome_medico"));
                }while(conex.rs.next());
            }catch (SQLException ex){ 
                JOptionPane.showMessageDialog(rootPane,"Erro ao preencher Médicos"+ex);
            }
                conex.desconecta();
          }     
        
        
         public void preencherTabela(String Sql){
        ArrayList dados = new ArrayList();
        String [] colunas = new String []{"ID", "Nome", "Horário", "Data", "Status", "Médico"};
        conex.conexao();
        conex.executaSql(Sql);
        try{
            conex.rs.first();
        
            do{
                dados.add(new Object[]{conex.rs.getString("agenda_cod"), conex.rs.getString("nome_paci"),conex.rs.getString("agenda_turno"), conex.rs.getString("agenda_data"), conex.rs.getString("agenda_status"), conex.rs.getString("nome_medico")});
            }while(conex.rs.next());//Enquanto houver dados ele vai percorrer o registro.
        }catch (SQLException ex){
            
            JOptionPane.showMessageDialog(rootPane,"Não existem agendamentos marcados para este Médico!");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas) {};
        
        jTablePacienteAgenda.setModel(modelo);
        jTablePacienteAgenda.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTablePacienteAgenda.getColumnModel().getColumn(0).setResizable(false);
        jTablePacienteAgenda.getColumnModel().getColumn(1).setPreferredWidth(220);
        jTablePacienteAgenda.getColumnModel().getColumn(1).setResizable(false);
        jTablePacienteAgenda.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTablePacienteAgenda.getColumnModel().getColumn(2).setResizable(false);
        jTablePacienteAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTablePacienteAgenda.getColumnModel().getColumn(3).setResizable(false);
         jTablePacienteAgenda.getColumnModel().getColumn(4).setPreferredWidth(120);
        jTablePacienteAgenda.getColumnModel().getColumn(4).setResizable(false);
         jTablePacienteAgenda.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTablePacienteAgenda.getColumnModel().getColumn(5).setResizable(false);
        jTablePacienteAgenda.getTableHeader().setReorderingAllowed(false);
        jTablePacienteAgenda.setAutoResizeMode(jTablePacienteAgenda.AUTO_RESIZE_OFF);// Bloqueia Tabela para redimensionamento.
        jTablePacienteAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// Usuário só pode selecionar um campo da tabela por vez.
        conex.desconecta();
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacienteAgenda = new javax.swing.JTable();
        jButtonAtender = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxMédicos = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agenda do Médico");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Sistema_Mais_Saude/icone3.png"));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Agenda Médico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Pacientes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 80, 80, 19);

        jTablePacienteAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTablePacienteAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePacienteAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePacienteAgenda);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 590, 370);

        jButtonAtender.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAtender.setText("Atender Paciente");
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAtender);
        jButtonAtender.setBounds(220, 480, 150, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Médico");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(290, 40, 60, 30);

        jPanel1.add(jComboBoxMédicos);
        jComboBoxMédicos.setBounds(350, 40, 160, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(520, 40, 90, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 630, 540);

        setSize(new java.awt.Dimension(656, 591));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int cod = daoAgenda.BuscarcodMedico((String)jComboBoxMédicos.getSelectedItem());
        String codigo = String.valueOf(cod);
        preencherTabela("select *from agenda inner join pacientes on agenda_codpac = rg_paci inner join medicos on agenda_codmedico = cod_medico where agenda_codmedico='"+codigo+"' and agenda_data='"+dtHoje+"' and agenda_status='"+status+"'");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablePacienteAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePacienteAgendaMouseClicked
       cod_agenda = ""+jTablePacienteAgenda.getValueAt(jTablePacienteAgenda.getSelectedRow(),0);
       
    }//GEN-LAST:event_jTablePacienteAgendaMouseClicked

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
       FormConsulta tela = new FormConsulta(cod_agenda);
       tela.setVisible(true);
       dispose();
    }//GEN-LAST:event_jButtonAtenderActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgendaMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMédico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendaMédico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JComboBox<String> jComboBoxMédicos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePacienteAgenda;
    // End of variables declaration//GEN-END:variables
}
