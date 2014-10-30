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
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR", nullable = false)
    private Long idProveedor;
    @Basic(optional = false)
    @Column(name = "FECHA_PROVEEDOR", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaProveedor;
    @Basic(optional = false)
    @Column(name = "USUARIO_PROVEEDOR", nullable = false, length = 30)
    private String usuarioProveedor;
    @OneToMany(mappedBy = "idProveedor", fetch = FetchType.LAZY)
    private Set<Compra> compraSet;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;

    public Proveedor() {
    }

    public Proveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Long idProveedor, Date fechaProveedor, String usuarioProveedor) {
        this.idProveedor = idProveedor;
        this.fechaProveedor = fechaProveedor;
        this.usuarioProveedor = usuarioProveedor;
    }

    public Long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Date getFechaProveedor() {
        return fechaProveedor;
    }

    public void setFechaProveedor(Date fechaProveedor) {
        this.fechaProveedor = fechaProveedor;
    }

    public String getUsuarioProveedor() {
        return usuarioProveedor;
    }

    public void setUsuarioProveedor(String usuarioProveedor) {
        this.usuarioProveedor = usuarioProveedor;
    }

    public Set<Compra> getCompraSet() {
        return compraSet;
    }

    public void setCompraSet(Set<Compra> compraSet) {
        this.compraSet = compraSet;
    }

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Proveedor[ idProveedor=" + idProveedor + " ]";
    }
    
}
