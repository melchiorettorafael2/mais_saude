/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modeloBeans.BeansMedico;
import modeloBeans.BeansUsuario;
import modeloConnection.conexaoBD;

/**
 *
 * @author rafa
 */
public class DaouUsuario {
    
    conexaoBD conex = new conexaoBD();
    BeansUsuario mod = new BeansUsuario();
    
    
    public void Salvar(BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuarios (usu_nome,usu_senha,usu_tipo) values(?,?,?)");
            pst.setString(1,mod.getUsuNOME());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.execute();
            
           
            JOptionPane.showMessageDialog(null,"Usuário Cadastrado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar Cadastrar Usuário!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    }
    
    
       public BeansUsuario buscaUsuario (BeansUsuario mod){
        conex.conexao(); // abre conexão com BD
        conex.executaSql("select * from usuarios where usu_nome like '%"+mod.getUsuPesquisar()+"%'");//String SQL de pesquisa
        try {
            conex.rs.first();//Pega o primeiro resultado que encontra no banco
            mod.setUsuCod(conex.rs.getInt("usu_cod"));
            mod.setUsuNOME(conex.rs.getString("usu_nome"));
            mod.setUsuSenha(conex.rs.getString("usu_senha"));
            mod.setUsuTipo(conex.rs.getString("usu_tipo"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Usuário Não Cadastrado!");
        }
        conex.desconecta();//desconecta o BD
        return mod; // Ao declarar um método precisamos declarar o retorno, nesse caso é o´próprio modelo
        
    }
    
       public void Alterar (BeansUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuarios set usu_nome=?,usu_senha=?,usu_tipo=? where usu_cod=?");
            pst.setString(1, mod.getUsuNOME());
            pst.setString(2, mod.getUsuSenha());
            pst.setString(3, mod.getUsuTipo());
            pst.setInt(4, mod.getUsuCod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário Alterado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Tentar Alterar Usuário!\n"+ex.getMessage() );
        }
        
    
        conex.desconecta();
    }
    
       public void Excluir(BeansUsuario mod){
    
        conex.conexao();
        
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuarios where usu_cod=?");
            pst.setInt(1,mod.getUsuCod());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Usuário Excluído com Sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Tentar Excluir Usuário!\n"+ex.getMessage());
        }
        
        conex.desconecta();
    
    }
    
}
