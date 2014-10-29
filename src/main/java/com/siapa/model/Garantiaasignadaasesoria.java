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
@Table(name = "garantiaasignadaasesoria", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantiaasignadaasesoria.findAll", query = "SELECT g FROM Garantiaasignadaasesoria g")})
public class Garantiaasignadaasesoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GarantiaasignadaasesoriaPK garantiaasignadaasesoriaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAAS_CANTIDAD", nullable = false)
    private int gaasCantidad;
    @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asesoria asesoria;
    @JoinColumn(name = "GARANTIA_ID", referencedColumnName = "GARANTIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Garantia garantia;

    public Garantiaasignadaasesoria() {
    }

    public Garantiaasignadaasesoria(GarantiaasignadaasesoriaPK garantiaasignadaasesoriaPK) {
        this.garantiaasignadaasesoriaPK = garantiaasignadaasesoriaPK;
    }

    public Garantiaasignadaasesoria(GarantiaasignadaasesoriaPK garantiaasignadaasesoriaPK, int gaasCantidad) {
        this.garantiaasignadaasesoriaPK = garantiaasignadaasesoriaPK;
        this.gaasCantidad = gaasCantidad;
    }

    public Garantiaasignadaasesoria(int garantiaId, int asesoriaId) {
        this.garantiaasignadaasesoriaPK = new GarantiaasignadaasesoriaPK(garantiaId, asesoriaId);
    }

    public GarantiaasignadaasesoriaPK getGarantiaasignadaasesoriaPK() {
        return garantiaasignadaasesoriaPK;
    }

    public void setGarantiaasignadaasesoriaPK(GarantiaasignadaasesoriaPK garantiaasignadaasesoriaPK) {
        this.garantiaasignadaasesoriaPK = garantiaasignadaasesoriaPK;
    }

    public int getGaasCantidad() {
        return gaasCantidad;
    }

    public void setGaasCantidad(int gaasCantidad) {
        this.gaasCantidad = gaasCantidad;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garantiaasignadaasesoriaPK != null ? garantiaasignadaasesoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantiaasignadaasesoria)) {
            return false;
        }
        Garantiaasignadaasesoria other = (Garantiaasignadaasesoria) object;
        if ((this.garantiaasignadaasesoriaPK == null && other.garantiaasignadaasesoriaPK != null) || (this.garantiaasignadaasesoriaPK != null && !this.garantiaasignadaasesoriaPK.equals(other.garantiaasignadaasesoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Garantiaasignadaasesoria[ garantiaasignadaasesoriaPK=" + garantiaasignadaasesoriaPK + " ]";
    }
    
}
