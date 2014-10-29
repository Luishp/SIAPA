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
public class AnalisisenagendacomitecreditosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_ID", nullable = false)
    private int accId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ANALISIS_ID", nullable = false)
    private int analisisId;

    public AnalisisenagendacomitecreditosPK() {
    }

    public AnalisisenagendacomitecreditosPK(int accId, int analisisId) {
        this.accId = accId;
        this.analisisId = analisisId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(int analisisId) {
        this.analisisId = analisisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) accId;
        hash += (int) analisisId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnalisisenagendacomitecreditosPK)) {
            return false;
        }
        AnalisisenagendacomitecreditosPK other = (AnalisisenagendacomitecreditosPK) object;
        if (this.accId != other.accId) {
            return false;
        }
        if (this.analisisId != other.analisisId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.AsistentePK[ accId=" + accId + ", analisisId=" + analisisId + " ]";
    }
    
}
