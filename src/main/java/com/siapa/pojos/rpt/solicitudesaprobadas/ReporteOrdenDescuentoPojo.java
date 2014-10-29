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
public class ReporteOrdenDescuentoPojo implements Serializable {

    private String empresaNombre;

    private String asociadoNombre;
    private String asociadoDui;
    private String asociadoCodigo;
    private String asociadoDomicilio;
    private String asociadoDepartamento;
    private String asociadoNit;

    private String notarioNombre;

    private String prestamoNumero;
    private String prestamoLinea;
    private String prestamoMonto;
    private String prestamoMontoLetras;

    private String bancoNombre;
    private String fechaInicio;

    private String firmaNombre;

    private String cuotaNumero;
    private String cuotaMonto;
    
    private String cooperativaLugar;

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

    public String getEmpresaNombre() {
        return empresaNombre;
    }

    public void setEmpresaNombre(String empresaNombre) {
        this.empresaNombre = empresaNombre;
    }

    public String getAsociadoDomicilio() {
        return asociadoDomicilio;
    }

    public void setAsociadoDomicilio(String asociadoDomicilio) {
        this.asociadoDomicilio = asociadoDomicilio;
    }

    public String getAsociadoDepartamento() {
        return asociadoDepartamento;
    }

    public void setAsociadoDepartamento(String asociadoDepartamento) {
        this.asociadoDepartamento = asociadoDepartamento;
    }

    public String getAsociadoNit() {
        return asociadoNit;
    }

    public void setAsociadoNit(String asociadoNit) {
        this.asociadoNit = asociadoNit;
    }

    public String getPrestamoLinea() {
        return prestamoLinea;
    }

    public void setPrestamoLinea(String prestamoLinea) {
        this.prestamoLinea = prestamoLinea;
    }

    public String getBancoNombre() {
        return bancoNombre;
    }

    public void setBancoNombre(String bancoNombre) {
        this.bancoNombre = bancoNombre;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFirmaNombre() {
        return firmaNombre;
    }

    public void setFirmaNombre(String firmaNombre) {
        this.firmaNombre = firmaNombre;
    }

    public String getCuotaNumero() {
        return cuotaNumero;
    }

    public void setCuotaNumero(String cuotaNumero) {
        this.cuotaNumero = cuotaNumero;
    }

    public String getCuotaMonto() {
        return cuotaMonto;
    }

    public void setCuotaMonto(String cuotaMonto) {
        this.cuotaMonto = cuotaMonto;
    }

    public String getCooperativaLugar() {
        return cooperativaLugar;
    }

    public void setCooperativaLugar(String cooperativaLugar) {
        this.cooperativaLugar = cooperativaLugar;
    }

}
