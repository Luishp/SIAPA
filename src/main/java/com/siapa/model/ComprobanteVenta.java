/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "comprobante_venta", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "ComprobanteVenta.findAll", query = "SELECT c FROM ComprobanteVenta c")})
public class ComprobanteVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_COMPROBANTE_VENTA", nullable = true)
    private Integer idComprobanteVenta;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE_COMP_VENTA", nullable = false, length = 50)
    private String nombreClienteCompVenta;
    @Basic(optional = false)
    @Column(name = "DIRECCION_COMPROBANTE_VENTA", nullable = false, length = 500)
    private String direccionComprobanteVenta;
    @Column(name = "TEL_COMPROBANTE_VENTA", length = 14)
    private String telComprobanteVenta;
    @Column(name = "NRC_COMPROBANTE_VENTA", length = 14)
    private String nrcComprobanteVenta;
    @Column(name = "NIT_COMPROBANTE_VENTA", length = 17)
    private String nitComprobanteVenta;
    @Column(name = "FECHA_HORA_COMPROBANTE_VENTA")
    @Temporal(TemporalType.DATE)
    private Date fechaHoraComprobanteVenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL_COMPROBANTE_VENTA", precision = 10, scale = 2)
    private BigDecimal totalComprobanteVenta;
    @Column(name = "TOTAL_LETRAS_COMPROBANTE_VENTA", length = 500)
    private String totalLetrasComprobanteVenta;
    @OneToMany(mappedBy = "idComprobanteVenta", fetch = FetchType.LAZY)
    private Set<DetalleComprobanteVenta> detalleComprobanteVentaSet;
    @OneToMany(mappedBy = "idComprobanteVenta", fetch = FetchType.LAZY)
    private Set<Venta> ventaSet;
    @JoinColumn(name = "ID_TIPO_COMPROBANTE", referencedColumnName = "ID_TIPO_COMPROBANTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoComprobante idTipoComprobante;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Venta idVenta;

    public ComprobanteVenta() {
    }

    public ComprobanteVenta(Integer idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public ComprobanteVenta(Integer idComprobanteVenta, String nombreClienteCompVenta, String direccionComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
        this.nombreClienteCompVenta = nombreClienteCompVenta;
        this.direccionComprobanteVenta = direccionComprobanteVenta;
    }

    public Integer getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(Integer idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public String getNombreClienteCompVenta() {
        return nombreClienteCompVenta;
    }

    public void setNombreClienteCompVenta(String nombreClienteCompVenta) {
        this.nombreClienteCompVenta = nombreClienteCompVenta;
    }

    public String getDireccionComprobanteVenta() {
        return direccionComprobanteVenta;
    }

    public void setDireccionComprobanteVenta(String direccionComprobanteVenta) {
        this.direccionComprobanteVenta = direccionComprobanteVenta;
    }

    public String getTelComprobanteVenta() {
        return telComprobanteVenta;
    }

    public void setTelComprobanteVenta(String telComprobanteVenta) {
        this.telComprobanteVenta = telComprobanteVenta;
    }

    public String getNrcComprobanteVenta() {
        return nrcComprobanteVenta;
    }

    public void setNrcComprobanteVenta(String nrcComprobanteVenta) {
        this.nrcComprobanteVenta = nrcComprobanteVenta;
    }

    public String getNitComprobanteVenta() {
        return nitComprobanteVenta;
    }

    public void setNitComprobanteVenta(String nitComprobanteVenta) {
        this.nitComprobanteVenta = nitComprobanteVenta;
    }

    public Date getFechaHoraComprobanteVenta() {
        return fechaHoraComprobanteVenta;
    }

    public void setFechaHoraComprobanteVenta(Date fechaHoraComprobanteVenta) {
        this.fechaHoraComprobanteVenta = fechaHoraComprobanteVenta;
    }

    public BigDecimal getTotalComprobanteVenta() {
        return totalComprobanteVenta;
    }

    public void setTotalComprobanteVenta(BigDecimal totalComprobanteVenta) {
        this.totalComprobanteVenta = totalComprobanteVenta;
    }

    public String getTotalLetrasComprobanteVenta() {
        return totalLetrasComprobanteVenta;
    }

    public void setTotalLetrasComprobanteVenta(String totalLetrasComprobanteVenta) {
        this.totalLetrasComprobanteVenta = totalLetrasComprobanteVenta;
    }

    public Set<DetalleComprobanteVenta> getDetalleComprobanteVentaSet() {
        return detalleComprobanteVentaSet;
    }

    public void setDetalleComprobanteVentaSet(Set<DetalleComprobanteVenta> detalleComprobanteVentaSet) {
        this.detalleComprobanteVentaSet = detalleComprobanteVentaSet;
    }

    public Set<Venta> getVentaSet() {
        return ventaSet;
    }

    public void setVentaSet(Set<Venta> ventaSet) {
        this.ventaSet = ventaSet;
    }

    public TipoComprobante getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(TipoComprobante idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
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
        hash += (idComprobanteVenta != null ? idComprobanteVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ComprobanteVenta)) {
            return false;
        }
        ComprobanteVenta other = (ComprobanteVenta) object;
        if ((this.idComprobanteVenta == null && other.idComprobanteVenta != null) || (this.idComprobanteVenta != null && !this.idComprobanteVenta.equals(other.idComprobanteVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.ComprobanteVenta[ idComprobanteVenta=" + idComprobanteVenta + " ]";
    }
}
