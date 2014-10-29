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
public class IngresoanalisisPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_ID", nullable = false)
    private int analisisId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FI_ID", nullable = false)
    private int fiId;

    public IngresoanalisisPK() {
    }

    public IngresoanalisisPK(int analisisId, int fiId) {
        this.analisisId = analisisId;
        this.fiId = fiId;
    }

    public int getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(int analisisId) {
        this.analisisId = analisisId;
    }

    public int getFiId() {
        return fiId;
    }

    public void setFiId(int fiId) {
        this.fiId = fiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) analisisId;
        hash += (int) fiId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoanalisisPK)) {
            return false;
        }
        IngresoanalisisPK other = (IngresoanalisisPK) object;
        if (this.analisisId != other.analisisId) {
            return false;
        }
        if (this.fiId != other.fiId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.IngresoanalisisPK[ analisisId=" + analisisId + ", fiId=" + fiId + " ]";
    }
    
}
