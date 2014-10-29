/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.solicitud;

import java.io.Serializable;

/**
 *
 * @author Angel
 */
public class RptTarjetasCredito implements Serializable{
 private String emisor;
 private String numtarjeta;
 private String fechaemision;
 private String limite;
 private String saldoactual;
 private String pagominimo;

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public String getNumtarjeta() {
        return numtarjeta;
    }

    public void setNumtarjeta(String numtarjeta) {
        this.numtarjeta = numtarjeta;
    }

    public String getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(String fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public String getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(String saldoactual) {
        this.saldoactual = saldoactual;
    }

    public String getPagominimo() {
        return pagominimo;
    }

    public void setPagominimo(String pagominimo) {
        this.pagominimo = pagominimo;
    }
}
