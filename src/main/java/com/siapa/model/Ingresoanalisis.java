/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    @NamedQuery(name = "Ingresoanalisis.findAll", query = "SELECT i FROM Ingresoanalisis i")})
public class Ingresoanalisis implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresoanalisisPK ingresoanalisisPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "IA_CANTIDAD", nullable = false, precision = 10, scale = 2)
    private BigDecimal iaCantidad;
    @JoinColumn(name = "FI_ID", referencedColumnName = "FI_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fuenteingreso fuenteingreso;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Analisis analisis;

    public Ingresoanalisis() {
    }

    public Ingresoanalisis(IngresoanalisisPK ingresoanalisisPK) {
        this.ingresoanalisisPK = ingresoanalisisPK;
    }

    public Ingresoanalisis(IngresoanalisisPK ingresoanalisisPK, BigDecimal iaCantidad) {
        this.ingresoanalisisPK = ingresoanalisisPK;
        this.iaCantidad = iaCantidad;
    }

    public Ingresoanalisis(int analisisId, int fiId) {
        this.ingresoanalisisPK = new IngresoanalisisPK(analisisId, fiId);
    }

    public IngresoanalisisPK getIngresoanalisisPK() {
        return ingresoanalisisPK;
    }

    public void setIngresoanalisisPK(IngresoanalisisPK ingresoanalisisPK) {
        this.ingresoanalisisPK = ingresoanalisisPK;
    }

    public BigDecimal getIaCantidad() {
        return iaCantidad;
    }

    public void setIaCantidad(BigDecimal iaCantidad) {
        this.iaCantidad = iaCantidad;
    }

    public Fuenteingreso getFuenteingreso() {
        return fuenteingreso;
    }

    public void setFuenteingreso(Fuenteingreso fuenteingreso) {
        this.fuenteingreso = fuenteingreso;
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
        hash += (ingresoanalisisPK != null ? ingresoanalisisPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresoanalisis)) {
            return false;
        }
        Ingresoanalisis other = (Ingresoanalisis) object;
        if ((this.ingresoanalisisPK == null && other.ingresoanalisisPK != null) || (this.ingresoanalisisPK != null && !this.ingresoanalisisPK.equals(other.ingresoanalisisPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Ingresoanalisis[ ingresoanalisisPK=" + ingresoanalisisPK + " ]";
    }
    
}
