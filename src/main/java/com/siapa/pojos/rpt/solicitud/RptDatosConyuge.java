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
public class RptDatosConyuge implements Serializable{    
private String nombreconyuge;
private String nombreemp;
private String lugartrab;
private String tiempotrabmes;
private String tiempotrabanio;
private String tel;
private String cargo;
private String sueldo;
private String numDependientes;


    public String getNombreconyuge() {
        return nombreconyuge;
    }

    public void setNombreconyuge(String nombreconyuge) {
        this.nombreconyuge = nombreconyuge;
    }

    public String getNombreemp() {
        return nombreemp;
    }

    public void setNombreemp(String nombreemp) {
        this.nombreemp = nombreemp;
    }

    public String getLugartrab() {
        return lugartrab;
    }

    public void setLugartrab(String lugartrab) {
        this.lugartrab = lugartrab;
    }

    public String getTiempotrabmes() {
        return tiempotrabmes;
    }

    public void setTiempotrabmes(String tiempotrabmes) {
        this.tiempotrabmes = tiempotrabmes;
    }

    public String getTiempotrabanio() {
        return tiempotrabanio;
    }

    public void setTiempotrabanio(String tiempotrabanio) {
        this.tiempotrabanio = tiempotrabanio;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getNumDependientes() {
        return numDependientes;
    }

    public void setNumDependientes(String numDependientes) {
        this.numDependientes = numDependientes;
    }
}
