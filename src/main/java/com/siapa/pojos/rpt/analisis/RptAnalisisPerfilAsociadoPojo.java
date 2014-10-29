/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.analisis;

import java.io.Serializable;

/**
 *
 * @author Fm
 */
public class RptAnalisisPerfilAsociadoPojo implements Serializable{
    
    private String fechaIngreso;
    private String fechaReIngreso;
    private String profesion;
    private String referidoPor;
    private String saldoActualEnAportaciones;
    private String complementoDeAportaciones;

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaReIngreso() {
        return fechaReIngreso;
    }

    public void setFechaReIngreso(String fechaReIngreso) {
        this.fechaReIngreso = fechaReIngreso;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getReferidoPor() {
        return referidoPor;
    }

    public void setReferidoPor(String referidoPor) {
        this.referidoPor = referidoPor;
    }

    public String getSaldoActualEnAportaciones() {
        return saldoActualEnAportaciones;
    }

    public void setSaldoActualEnAportaciones(String saldoActualEnAportaciones) {
        this.saldoActualEnAportaciones = saldoActualEnAportaciones;
    }

    public String getComplementoDeAportaciones() {
        return complementoDeAportaciones;
    }

    public void setComplementoDeAportaciones(String complementoDeAportaciones) {
        this.complementoDeAportaciones = complementoDeAportaciones;
    }
    
}
