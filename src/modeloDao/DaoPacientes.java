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
import modeloBeans.BeansPaciente;
import modeloConnection.conexaoBD;


public class DaoPacientes {
    
     conexaoBD conex = new conexaoBD();
    BeansPaciente mod = new BeansPaciente();
    
    
    public void Salvar(BeansPaciente mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into pacientes (nome_paci,rg_paci,rua_paci,numero_paci,bairro_paci,nasci_paci,sus_paci,tel_paci,cep_paci) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setInt(2, mod.getRg());
            pst.setString(3,mod.getRua());
            pst.setInt(4, mod.getNumero());
            pst.setString(5, mod.getBairro());
            
            pst.setString(6, mod.getNascimento()); 
            pst.setString(7, mod.getSus());
             pst.setString(8, mod.getTelefone());
             pst.setString(9,mod.getCep());
            pst.execute();
            
           
            JOptionPane.showMessageDialog(null,"Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar Inserir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    //Método de Editar
    
    public void Editar (BeansPaciente mod){
        conex.conexao();
        try {
             PreparedStatement pst = conex.con.prepareStatement("update pacientes set nome_paci=?,rua_paci=?,numero_paci=?,bairro_paci=?,nasci_paci=?,sus_paci=?,tel_paci=?,cep_paci=? where rg_paci=?");
            pst.setString(1,mod.getNome());
            pst.setString(2,mod.getRua());
            pst.setInt(3, mod.getNumero());
             pst.setString(4, mod.getBairro());
             pst.setString(5, mod.getNascimento());
             pst.setString(6, mod.getSus());
            pst.setString(7, mod.getTelefone());
             pst.setString(8,mod.getCep());
             pst.setInt(9, mod.getRg());
             pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Tentar Alterar os Dados!\n"+ex.getMessage() );
        }
        
    
        conex.desconecta();
    }
    //Método de Exclusão
    
    public void Excluir(BeansPaciente mod){
    
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from pacientes where rg_paci=?");
            pst.setInt(1,mod.getRg());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluídos com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Tentar Excluir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    
    }
    
    //Método de Pesquisa
    
    public BeansPaciente buscaPaciente (BeansPaciente mod){
        conex.conexao(); // abre conexão com BD
        conex.executaSql("select * from pacientes where nome_paci like '%"+mod.getPesquisa()+"%'");//String SQL de pesquisa
        try {
            conex.rs.first();//Pega o primeiro resultado que encontra no banco
            mod.setNome(conex.rs.getString("nome_paci")); 
            mod.setRg(conex.rs.getInt("rg_paci"));
            mod.setRua(conex.rs.getString("rua_paci"));
            mod.setNumero(conex.rs.getInt("numero_paci"));
            mod.setBairro(conex.rs.getString("bairro_paci"));
            mod.setNascimento(conex.rs.getString("nasci_paci"));
            mod.setSus(conex.rs.getString("sus_paci"));
            mod.setTelefone(conex.rs.getString("tel_paci")); 
            mod.setCep(conex.rs.getString("cep_paci"));
            
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente Não Cadastrado!");
        }
        conex.desconecta();//desconecta o BD
        return mod; // Ao declarar um método precisamos declarar o retorno, nesse caso é o´próprio modelo
        
    }
}

    
    

