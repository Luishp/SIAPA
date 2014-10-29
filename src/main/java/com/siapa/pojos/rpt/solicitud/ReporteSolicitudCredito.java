/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.solicitud;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Angel
 */
public class ReporteSolicitudCredito implements Serializable{
 
private RptDatosAsociados datosasociados;
private RptDatosCredito datoscredito;
private RptDatosConyuge datosconyuge;
private List<RptDeudasComerciales> deudascomerciales;
private RptEmpleoAnt empleoanterior;
private RptInfoFinanciera infofinanciera;    
private RptInformacionLaboral infolaboral;
private List<RptPrestamos> prestamosext;
private List<RptPrestamos> prestamosint;
private List<RptPropiedades> propiedades;
private List<RptReferencias> refenciasfam;
private List<RptReferencias> referenciasper;
private List<RptTarjetasCredito> tarjetascredito;

    public ReporteSolicitudCredito(RptDatosAsociados datosasociados, RptDatosCredito datoscredito, RptDatosConyuge datosconyuge, List<RptDeudasComerciales> deudascomerciales, RptEmpleoAnt empleoanterior, RptInfoFinanciera infofinanciera, RptInformacionLaboral infolaboral, List<RptPrestamos> prestamosext, List<RptPrestamos> prestamosint, List<RptPropiedades> propiedades, List<RptReferencias> refenciasfam, List<RptReferencias> referenciasper, List<RptTarjetasCredito> tarjetascredito) {
        this.datosasociados = datosasociados;
        this.datoscredito = datoscredito;
        this.datosconyuge = datosconyuge;
        this.deudascomerciales = deudascomerciales;
        this.empleoanterior = empleoanterior;
        this.infofinanciera = infofinanciera;
        this.infolaboral = infolaboral;
        this.prestamosext = prestamosext;
        this.prestamosint = prestamosint;
        this.propiedades = propiedades;
        this.refenciasfam = refenciasfam;
        this.referenciasper = referenciasper;
        this.tarjetascredito = tarjetascredito;
    }

    public ReporteSolicitudCredito() {
    }

    public RptDatosAsociados getDatosasociados() {
        return datosasociados;
    }

    public void setDatosasociados(RptDatosAsociados datosasociados) {
        this.datosasociados = datosasociados;
    }

    public RptDatosCredito getDatoscredito() {
        return datoscredito;
    }

    public void setDatoscredito(RptDatosCredito datoscredito) {
        this.datoscredito = datoscredito;
    }

    public RptDatosConyuge getDatosconyuge() {
        return datosconyuge;
    }

    public void setDatosconyuge(RptDatosConyuge datosconyuge) {
        this.datosconyuge = datosconyuge;
    }

    public List<RptDeudasComerciales> getDeudascomerciales() {
        return deudascomerciales;
    }

    public void setDeudascomerciales(List<RptDeudasComerciales> deudascomerciales) {
        this.deudascomerciales = deudascomerciales;
    }

    public RptEmpleoAnt getEmpleoanterior() {
        return empleoanterior;
    }

    public void setEmpleoanterior(RptEmpleoAnt empleoanterior) {
        this.empleoanterior = empleoanterior;
    }

    public RptInfoFinanciera getInfofinanciera() {
        return infofinanciera;
    }

    public void setInfofinanciera(RptInfoFinanciera infofinanciera) {
        this.infofinanciera = infofinanciera;
    }

    public RptInformacionLaboral getInfolaboral() {
        return infolaboral;
    }

    public void setInfolaboral(RptInformacionLaboral infolaboral) {
        this.infolaboral = infolaboral;
    }

    public List<RptPrestamos> getPrestamosext() {
        return prestamosext;
    }

    public void setPrestamosext(List<RptPrestamos> prestamosext) {
        this.prestamosext = prestamosext;
    }

    public List<RptPrestamos> getPrestamosint() {
        return prestamosint;
    }

    public void setPrestamosint(List<RptPrestamos> prestamosint) {
        this.prestamosint = prestamosint;
    }

    public List<RptPropiedades> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<RptPropiedades> propiedades) {
        this.propiedades = propiedades;
    }

    public List<RptReferencias> getRefenciasfam() {
        return refenciasfam;
    }

    public void setRefenciasfam(List<RptReferencias> refenciasfam) {
        this.refenciasfam = refenciasfam;
    }

    public List<RptReferencias> getReferenciasper() {
        return referenciasper;
    }

    public void setReferenciasper(List<RptReferencias> referenciasper) {
        this.referenciasper = referenciasper;
    }

    public List<RptTarjetasCredito> getTarjetascredito() {
        return tarjetascredito;
    }

    public void setTarjetascredito(List<RptTarjetasCredito> tarjetascredito) {
        this.tarjetascredito = tarjetascredito;
    }
}
