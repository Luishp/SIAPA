/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitosolicitadogarantia.findAll", query = "SELECT r FROM Requisitosolicitadogarantia r")})
public class Requisitosolicitadogarantia implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitosolicitadogarantiaPK requisitosolicitadogarantiaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RSG_ENTREGADO", nullable = false)
    private boolean rsgEntregado;
    @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asesoria asesoria;
    @JoinColumn(name = "RG_ID", referencedColumnName = "RG_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Requisitogarantia requisitogarantia;

    public Requisitosolicitadogarantia() {
    }

    public Requisitosolicitadogarantia(RequisitosolicitadogarantiaPK requisitosolicitadogarantiaPK) {
        this.requisitosolicitadogarantiaPK = requisitosolicitadogarantiaPK;
    }

    public Requisitosolicitadogarantia(RequisitosolicitadogarantiaPK requisitosolicitadogarantiaPK, boolean rsgEntregado) {
        this.requisitosolicitadogarantiaPK = requisitosolicitadogarantiaPK;
        this.rsgEntregado = rsgEntregado;
    }

    public Requisitosolicitadogarantia(int rgId, int asesoriaId) {
        this.requisitosolicitadogarantiaPK = new RequisitosolicitadogarantiaPK(rgId, asesoriaId);
    }

    public RequisitosolicitadogarantiaPK getRequisitosolicitadogarantiaPK() {
        return requisitosolicitadogarantiaPK;
    }

    public void setRequisitosolicitadogarantiaPK(RequisitosolicitadogarantiaPK requisitosolicitadogarantiaPK) {
        this.requisitosolicitadogarantiaPK = requisitosolicitadogarantiaPK;
    }

    public boolean getRsgEntregado() {
        return rsgEntregado;
    }

    public void setRsgEntregado(boolean rsgEntregado) {
        this.rsgEntregado = rsgEntregado;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Requisitogarantia getRequisitogarantia() {
        return requisitogarantia;
    }

    public void setRequisitogarantia(Requisitogarantia requisitogarantia) {
        this.requisitogarantia = requisitogarantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitosolicitadogarantiaPK != null ? requisitosolicitadogarantiaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitosolicitadogarantia)) {
            return false;
        }
        Requisitosolicitadogarantia other = (Requisitosolicitadogarantia) object;
        if ((this.requisitosolicitadogarantiaPK == null && other.requisitosolicitadogarantiaPK != null) || (this.requisitosolicitadogarantiaPK != null && !this.requisitosolicitadogarantiaPK.equals(other.requisitosolicitadogarantiaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitosolicitadogarantia[ requisitosolicitadogarantiaPK=" + requisitosolicitadogarantiaPK + " ]";
    }
    
}
