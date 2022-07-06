/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rafa
 */
public class ModeloTabela extends AbstractTableModel{
    
    private ArrayList linhas = null;// ArrayList é uma coleção simples que pode armazenar qualquer tipo de objeto.
    private String[] colunas = null;

    
public ModeloTabela(ArrayList lin, String[] col){
    setLinhas(lin);
    setColunas(col);
}

    /**
     * @return the linhas
     */
    public ArrayList getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    public int getColumnCount(){
        return colunas.length;//Conta a quantidade de colunas. 
    }
    
    public int getRowCount(){
        return linhas.size();//Conta quantas linhas temos no nosso Array.
    }
    
    public String getColumnName(int numCol){
      return colunas[numCol];//Retorna o nome da Coluna. 
    }
  
    public Object getValueAt(int numLin, int numCol){ //método que monta a tabela
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }

   
    
}


