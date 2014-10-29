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
public class AsistentePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_ID", nullable = false)
    private int accId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MCC_ID", nullable = false)
    private int mccId;

    public AsistentePK() {
    }

    public AsistentePK(int accId, int mccId) {
        this.accId = accId;
        this.mccId = mccId;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getMccId() {
        return mccId;
    }

    public void setMccId(int mccId) {
        this.mccId = mccId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) accId;
        hash += (int) mccId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsistentePK)) {
            return false;
        }
        AsistentePK other = (AsistentePK) object;
        if (this.accId != other.accId) {
            return false;
        }
        if (this.mccId != other.mccId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.AsistentePK[ accId=" + accId + ", mccId=" + mccId + " ]";
    }
    
}
