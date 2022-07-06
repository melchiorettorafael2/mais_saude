/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloBeans;

import java.util.Date;

/**
 *
 * @author rafa
 */
public class BeansConsulta {

    public String getNomePaci() {
        return nomePaci;
    }

    public void setNomePaci(String nomePaci) {
        this.nomePaci = nomePaci;
    }

    public String getNasciPaci() {
        return nasciPaci;
    }

    public void setNasciPaci(String nasciPaci) {
        this.nasciPaci = nasciPaci;
    }

  

    public String getHorarioAtendimento() {
        return horarioAtendimento;
    }

    public void setHorarioAtendimento(String horarioAtendimento) {
        this.horarioAtendimento = horarioAtendimento;
    }

    public String getMotivoAtendimento() {
        return motivoAtendimento;
    }

    public void setMotivoAtendimento(String motivoAtendimento) {
        this.motivoAtendimento = motivoAtendimento;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceita() {
        return receita;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public String getStatusAtendimento() {
        return statusAtendimento;
    }

    public void setStatusAtendimento(String statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

   private String nomePaci;
    private String nasciPaci;

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
    private String dataAtendimento;
    private String horarioAtendimento;
    private String motivoAtendimento;
    private String nomeMedico;
    private int crm;
    private String diagnostico;
    private String receita;
    private String statusAtendimento;

    public String getSus() {
        return sus;
    }

    /**
     *
     * @param sus
     */
    public void setSus(String sus) {
        this.sus = sus;
    }
    private String sus;
    
}
