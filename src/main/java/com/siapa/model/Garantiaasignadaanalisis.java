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
    @NamedQuery(name = "Garantiaasignadaanalisis.findAll", query = "SELECT g FROM Garantiaasignadaanalisis g")})
public class Garantiaasignadaanalisis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GarantiaasignadaanalisisPK garantiaasignadaanalisisPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAAN_CANTIDAD", nullable = false)
    private int gaanCantidad;
    @JoinColumn(name = "GARANTIA_ID", referencedColumnName = "GARANTIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Garantia garantia;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Analisis analisis;

    public Garantiaasignadaanalisis() {
    }

    public Garantiaasignadaanalisis(GarantiaasignadaanalisisPK garantiaasignadaanalisisPK) {
        this.garantiaasignadaanalisisPK = garantiaasignadaanalisisPK;
    }

    public Garantiaasignadaanalisis(GarantiaasignadaanalisisPK garantiaasignadaanalisisPK, int gaanCantidad) {
        this.garantiaasignadaanalisisPK = garantiaasignadaanalisisPK;
        this.gaanCantidad = gaanCantidad;
    }

    public Garantiaasignadaanalisis(int analisisId, int garantiaId) {
        this.garantiaasignadaanalisisPK = new GarantiaasignadaanalisisPK(analisisId, garantiaId);
    }

    public GarantiaasignadaanalisisPK getGarantiaasignadaanalisisPK() {
        return garantiaasignadaanalisisPK;
    }

    public void setGarantiaasignadaanalisisPK(GarantiaasignadaanalisisPK garantiaasignadaanalisisPK) {
        this.garantiaasignadaanalisisPK = garantiaasignadaanalisisPK;
    }

    public int getGaanCantidad() {
        return gaanCantidad;
    }

    public void setGaanCantidad(int gaanCantidad) {
        this.gaanCantidad = gaanCantidad;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garantiaasignadaanalisisPK != null ? garantiaasignadaanalisisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantiaasignadaanalisis)) {
            return false;
        }
        Garantiaasignadaanalisis other = (Garantiaasignadaanalisis) object;
        if ((this.garantiaasignadaanalisisPK == null && other.garantiaasignadaanalisisPK != null) || (this.garantiaasignadaanalisisPK != null && !this.garantiaasignadaanalisisPK.equals(other.garantiaasignadaanalisisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Garantiaasignadaanalisis[ garantiaasignadaanalisisPK=" + garantiaasignadaanalisisPK + " ]";
    }
    
}
