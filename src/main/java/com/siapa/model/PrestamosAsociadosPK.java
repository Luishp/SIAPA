/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author marlon.andrade
 */
@Embeddable
public class PrestamosAsociadosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PRESTAMO_ID", nullable = false)
    private int prestamoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDASOCIADOS", nullable = false)
    private int idasociados;

    public PrestamosAsociadosPK() {
    }

    public PrestamosAsociadosPK(int prestamoId, int idasociados) {
        this.prestamoId = prestamoId;
        this.idasociados = idasociados;
    }


    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public int getIdasociados() {
        return idasociados;
    }

    
    public void setIdasociados(int idasociados) {
        this.idasociados = idasociados;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) prestamoId;
        hash += (int) idasociados;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamosAsociadosPK)) {
            return false;
        }
        PrestamosAsociadosPK other = (PrestamosAsociadosPK) object;
        if (this.prestamoId != other.prestamoId) {
            return false;
        }
        if(this.idasociados != other.idasociados) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.PrestamosAsociadosPK[ prestamoId=" + prestamoId + ", idasociados=" + idasociados + " ]";
    }

}
