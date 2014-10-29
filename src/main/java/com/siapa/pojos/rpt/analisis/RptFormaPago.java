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
public class RptFormaPago implements Serializable{
    
    private String periodicidad;
    private String diasDeMes;
    private String formaPago;
    private String mensaje20Porciento;

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getDiasDeMes() {
        return diasDeMes;
    }

    public void setDiasDeMes(String diasDeMes) {
        this.diasDeMes = diasDeMes;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMensaje20Porciento() {
        return mensaje20Porciento;
    }

    public void setMensaje20Porciento(String mensaje20Porciento) {
        this.mensaje20Porciento = mensaje20Porciento;
    }
    
}
