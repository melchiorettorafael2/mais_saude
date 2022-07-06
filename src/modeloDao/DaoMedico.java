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
import modeloBeans.BeansMedico;
import modeloConnection.conexaoBD;

/**
 *
 * @author rafa
 */
public class DaoMedico {
    
    conexaoBD conex = new conexaoBD();
    BeansMedico mod = new BeansMedico();
    
    
    public void Salvar(BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into medicos (nome_medico,especialidade_medico,crm_medico) values(?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.execute();
            
           
            JOptionPane.showMessageDialog(null,"Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar Inserir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    //Método de Editar
    
    public void Editar (BeansMedico mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update medicos set nome_medico=?,especialidade_medico=?,crm_medico=? where cod_medico=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCrm());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Tentar Alterar os Dados!\n"+ex.getMessage() );
        }
        
    
        conex.desconecta();
    }
    //Método de Exclusão
    
    public void Excluir(BeansMedico mod){
    
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from medicos where cod_medico=?");
            pst.setInt(1,mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluídos com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Tentar Excluir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    
    }
    
    //Método de Pesquisa
    
    public BeansMedico buscaMedico(BeansMedico mod){
        conex.conexao(); // abre conexão com BD
        conex.executaSql("select * from medicos where nome_medico like '%"+mod.getPesquisa()+"%'");//String SQL de pesquisa
        try {
            conex.rs.first();//Pega o primeiro resultado que encontra no banco
            mod.setCodigo(conex.rs.getInt("cod_medico"));
            mod.setNome(conex.rs.getString("nome_medico"));
            mod.setEspecialidade(conex.rs.getString("especialidade_medico"));
            mod.setCrm(conex.rs.getInt("crm_medico"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Médico Não Cadastrado!");
        }
        conex.desconecta();//desconecta o BD
        return mod; // Ao declarar um método precisamos declarar o retorno, nesse caso é o´próprio modelo
        
    }
}

