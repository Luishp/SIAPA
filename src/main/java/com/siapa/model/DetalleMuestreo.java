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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "detalle_muestreo", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleMuestreo.findAll", query = "SELECT d FROM DetalleMuestreo d")})
public class DetalleMuestreo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_DETALLE_MUESTREO", nullable = false)
    private Integer idDetalleMuestreo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_DETALLE_MUESTREO", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadDetalleMuestreo;
    @Basic(optional = false)
    @Column(name = "PESO_DETALLE_MUESTREO", nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoDetalleMuestreo;
    @JoinColumn(name = "ID_MUESTREO", referencedColumnName = "ID_MUESTREO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Muestreo idMuestreo;

    public DetalleMuestreo() {
    }

    public DetalleMuestreo(Integer idDetalleMuestreo) {
        this.idDetalleMuestreo = idDetalleMuestreo;
    }

    public DetalleMuestreo(Integer idDetalleMuestreo, BigDecimal cantidadDetalleMuestreo, BigDecimal pesoDetalleMuestreo) {
        this.idDetalleMuestreo = idDetalleMuestreo;
        this.cantidadDetalleMuestreo = cantidadDetalleMuestreo;
        this.pesoDetalleMuestreo = pesoDetalleMuestreo;
    }

    public Integer getIdDetalleMuestreo() {
        return idDetalleMuestreo;
    }

    public void setIdDetalleMuestreo(Integer idDetalleMuestreo) {
        this.idDetalleMuestreo = idDetalleMuestreo;
    }

    public BigDecimal getCantidadDetalleMuestreo() {
        return cantidadDetalleMuestreo;
    }

    public void setCantidadDetalleMuestreo(BigDecimal cantidadDetalleMuestreo) {
        this.cantidadDetalleMuestreo = cantidadDetalleMuestreo;
    }

    public BigDecimal getPesoDetalleMuestreo() {
        return pesoDetalleMuestreo;
    }

    public void setPesoDetalleMuestreo(BigDecimal pesoDetalleMuestreo) {
        this.pesoDetalleMuestreo = pesoDetalleMuestreo;
    }

    public Muestreo getIdMuestreo() {
        return idMuestreo;
    }

    public void setIdMuestreo(Muestreo idMuestreo) {
        this.idMuestreo = idMuestreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleMuestreo != null ? idDetalleMuestreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleMuestreo)) {
            return false;
        }
        DetalleMuestreo other = (DetalleMuestreo) object;
        if ((this.idDetalleMuestreo == null && other.idDetalleMuestreo != null) || (this.idDetalleMuestreo != null && !this.idDetalleMuestreo.equals(other.idDetalleMuestreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.DetalleMuestreo[ idDetalleMuestreo=" + idDetalleMuestreo + " ]";
    }
    
}
