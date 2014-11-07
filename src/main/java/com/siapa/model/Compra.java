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
@Table(catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    
     @Id
    @GeneratedValue
    @Column(name = "ID_COMPRA", nullable = true)
    private Integer idCompra;
     
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_COMPRA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraCompra;
    @Basic(optional = false)
    @Column(name = "USUARIO_COMPRA", nullable = false, length = 30)
    private String usuarioCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TOTAL_COMPRA", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCompra;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proveedor idProveedor;
    @OneToMany(mappedBy = "idCompra", fetch = FetchType.LAZY)
    private Set<DetalleCompraAlimento> detalleCompraAlimentoSet;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, Date fechaHoraCompra, String usuarioCompra, BigDecimal totalCompra) {
        this.idCompra = idCompra;
        this.fechaHoraCompra = fechaHoraCompra;
        this.usuarioCompra = usuarioCompra;
        this.totalCompra = totalCompra;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFechaHoraCompra() {
        return fechaHoraCompra;
    }

    public void setFechaHoraCompra(Date fechaHoraCompra) {
        this.fechaHoraCompra = fechaHoraCompra;
    }

    public String getUsuarioCompra() {
        return usuarioCompra;
    }

    public void setUsuarioCompra(String usuarioCompra) {
        this.usuarioCompra = usuarioCompra;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Set<DetalleCompraAlimento> getDetalleCompraAlimentoSet() {
        return detalleCompraAlimentoSet;
    }

    public void setDetalleCompraAlimentoSet(Set<DetalleCompraAlimento> detalleCompraAlimentoSet) {
        this.detalleCompraAlimentoSet = detalleCompraAlimentoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Compra[ idCompra=" + idCompra + " ]";
    }
    
}
