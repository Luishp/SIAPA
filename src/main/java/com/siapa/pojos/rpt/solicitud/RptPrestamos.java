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
public class RptPrestamos implements Serializable{
    private String nombrebanco;
    private String numprestamo;
    private String cuota;
    private String fechaotorga;
    private String valororiginal;
    private String saldoactual;
    private String vencimiento;

    public String getNombrebanco() {
        return nombrebanco;
    }

    public void setNombrebanco(String nombrebanco) {
        this.nombrebanco = nombrebanco;
    }

    public String getNumprestamo() {
        return numprestamo;
    }

    public void setNumprestamo(String numprestamo) {
        this.numprestamo = numprestamo;
    }

    public String getCuota() {
        return cuota;
    }

    public void setCuota(String cuota) {
        this.cuota = cuota;
    }

    public String getFechaotorga() {
        return fechaotorga;
    }

    public void setFechaotorga(String fechaotorga) {
        this.fechaotorga = fechaotorga;
    }

    public String getValororiginal() {
        return valororiginal;
    }

    public void setValororiginal(String valororiginal) {
        this.valororiginal = valororiginal;
    }

    public String getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(String saldoactual) {
        this.saldoactual = saldoactual;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
}
