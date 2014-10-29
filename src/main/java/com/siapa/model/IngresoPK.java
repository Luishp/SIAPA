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
public class IngresoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "FI_ID", nullable = false)
    private int fiId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SOLICITUD_ID", nullable = false)
    private int solicitudId;

    public IngresoPK() {
    }

    public IngresoPK(int fiId, int solicitudId) {
        this.fiId = fiId;
        this.solicitudId = solicitudId;
    }

    public int getFiId() {
        return fiId;
    }

    public void setFiId(int fiId) {
        this.fiId = fiId;
    }

    public int getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(int solicitudId) {
        this.solicitudId = solicitudId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) fiId;
        hash += (int) solicitudId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoPK)) {
            return false;
        }
        IngresoPK other = (IngresoPK) object;
        if (this.fiId != other.fiId) {
            return false;
        }
        if (this.solicitudId != other.solicitudId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.IngresoPK[ fiId=" + fiId + ", solicitudId=" + solicitudId + " ]";
    }
    
}
