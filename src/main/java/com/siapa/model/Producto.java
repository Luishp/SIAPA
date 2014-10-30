/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Angel
 */
@Entity
@Table(catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")})
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO", nullable = false)
    private Long idProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PRODUCTO", nullable = false, length = 50)
    private String nombreProducto;
    @Column(name = "DESCRIPCION_PRODUCTO", length = 500)
    private String descripcionProducto;
    @Basic(optional = false)
    @Column(name = "ACTIVO_PRODUCTO", nullable = false)
    private boolean activoProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRECIO_PRODUCTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioProducto;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.LAZY)
    private Set<IngresoProducto> ingresoProductoSet;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.LAZY)
    private Set<Descuento> descuentoSet;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.LAZY)
    private Set<DetalleVenta> detalleVentaSet;

    public Producto() {
    }

    public Producto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Long idProducto, String nombreProducto, boolean activoProducto, BigDecimal precioProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.activoProducto = activoProducto;
        this.precioProducto = precioProducto;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public boolean getActivoProducto() {
        return activoProducto;
    }

    public void setActivoProducto(boolean activoProducto) {
        this.activoProducto = activoProducto;
    }

    public BigDecimal getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(BigDecimal precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Set<IngresoProducto> getIngresoProductoSet() {
        return ingresoProductoSet;
    }

    public void setIngresoProductoSet(Set<IngresoProducto> ingresoProductoSet) {
        this.ingresoProductoSet = ingresoProductoSet;
    }

    public Set<Descuento> getDescuentoSet() {
        return descuentoSet;
    }

    public void setDescuentoSet(Set<Descuento> descuentoSet) {
        this.descuentoSet = descuentoSet;
    }

    public Set<DetalleVenta> getDetalleVentaSet() {
        return detalleVentaSet;
    }

    public void setDetalleVentaSet(Set<DetalleVenta> detalleVentaSet) {
        this.detalleVentaSet = detalleVentaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
