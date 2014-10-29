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
public class RptSituacionLaboral implements Serializable {

    private String fuenteIngreso;
    private String nombreEmpresa;
    private String tipoEmpresa;
    private String tipoContratacion;
    private String sueldoMensual;
    private String otrosIngresos;
    private String totalIngresos;
    private String descuentosSalario;

    public String getFuenteIngreso() {
        return fuenteIngreso;
    }

    public void setFuenteIngreso(String fuenteIngreso) {
        this.fuenteIngreso = fuenteIngreso;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public String getTipoContratacion() {
        return tipoContratacion;
    }

    public void setTipoContratacion(String tipoContratacion) {
        this.tipoContratacion = tipoContratacion;
    }

    public String getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(String sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public String getOtrosIngresos() {
        return otrosIngresos;
    }

    public void setOtrosIngresos(String otrosIngresos) {
        this.otrosIngresos = otrosIngresos;
    }

    public String getTotalIngresos() {
        return totalIngresos;
    }

    public void setTotalIngresos(String totalIngresos) {
        this.totalIngresos = totalIngresos;
    }

    public String getDescuentosSalario() {
        return descuentosSalario;
    }

    public void setDescuentosSalario(String descuentosSalario) {
        this.descuentosSalario = descuentosSalario;
    }
}
