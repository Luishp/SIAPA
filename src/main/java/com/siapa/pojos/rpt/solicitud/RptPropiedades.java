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
public class RptPropiedades implements Serializable{
    private String claseprop;
    private String ubicacion;
    private String valor;
    private String hipoteca;

    public String getClaseprop() {
        return claseprop;
    }

    public void setClaseprop(String claseprop) {
        this.claseprop = claseprop;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(String hipoteca) {
        this.hipoteca = hipoteca;
    }
}
