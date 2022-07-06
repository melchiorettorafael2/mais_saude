/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

/**
 *
 * @author rafa
 */
public class BeansUsuario {
    
    private int usuCod;
    private String usuNOME;
    private String usuTipo;
    private String usuSenha;
    private String usuPesquisar;

    public String getUsuPesquisar() {
        return usuPesquisar;
    }

    public void setUsuPesquisar(String usuPesquisar) {
        this.usuPesquisar = usuPesquisar;
    }
    

    public Integer getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(Integer usuCod) {
        this.usuCod = usuCod;
    }

    public String getUsuNOME() {
        return usuNOME;
    }

    public void setUsuNOME(String usuNOME) {
        this.usuNOME = usuNOME;
    }

    public String getUsuTipo() {
        return usuTipo;
    }

    public void setUsuTipo(String usuTipo) {
        this.usuTipo = usuTipo;
    }

    public String getUsuSenha() {
        return usuSenha;
    }

    public void setUsuSenha(String usuSenha) {
        this.usuSenha = usuSenha;
    }
    
    
}
