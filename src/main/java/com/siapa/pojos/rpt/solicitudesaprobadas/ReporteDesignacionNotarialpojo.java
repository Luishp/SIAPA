/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.solicitudesaprobadas;

import java.io.Serializable;

/**
 *
 * @author Fm
 */
public class ReporteDesignacionNotarialpojo implements Serializable{
    
    private String asociadoNombre;
    private String asociadoDui;
    private String asociadoCodigo;
    
    private String notarioNombre;
    
    private String prestamoNumero;
    private String prestamoMonto;
    private String prestamoMontoLetras;
    
    private String fecha;

    public String getAsociadoNombre() {
        return asociadoNombre;
    }

    public void setAsociadoNombre(String asociadoNombre) {
        this.asociadoNombre = asociadoNombre;
    }

    public String getAsociadoDui() {
        return asociadoDui;
    }

    public void setAsociadoDui(String asociadoDui) {
        this.asociadoDui = asociadoDui;
    }

    public String getAsociadoCodigo() {
        return asociadoCodigo;
    }

    public void setAsociadoCodigo(String asociadoCodigo) {
        this.asociadoCodigo = asociadoCodigo;
    }

    public String getNotarioNombre() {
        return notarioNombre;
    }

    public void setNotarioNombre(String notarioNombre) {
        this.notarioNombre = notarioNombre;
    }

    public String getPrestamoNumero() {
        return prestamoNumero;
    }

    public void setPrestamoNumero(String prestamoNumero) {
        this.prestamoNumero = prestamoNumero;
    }

    public String getPrestamoMonto() {
        return prestamoMonto;
    }

    public void setPrestamoMonto(String prestamoMonto) {
        this.prestamoMonto = prestamoMonto;
    }

    public String getPrestamoMontoLetras() {
        return prestamoMontoLetras;
    }

    public void setPrestamoMontoLetras(String prestamoMontoLetras) {
        this.prestamoMontoLetras = prestamoMontoLetras;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
