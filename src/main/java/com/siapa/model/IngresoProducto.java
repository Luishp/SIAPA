/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "ingreso_producto", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "IngresoProducto.findAll", query = "SELECT i FROM IngresoProducto i")})
public class IngresoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_INGRESO_PRODUCTO", nullable = true)
    private Integer idIngresoProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_INGRESO_PRODUCTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadIngresoProducto;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_INGRESO_PRODUCTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraIngresoProducto;
    @Basic(optional = false)
    @Column(name = "USUARIO_INGRESO_PRODUCTO", nullable = false, length = 30)
    private String usuarioIngresoProducto;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;

    public IngresoProducto() {
    }

    public IngresoProducto(Integer idIngresoProducto) {
        this.idIngresoProducto = idIngresoProducto;
    }

    public IngresoProducto(Integer idIngresoProducto, BigDecimal cantidadIngresoProducto, Date fechaHoraIngresoProducto, String usuarioIngresoProducto) {
        this.idIngresoProducto = idIngresoProducto;
        this.cantidadIngresoProducto = cantidadIngresoProducto;
        this.fechaHoraIngresoProducto = fechaHoraIngresoProducto;
        this.usuarioIngresoProducto = usuarioIngresoProducto;
    }

    public Integer getIdIngresoProducto() {
        return idIngresoProducto;
    }

    public void setIdIngresoProducto(Integer idIngresoProducto) {
        this.idIngresoProducto = idIngresoProducto;
    }

    public BigDecimal getCantidadIngresoProducto() {
        return cantidadIngresoProducto;
    }

    public void setCantidadIngresoProducto(BigDecimal cantidadIngresoProducto) {
        this.cantidadIngresoProducto = cantidadIngresoProducto;
    }

    public Date getFechaHoraIngresoProducto() {
        return fechaHoraIngresoProducto;
    }

    public void setFechaHoraIngresoProducto(Date fechaHoraIngresoProducto) {
        this.fechaHoraIngresoProducto = fechaHoraIngresoProducto;
    }

    public String getUsuarioIngresoProducto() {
        return usuarioIngresoProducto;
    }

    public void setUsuarioIngresoProducto(String usuarioIngresoProducto) {
        this.usuarioIngresoProducto = usuarioIngresoProducto;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Jaula getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(Jaula idJaula) {
        this.idJaula = idJaula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngresoProducto != null ? idIngresoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoProducto)) {
            return false;
        }
        IngresoProducto other = (IngresoProducto) object;
        if ((this.idIngresoProducto == null && other.idIngresoProducto != null) || (this.idIngresoProducto != null && !this.idIngresoProducto.equals(other.idIngresoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.IngresoProducto[ idIngresoProducto=" + idIngresoProducto + " ]";
    }
    
}
