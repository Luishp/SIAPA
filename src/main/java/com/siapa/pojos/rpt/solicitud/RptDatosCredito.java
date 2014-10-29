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
public class RptDatosCredito implements Serializable{
   private String idSolicitud;
   private String monto;
   private String plazo;
   private String destino;
   private String recibesueldo;
   private String diapago;
   private String formapago;
   private String garantia;
   private String aplicapromocion;

    
    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getRecibesueldo() {
        return recibesueldo;
    }

    public void setRecibesueldo(String recibesueldo) {
        this.recibesueldo = recibesueldo;
    }

    public String getDiapago() {
        return diapago;
    }

    public void setDiapago(String diapago) {
        this.diapago = diapago;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getAplicapromocion() {
        return aplicapromocion;
    }

    public void setAplicapromocion(String aplicapromocion) {
        this.aplicapromocion = aplicapromocion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    
}
