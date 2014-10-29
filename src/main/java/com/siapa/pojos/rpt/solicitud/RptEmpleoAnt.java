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
public class RptEmpleoAnt implements Serializable{
private String empresaanterior;
private String dirempresaant;
private String fechaingresoant;
private String fecharetiroant;
private String telant;
private String cargoant;  

    public String getEmpresaanterior() {
        return empresaanterior;
    }

    public void setEmpresaanterior(String empresaanterior) {
        this.empresaanterior = empresaanterior;
    }

    public String getDirempresaant() {
        return dirempresaant;
    }

    public void setDirempresaant(String dirempresaant) {
        this.dirempresaant = dirempresaant;
    }

    public String getFechaingresoant() {
        return fechaingresoant;
    }

    public void setFechaingresoant(String fechaingresoant) {
        this.fechaingresoant = fechaingresoant;
    }

    public String getFecharetiroant() {
        return fecharetiroant;
    }

    public void setFecharetiroant(String fecharetiroant) {
        this.fecharetiroant = fecharetiroant;
    }

    public String getTelant() {
        return telant;
    }

    public void setTelant(String telant) {
        this.telant = telant;
    }

    public String getCargoant() {
        return cargoant;
    }

    public void setCargoant(String cargoant) {
        this.cargoant = cargoant;
    }
}
