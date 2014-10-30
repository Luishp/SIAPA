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
@Table(name = "detalle_comprobante_venta", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleComprobanteVenta.findAll", query = "SELECT d FROM DetalleComprobanteVenta d")})
public class DetalleComprobanteVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_COMPROBANTE_VENTA", nullable = false)
    private Long idDetalleComprobanteVenta;
    @Basic(optional = false)
    @Column(name = "PRODUCTO_DETALLE_COMP_VENTA", nullable = false, length = 50)
    private String productoDetalleCompVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_DETALLE_COMP_VENTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadDetalleCompVenta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_DETALLE_COMP_VENTA", nullable = false, length = 500)
    private String descripcionDetalleCompVenta;
    @Basic(optional = false)
    @Column(name = "PRECIO_UNITARIO_DET_COMP_VENTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitarioDetCompVenta;
    @Basic(optional = false)
    @Column(name = "TIPO_VENTA_DETALLE_COMP_VENTA", nullable = false, length = 1)
    private String tipoVentaDetalleCompVenta;
    @Basic(optional = false)
    @Column(name = "TOTAL_DETALLE_COMPROBANTE_VENTA", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalDetalleComprobanteVenta;
    @JoinColumn(name = "ID_COMPROBANTE_VENTA", referencedColumnName = "ID_COMPROBANTE_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private ComprobanteVenta idComprobanteVenta;

    public DetalleComprobanteVenta() {
    }

    public DetalleComprobanteVenta(Long idDetalleComprobanteVenta) {
        this.idDetalleComprobanteVenta = idDetalleComprobanteVenta;
    }

    public DetalleComprobanteVenta(Long idDetalleComprobanteVenta, String productoDetalleCompVenta, BigDecimal cantidadDetalleCompVenta, String descripcionDetalleCompVenta, BigDecimal precioUnitarioDetCompVenta, String tipoVentaDetalleCompVenta, BigDecimal totalDetalleComprobanteVenta) {
        this.idDetalleComprobanteVenta = idDetalleComprobanteVenta;
        this.productoDetalleCompVenta = productoDetalleCompVenta;
        this.cantidadDetalleCompVenta = cantidadDetalleCompVenta;
        this.descripcionDetalleCompVenta = descripcionDetalleCompVenta;
        this.precioUnitarioDetCompVenta = precioUnitarioDetCompVenta;
        this.tipoVentaDetalleCompVenta = tipoVentaDetalleCompVenta;
        this.totalDetalleComprobanteVenta = totalDetalleComprobanteVenta;
    }

    public Long getIdDetalleComprobanteVenta() {
        return idDetalleComprobanteVenta;
    }

    public void setIdDetalleComprobanteVenta(Long idDetalleComprobanteVenta) {
        this.idDetalleComprobanteVenta = idDetalleComprobanteVenta;
    }

    public String getProductoDetalleCompVenta() {
        return productoDetalleCompVenta;
    }

    public void setProductoDetalleCompVenta(String productoDetalleCompVenta) {
        this.productoDetalleCompVenta = productoDetalleCompVenta;
    }

    public BigDecimal getCantidadDetalleCompVenta() {
        return cantidadDetalleCompVenta;
    }

    public void setCantidadDetalleCompVenta(BigDecimal cantidadDetalleCompVenta) {
        this.cantidadDetalleCompVenta = cantidadDetalleCompVenta;
    }

    public String getDescripcionDetalleCompVenta() {
        return descripcionDetalleCompVenta;
    }

    public void setDescripcionDetalleCompVenta(String descripcionDetalleCompVenta) {
        this.descripcionDetalleCompVenta = descripcionDetalleCompVenta;
    }

    public BigDecimal getPrecioUnitarioDetCompVenta() {
        return precioUnitarioDetCompVenta;
    }

    public void setPrecioUnitarioDetCompVenta(BigDecimal precioUnitarioDetCompVenta) {
        this.precioUnitarioDetCompVenta = precioUnitarioDetCompVenta;
    }

    public String getTipoVentaDetalleCompVenta() {
        return tipoVentaDetalleCompVenta;
    }

    public void setTipoVentaDetalleCompVenta(String tipoVentaDetalleCompVenta) {
        this.tipoVentaDetalleCompVenta = tipoVentaDetalleCompVenta;
    }

    public BigDecimal getTotalDetalleComprobanteVenta() {
        return totalDetalleComprobanteVenta;
    }

    public void setTotalDetalleComprobanteVenta(BigDecimal totalDetalleComprobanteVenta) {
        this.totalDetalleComprobanteVenta = totalDetalleComprobanteVenta;
    }

    public ComprobanteVenta getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(ComprobanteVenta idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleComprobanteVenta != null ? idDetalleComprobanteVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleComprobanteVenta)) {
            return false;
        }
        DetalleComprobanteVenta other = (DetalleComprobanteVenta) object;
        if ((this.idDetalleComprobanteVenta == null && other.idDetalleComprobanteVenta != null) || (this.idDetalleComprobanteVenta != null && !this.idDetalleComprobanteVenta.equals(other.idDetalleComprobanteVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.DetalleComprobanteVenta[ idDetalleComprobanteVenta=" + idDetalleComprobanteVenta + " ]";
    }
    
}
