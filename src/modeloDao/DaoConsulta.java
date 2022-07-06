/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;
import modeloBeans.BeansConsulta;
import modeloConnection.conexaoBD;


/**
 *
 * @author rafa
 */
public class DaoConsulta {
    
    BeansConsulta consulta = new BeansConsulta();
    conexaoBD conex = new conexaoBD();
    conexaoBD conexAgenda = new conexaoBD();
    
   


    public void SalvarConsulta(BeansConsulta consulta){
     conex.conexao();
        try {
                PreparedStatement pst = conex.con.prepareStatement("insert into consulta (nome_paciente,motivo_atendimento,nome_medico,crm_medico,diagnostico_atendimento,receita,status_atendimento,nascimento_paciente, horario_atendimento,data_atendimento,sus_paci) values(?,?,?,?,?,?,?,?,?,?,?)");
                    pst.setString(1,consulta.getNomePaci());
                   
                   
                  
                    pst.setString(2, consulta.getMotivoAtendimento());
                    pst.setString(3, consulta.getNomeMedico());
                    pst.setInt(4,consulta.getCrm());
                    pst.setString(5,consulta.getDiagnostico());
                    pst.setString(6,consulta.getReceita());
                    pst.setString(7,consulta.getStatusAtendimento());
                    pst.setString(8, consulta.getNasciPaci());
                     pst.setString(9, consulta.getHorarioAtendimento());
                     pst.setString(10,consulta.getDataAtendimento());
                     pst.setString(11,consulta.getSus());
                    
                    
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Atendimento Médico Realizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Enviar Dados do Atendimento!"+ex);
        }
           conex.desconecta();
   
       

}
}
