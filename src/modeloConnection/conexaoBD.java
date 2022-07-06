/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConnection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author rafa
 */
public class conexaoBD {
    public Statement stm; //realizar pesquisa no banco de dados.
    public ResultSet rs; //armazena o resultado da pesquisa.
    private static String driver = "org.postgresql.Driver";//identifica o serviço do BD.
    private static String caminho = "jdbc:postgresql://192.168.15.5:5433/maissaude";// Identifica o caminho aonde está alocado o BD.
    private static String usuario = "postgres";
    private static String senha = "shoryurepa";
    public static Connection con;//Variavel responsavel pela conexão com BD.
    
    public static Connection conexao(){
      
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
           // JOptionPane.showMessageDialog(null,"Conexão Efetuada com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar se Conectar com o Banco de Dados!\n"+ex.getMessage());
        }
        return con;
    }
        public void desconecta(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null,"Desconectado do Banco de Dados!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Falha ao Desconectar com Banco de Dados!\n"+ex.getMessage());
        }
      }
        public void executaSql (String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);//Cria uma barra de rolagem na tabela
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao Executar o SQL!\n"+ ex.getMessage());
        }
            
        
        }

    PreparedStatement getPreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
