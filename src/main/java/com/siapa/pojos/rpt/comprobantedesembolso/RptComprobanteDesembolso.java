/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.comprobantedesembolso;

import java.util.List;

/**
 *
 * @author Angel
 */
public class RptComprobanteDesembolso {
    private List<RptTablaDesembolso> tabladesembolso;
    private String comprobante;
    private String nombreasociado;
    private String codigo;  
    private String tasaanual;  
    private String linea;  
    private String monto;  
    private String numeros;  
    private String periocidad;  
    private String plazo;  
    private String formapago;  
    private String valorcuota;  
    private String garantia;  
    private String primerpago;  
    private String diapago;  

    public List<RptTablaDesembolso> getTabladesembolso() {
        return tabladesembolso;
    }

    public void setTabladesembolso(List<RptTablaDesembolso> tabladesembolso) {
        this.tabladesembolso = tabladesembolso;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getNombreasociado() {
        return nombreasociado;
    }

    public void setNombreasociado(String nombreasociado) {
        this.nombreasociado = nombreasociado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTasaanual() {
        return tasaanual;
    }

    public void setTasaanual(String tasaanual) {
        this.tasaanual = tasaanual;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getNumeros() {
        return numeros;
    }

    public void setNumeros(String numeros) {
        this.numeros = numeros;
    }

    public String getPeriocidad() {
        return periocidad;
    }

    public void setPeriocidad(String periocidad) {
        this.periocidad = periocidad;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getValorcuota() {
        return valorcuota;
    }

    public void setValorcuota(String valorcuota) {
        this.valorcuota = valorcuota;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getPrimerpago() {
        return primerpago;
    }

    public void setPrimerpago(String primerpago) {
        this.primerpago = primerpago;
    }

    public String getDiapago() {
        return diapago;
    }

    public void setDiapago(String diapago) {
        this.diapago = diapago;
    }
}
