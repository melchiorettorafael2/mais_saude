/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansEnfermeiro;
import modeloConnection.conexaoBD;

/**
 *
 * @author rafa
 */
public class DaoEnfermeiros {
    
    conexaoBD conex = new conexaoBD();
    BeansEnfermeiro mod = new BeansEnfermeiro();
    
    
    public void Salvar(BeansEnfermeiro mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into enfermeiros (nome_enfermeiro,especialidade_enfermeiro,coren_enfermeiro) values(?,?,?)");
            pst.setString(1,mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCoren());
            pst.execute();
            
           
            JOptionPane.showMessageDialog(null,"Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar Inserir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    //Método de Editar
    
    public void Editar (BeansEnfermeiro mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update enfermeiros set nome_enfermeiro=?,especialidade_enfermeiro=?,coren_enfermeiro=? where cod_enfermeiro=?");
            pst.setString(1, mod.getNome());
            pst.setString(2, mod.getEspecialidade());
            pst.setInt(3, mod.getCoren());
            pst.setInt(4, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Tentar Alterar os Dados!\n"+ex.getMessage() );
        }
        
    
        conex.desconecta();
    }
    //Método de Exclusão
    
    public void Excluir(BeansEnfermeiro mod){
    
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from enfermeiros where cod_enfermeiro=?");
            pst.setInt(1,mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados Excluídos com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Tentar Excluir Dados!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    
    }
    
    //Método de Pesquisa
    
    public BeansEnfermeiro buscaEnfermeiro(BeansEnfermeiro mod){
        conex.conexao(); // abre conexão com BD
        conex.executaSql("select * from enfermeiros where nome_enfermeiro like '%"+mod.getPesquisa()+"%'");//String SQL de pesquisa
        try {
            conex.rs.first();//Pega o primeiro resultado que encontra no banco
            mod.setCodigo(conex.rs.getInt("cod_enfermeiro"));
            mod.setNome(conex.rs.getString("nome_enfermeiro"));
            mod.setEspecialidade(conex.rs.getString("especialidade_enfermeiro"));
            mod.setCoren(conex.rs.getInt("coren_enfermeiro"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Enfermeiro Não Cadastrado!");
        }
        conex.desconecta();//desconecta o BD
        return mod; // Ao declarar um método precisamos declarar o retorno, nesse caso é o´próprio modelo
        
    }
}
