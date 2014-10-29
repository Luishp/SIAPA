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
public class RptSituacionEconomicaFamiliar implements Serializable{
    
    private String estadoFamiliar;
    private String conyugue;
    private String lugarTrabajoConyugue;
    private String lugarTrabajo;
    private String cargo;
    private String ingresoConyugue;
    private String numeroDependientes;
    private String ingresosMensuales;
    private String egresosMensuales;
    private String rentaNetaMensual;
    private String destinoCredito;

    public String getEstadoFamiliar() {
        return estadoFamiliar;
    }

    public void setEstadoFamiliar(String estadoFamiliar) {
        this.estadoFamiliar = estadoFamiliar;
    }

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getLugarTrabajoConyugue() {
        return lugarTrabajoConyugue;
    }

    public void setLugarTrabajoConyugue(String lugarTrabajoConyugue) {
        this.lugarTrabajoConyugue = lugarTrabajoConyugue;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIngresoConyugue() {
        return ingresoConyugue;
    }

    public void setIngresoConyugue(String ingresoConyugue) {
        this.ingresoConyugue = ingresoConyugue;
    }

    public String getNumeroDependientes() {
        return numeroDependientes;
    }

    public void setNumeroDependientes(String numeroDependientes) {
        this.numeroDependientes = numeroDependientes;
    }

    public String getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(String ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public String getEgresosMensuales() {
        return egresosMensuales;
    }

    public void setEgresosMensuales(String egresosMensuales) {
        this.egresosMensuales = egresosMensuales;
    }

    public String getRentaNetaMensual() {
        return rentaNetaMensual;
    }

    public void setRentaNetaMensual(String rentaNetaMensual) {
        this.rentaNetaMensual = rentaNetaMensual;
    }

    public String getDestinoCredito() {
        return destinoCredito;
    }

    public void setDestinoCredito(String destinoCredito) {
        this.destinoCredito = destinoCredito;
    }
    
}
