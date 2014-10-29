/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.analisis;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Fm
 */
public class ReporteAnalisisPojo implements Serializable{
    
    private String nombre;
    private String codigo;
    private String ejecutivo;
    private String fecha;
    private RptAnalisisPerfilAsociadoPojo perfilAsociado;
    private RptSituacionLaboral situacionLaboral;
    private List<RptDescuentosInstitucionesFinancieras> descuentosInstitucionesFinancierasList;
    private String totalLiquidoARecibir;
    private String montoSolicitado;
    private String vecesSalario;
    private RptSituacionEconomicaFamiliar situacionEconomicaFamiliar;
    private List<RptDeudasPojo> situacionCrediticia;
    private List<RptDeudasPojo> deudasACancelar;
    private RptFormaPago formaPago;
    private List<RptBurosCredito> burosCreditoList;
    private RptAsegurabilidad asegurabilidad;
    private List<RptGarantia> garantiaList;
    private String observaciones;
    private String comentarios;
    private String conclusiones;
    private String recomendaciones;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEjecutivo() {
        return ejecutivo;
    }

    public void setEjecutivo(String ejecutivo) {
        this.ejecutivo = ejecutivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public RptAnalisisPerfilAsociadoPojo getPerfilAsociado() {
        return perfilAsociado;
    }

    public void setPerfilAsociado(RptAnalisisPerfilAsociadoPojo perfilAsociado) {
        this.perfilAsociado = perfilAsociado;
    }

    public RptSituacionLaboral getSituacionLaboral() {
        return situacionLaboral;
    }

    public void setSituacionLaboral(RptSituacionLaboral situacionLaboral) {
        this.situacionLaboral = situacionLaboral;
    }

    public List<RptDescuentosInstitucionesFinancieras> getDescuentosInstitucionesFinancierasList() {
        return descuentosInstitucionesFinancierasList;
    }

    public void setDescuentosInstitucionesFinancierasList(List<RptDescuentosInstitucionesFinancieras> descuentosInstitucionesFinancierasList) {
        this.descuentosInstitucionesFinancierasList = descuentosInstitucionesFinancierasList;
    }

    public String getTotalLiquidoARecibir() {
        return totalLiquidoARecibir;
    }

    public void setTotalLiquidoARecibir(String totalLiquidoARecibir) {
        this.totalLiquidoARecibir = totalLiquidoARecibir;
    }

    public String getMontoSolicitado() {
        return montoSolicitado;
    }

    public void setMontoSolicitado(String montoSolicitado) {
        this.montoSolicitado = montoSolicitado;
    }

    public String getVecesSalario() {
        return vecesSalario;
    }

    public void setVecesSalario(String vecesSalario) {
        this.vecesSalario = vecesSalario;
    }

    public RptSituacionEconomicaFamiliar getSituacionEconomicaFamiliar() {
        return situacionEconomicaFamiliar;
    }

    public void setSituacionEconomicaFamiliar(RptSituacionEconomicaFamiliar situacionEconomicaFamiliar) {
        this.situacionEconomicaFamiliar = situacionEconomicaFamiliar;
    }

    public List<RptDeudasPojo> getSituacionCrediticia() {
        return situacionCrediticia;
    }

    public void setSituacionCrediticia(List<RptDeudasPojo> situacionCrediticia) {
        this.situacionCrediticia = situacionCrediticia;
    }

    public List<RptDeudasPojo> getDeudasACancelar() {
        return deudasACancelar;
    }

    public void setDeudasACancelar(List<RptDeudasPojo> deudasACancelar) {
        this.deudasACancelar = deudasACancelar;
    }

    public RptFormaPago getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(RptFormaPago formaPago) {
        this.formaPago = formaPago;
    }

    public List<RptBurosCredito> getBurosCreditoList() {
        return burosCreditoList;
    }

    public void setBurosCreditoList(List<RptBurosCredito> burosCreditoList) {
        this.burosCreditoList = burosCreditoList;
    }

    public RptAsegurabilidad getAsegurabilidad() {
        return asegurabilidad;
    }

    public void setAsegurabilidad(RptAsegurabilidad asegurabilidad) {
        this.asegurabilidad = asegurabilidad;
    }

    public List<RptGarantia> getGarantiaList() {
        return garantiaList;
    }

    public void setGarantiaList(List<RptGarantia> garantiaList) {
        this.garantiaList = garantiaList;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getConclusiones() {
        return conclusiones;
    }

    public void setConclusiones(String conclusiones) {
        this.conclusiones = conclusiones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
}
