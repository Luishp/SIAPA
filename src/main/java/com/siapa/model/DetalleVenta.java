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
@Table(name = "detalle_venta", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")})
public class DetalleVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_VENTA", nullable = false)
    private Long idDetalleVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_DETALLE_VENTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadDetalleVenta;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_DES_DETALLE_VENTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal porcentajeDesDetalleVenta;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta idVenta;

    public DetalleVenta() {
    }

    public DetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public DetalleVenta(Long idDetalleVenta, BigDecimal cantidadDetalleVenta, BigDecimal porcentajeDesDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidadDetalleVenta = cantidadDetalleVenta;
        this.porcentajeDesDetalleVenta = porcentajeDesDetalleVenta;
    }

    public Long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public BigDecimal getCantidadDetalleVenta() {
        return cantidadDetalleVenta;
    }

    public void setCantidadDetalleVenta(BigDecimal cantidadDetalleVenta) {
        this.cantidadDetalleVenta = cantidadDetalleVenta;
    }

    public BigDecimal getPorcentajeDesDetalleVenta() {
        return porcentajeDesDetalleVenta;
    }

    public void setPorcentajeDesDetalleVenta(BigDecimal porcentajeDesDetalleVenta) {
        this.porcentajeDesDetalleVenta = porcentajeDesDetalleVenta;
    }

    public Jaula getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(Jaula idJaula) {
        this.idJaula = idJaula;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Venta getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Venta idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVenta != null ? idDetalleVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.idDetalleVenta == null && other.idDetalleVenta != null) || (this.idDetalleVenta != null && !this.idDetalleVenta.equals(other.idDetalleVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.DetalleVenta[ idDetalleVenta=" + idDetalleVenta + " ]";
    }
    
}
