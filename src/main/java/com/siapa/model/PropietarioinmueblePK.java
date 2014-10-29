package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Cristian Oswaldo Fuentes
 */
@Embeddable
public class PropietarioinmueblePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "RGH_ID")
    private int rghId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CORRELATIVO")
    private int correlativo;

    public PropietarioinmueblePK() {
    }

    public PropietarioinmueblePK(int rghId, int correlativo) {
        this.rghId = rghId;
        this.correlativo = correlativo;
    }

    public int getRghId() {
        return rghId;
    }

    public void setRghId(int rghId) {
        this.rghId = rghId;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) rghId;
        hash += (int) correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PropietarioinmueblePK)) {
            return false;
        }
        PropietarioinmueblePK other = (PropietarioinmueblePK) object;
        if (this.rghId != other.rghId) {
            return false;
        }
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.PropietarioinmueblePK[ rghId=" + rghId + ", correlativo=" + correlativo + " ]";
    }

}
