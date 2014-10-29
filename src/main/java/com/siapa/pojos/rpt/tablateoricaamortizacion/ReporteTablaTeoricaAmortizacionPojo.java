/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.pojos.rpt.tablateoricaamortizacion;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Angel
 */
public class ReporteTablaTeoricaAmortizacionPojo implements Serializable {

    private String montoOriginal;
    private String tasaInteresNominal;
    private String numeroCuotas;
    private String fechaApertura;
    private String fechaVencimiento;

    private List<DetalleTablaTeoricaAmortizacionPojo> detalleTablaAmortizacion;

    private String totalPagosARealizar;
    private String totalAmortizacionACapital;
    private String totalAmortizacionAInteres;
    private String totalSeguros;
    private String totalComisiones;
    private String totalIva;
    private String totalSaldo;

    public String getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(String montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public String getTasaInteresNominal() {
        return tasaInteresNominal;
    }

    public void setTasaInteresNominal(String tasaInteresNominal) {
        this.tasaInteresNominal = tasaInteresNominal;
    }

    public String getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(String numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public String getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(String fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getTotalPagosARealizar() {
        return totalPagosARealizar;
    }

    public void setTotalPagosARealizar(String totalPagosARealizar) {
        this.totalPagosARealizar = totalPagosARealizar;
    }

    public String getTotalAmortizacionACapital() {
        return totalAmortizacionACapital;
    }

    public void setTotalAmortizacionACapital(String totalAmortizacionACapital) {
        this.totalAmortizacionACapital = totalAmortizacionACapital;
    }

    public String getTotalAmortizacionAInteres() {
        return totalAmortizacionAInteres;
    }

    public void setTotalAmortizacionAInteres(String totalAmortizacionAInteres) {
        this.totalAmortizacionAInteres = totalAmortizacionAInteres;
    }

    public String getTotalSeguros() {
        return totalSeguros;
    }

    public void setTotalSeguros(String totalSeguros) {
        this.totalSeguros = totalSeguros;
    }

    public String getTotalComisiones() {
        return totalComisiones;
    }

    public void setTotalComisiones(String totalComisiones) {
        this.totalComisiones = totalComisiones;
    }

    public String getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(String totalIva) {
        this.totalIva = totalIva;
    }

    public String getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(String totalSaldo) {
        this.totalSaldo = totalSaldo;
    }

    public List<DetalleTablaTeoricaAmortizacionPojo> getDetalleTablaAmortizacion() {
        return detalleTablaAmortizacion;
    }

    public void setDetalleTablaAmortizacion(List<DetalleTablaTeoricaAmortizacionPojo> detalleTablaAmortizacion) {
        this.detalleTablaAmortizacion = detalleTablaAmortizacion;
    }

   

}
