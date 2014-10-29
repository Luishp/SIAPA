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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "ingreso", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingreso.findAll", query = "SELECT i FROM Ingreso i")})
public class Ingreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngresoPK ingresoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "INGRESO_CANTIDAD", nullable = false, precision = 10, scale = 2)
    private BigDecimal ingresoCantidad;
    @Size(max = 500)
    @Column(name = "INGRESO_DESCRIPCION", length = 500)
    private String ingresoDescripcion;
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Solicitud solicitud;
    @JoinColumn(name = "FI_ID", referencedColumnName = "FI_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fuenteingreso fuenteingreso;

    public Ingreso() {
    }

    public Ingreso(IngresoPK ingresoPK) {
        this.ingresoPK = ingresoPK;
    }

    public Ingreso(IngresoPK ingresoPK, BigDecimal ingresoCantidad) {
        this.ingresoPK = ingresoPK;
        this.ingresoCantidad = ingresoCantidad;
    }

    public Ingreso(int fiId, int solicitudId) {
        this.ingresoPK = new IngresoPK(fiId, solicitudId);
    }

    public IngresoPK getIngresoPK() {
        return ingresoPK;
    }

    public void setIngresoPK(IngresoPK ingresoPK) {
        this.ingresoPK = ingresoPK;
    }

    public BigDecimal getIngresoCantidad() {
        return ingresoCantidad;
    }

    public void setIngresoCantidad(BigDecimal ingresoCantidad) {
        this.ingresoCantidad = ingresoCantidad;
    }

    public String getIngresoDescripcion() {
        return ingresoDescripcion;
    }

    public void setIngresoDescripcion(String ingresoDescripcion) {
        this.ingresoDescripcion = ingresoDescripcion;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public Fuenteingreso getFuenteingreso() {
        return fuenteingreso;
    }

    public void setFuenteingreso(Fuenteingreso fuenteingreso) {
        this.fuenteingreso = fuenteingreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingresoPK != null ? ingresoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingreso)) {
            return false;
        }
        Ingreso other = (Ingreso) object;
        if ((this.ingresoPK == null && other.ingresoPK != null) || (this.ingresoPK != null && !this.ingresoPK.equals(other.ingresoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Ingreso[ ingresoPK=" + ingresoPK + " ]";
    }

}
