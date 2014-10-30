/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
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
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")})
public class Categorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CATEGORIAS", nullable = false)
    private Long idCategorias;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CATEGORIAS", nullable = false, length = 50)
    private String nombreCategorias;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_CATEGORIAS", nullable = false, length = 500)
    private String descripcionCategorias;
    @OneToMany(mappedBy = "idCategorias", fetch = FetchType.LAZY)
    private Set<Descuento> descuentoSet;
    @OneToMany(mappedBy = "idCategorias", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;

    public Categorias() {
    }

    public Categorias(Long idCategorias) {
        this.idCategorias = idCategorias;
    }

    public Categorias(Long idCategorias, String nombreCategorias, String descripcionCategorias) {
        this.idCategorias = idCategorias;
        this.nombreCategorias = nombreCategorias;
        this.descripcionCategorias = descripcionCategorias;
    }

    public Long getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Long idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNombreCategorias() {
        return nombreCategorias;
    }

    public void setNombreCategorias(String nombreCategorias) {
        this.nombreCategorias = nombreCategorias;
    }

    public String getDescripcionCategorias() {
        return descripcionCategorias;
    }

    public void setDescripcionCategorias(String descripcionCategorias) {
        this.descripcionCategorias = descripcionCategorias;
    }

    public Set<Descuento> getDescuentoSet() {
        return descuentoSet;
    }

    public void setDescuentoSet(Set<Descuento> descuentoSet) {
        this.descuentoSet = descuentoSet;
    }

    public Set<Cliente> getClienteSet() {
        return clienteSet;
    }

    public void setClienteSet(Set<Cliente> clienteSet) {
        this.clienteSet = clienteSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCategorias != null ? idCategorias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.idCategorias == null && other.idCategorias != null) || (this.idCategorias != null && !this.idCategorias.equals(other.idCategorias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Categorias[ idCategorias=" + idCategorias + " ]";
    }
    
}
