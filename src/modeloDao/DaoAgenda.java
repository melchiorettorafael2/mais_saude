/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modeloBeans.BeansAgenda;
import modeloConnection.conexaoBD;

/**
 *
 * @author rafa
 */
public class DaoAgenda {
    
    BeansAgenda agenda = new BeansAgenda();
    conexaoBD conex = new conexaoBD();
    conexaoBD conexPaciente = new conexaoBD();
    conexaoBD conexaoMedico = new conexaoBD();

    int codMed;
    int codPac;
    
    public void Salvar(BeansAgenda agenda){
        BuscarMedico(agenda.getNomeMed());
      
        BuscarPaciente(agenda.getNomePac());
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into agenda (agenda_codpac,agenda_turno,agenda_codmedico, agenda_data,agenda_motivo, agenda_status) values (?,?,?,?,?,?)");
            pst.setInt(1,codPac);
             pst.setString(2,agenda.getHorario());
            pst.setInt(3,codMed);
           pst.setDate(4,new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5,agenda.getMotivo());
            pst.setString(6, agenda.getStatus());
   
            pst.execute();
            JOptionPane.showMessageDialog(null,"Consulta Agendada com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Salvar Agendamento!"+ex);
        }
        
        conex.desconecta();
    
    }
    public void BuscarMedico(String nomeMedico){
        conexaoMedico.conexao();
        conexaoMedico.executaSql("select * from medicos where nome_medico='"+nomeMedico+"'");
                                 
        try {
            conexaoMedico.rs.first();
            codMed = conexaoMedico.rs.getInt("cod_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Cadastrado");
        }
        
    }
    
    public int BuscarcodMedico(String nomeMedico){
        conexaoMedico.conexao();
        conexaoMedico.executaSql("select * from medicos where nome_medico='"+nomeMedico+"'");
                                 
        try {
            conexaoMedico.rs.first();
            codMed = conexaoMedico.rs.getInt("cod_medico");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico não Cadastrado");
        }
        return codMed;
    }
    

    public void BuscarPaciente(String nomePaciente){
          conexPaciente.conexao();
        conexPaciente.executaSql("select * from pacientes where nome_paci='"+nomePaciente+"'");
        try {
            conexPaciente.rs.first();
            codPac= conexPaciente.rs.getInt("rg_paci");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente não Cadastrado");
        }
        
    }
    
  
    
    public void BuscaAgendamento (String nomePaciente){
        conexaoMedico.conexao();
        conexaoMedico.executaSql("select *from agenda where agenda_data='"+agenda.getData()+"'");
            try{
                conexaoMedico.rs.first();
                codMed = conexaoMedico.rs.getInt("cod_medico");
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Agendamento não Encontrado!");
                
            }
    
    }
    
    public void Alterar (BeansAgenda agenda){
    
      conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update agenda set agenda_status=? where agenda_cod=?");
            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAgendaCod());
                    
            pst.execute();
            JOptionPane.showMessageDialog(null, "Consulta em Atendimento!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Concluir Atendimento!\n"+ex.getMessage() );
        }
    }
   
    
       public void Atualizar (BeansAgenda agenda){
    
      conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update agenda set agenda_status=? where agenda_cod=?");
            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAgendaCod());
                    
            pst.execute();
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Atualizar Tabela!\n"+ex.getMessage() );
        }
    }
    
    public void FinalizarConsulta (BeansAgenda agenda){
    
      conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update agenda set agenda_status=? where agenda_cod=?");
            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAgendaCod());
                    
            pst.execute();
            JOptionPane.showMessageDialog(null, "Paciente Atendido!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Concluir Atendimento!\n"+ex.getMessage() );
        }
         
        
    
        
    }

     public void Excluir(BeansAgenda agenda){
    
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from agenda where agenda_cod=?");
            pst.setInt(1, agenda.getAgendaCod());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Consulta Desmarcada com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Tentar Excluir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    
    }
     
 
    
    public BeansAgenda BuscaAgendamentoPorCodigo (int cod){
        BeansAgenda agen = new BeansAgenda();
        
         
        conex.conexao();
        conex.executaSql("select *from agenda inner join pacientes on agenda_codpac=rg_paci inner join medicos on agenda_codmedico=cod_medico where agenda_cod='"+cod+"'");
            try{
                conex.rs.first();
               agen.setNomePac(conex.rs.getString("nome_paci"));
               agen.setNomeMed(conex.rs.getString("nome_medico"));
               agen.setCRM(conex.rs.getString("crm_medico"));
               agen.setMotivo(conex.rs.getString("agenda_motivo"));
                agen.setPacienteNasci(conex.rs.getString("nasci_paci"));
                agen.setSus(conex.rs.getString("sus_paci"));
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null,"Erro ao Buscar Agendamento!"+ex);
                
            }
            return agen;
    }



}

