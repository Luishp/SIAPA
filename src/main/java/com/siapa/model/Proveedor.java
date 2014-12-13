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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Joao
 */
@Entity
@Table(catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")})
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR", nullable = false)
    private Integer idProveedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_PROVEEDOR", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USUARIO_PROVEEDOR", nullable = false, length = 30)
    private String usuarioProveedor;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne
    private Persona idPersona;
    @OneToMany(mappedBy = "idProveedor")
    private Set<Compra> compraSet;

    public Proveedor() {
    }

    public Proveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Proveedor(Integer idProveedor, Date fechaProveedor, String usuarioProveedor) {
        this.idProveedor = idProveedor;
        this.fechaProveedor = fechaProveedor;
        this.usuarioProveedor = usuarioProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
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

    public Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Set<Compra> getCompraSet() {
        return compraSet;
    }

    public void setCompraSet(Set<Compra> compraSet) {
        this.compraSet = compraSet;
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
        return "paq.Proveedor[ idProveedor=" + idProveedor + " ]";
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
