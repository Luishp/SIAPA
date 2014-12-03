/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
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
@Table(catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
   
   
    @Id
    @GeneratedValue
    @Column(name = "ID_VENTA", nullable = true)
    private Integer idVenta;
   
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_VENTA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraVenta;
    @Basic(optional = false)
    @Column(name = "USUARIO_VENTA", nullable = false, length = 30)
    private String usuarioVenta;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente idCliente;
    @JoinColumn(name = "ID_COMPROBANTE_VENTA", referencedColumnName = "ID_COMPROBANTE_VENTA")
    @ManyToOne(fetch = FetchType.LAZY)
    private ComprobanteVenta idComprobanteVenta;
    @OneToMany(mappedBy = "idVenta", fetch = FetchType.LAZY)
    private Set<DetalleVenta> detalleVentaSet;
    @OneToMany(mappedBy = "idVenta", fetch = FetchType.LAZY)
    private Set<ComprobanteVenta> comprobanteVentaSet;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, Date fechaHoraVenta, String usuarioVenta) {
        this.idVenta = idVenta;
        this.fechaHoraVenta = fechaHoraVenta;
        this.usuarioVenta = usuarioVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaHoraVenta() {
        return fechaHoraVenta;
    }

    public void setFechaHoraVenta(Date fechaHoraVenta) {
        this.fechaHoraVenta = fechaHoraVenta;
    }

    public String getUsuarioVenta() {
        return usuarioVenta;
    }

    public void setUsuarioVenta(String usuarioVenta) {
        this.usuarioVenta = usuarioVenta;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public ComprobanteVenta getIdComprobanteVenta() {
        return idComprobanteVenta;
    }

    public void setIdComprobanteVenta(ComprobanteVenta idComprobanteVenta) {
        this.idComprobanteVenta = idComprobanteVenta;
    }

    public Set<DetalleVenta> getDetalleVentaSet() {
        return detalleVentaSet;
    }

    public void setDetalleVentaSet(Set<DetalleVenta> detalleVentaSet) {
        this.detalleVentaSet = detalleVentaSet;
    }

    public Set<ComprobanteVenta> getComprobanteVentaSet() {
        return comprobanteVentaSet;
    }

    public void setComprobanteVentaSet(Set<ComprobanteVenta> comprobanteVentaSet) {
        this.comprobanteVentaSet = comprobanteVentaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Venta[ idVenta=" + idVenta + " ]";
    }
}
