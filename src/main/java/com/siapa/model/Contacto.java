/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")})
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONTACTO", nullable = false)
    private Long idContacto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CONTACTO", nullable = false, length = 50)
    private String nombreContacto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_CONTACTO", nullable = false, length = 500)
    private String descripcionContacto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto", fetch = FetchType.LAZY)
    private Set<ClienteContacto> clienteContactoSet;

    public Contacto() {
    }

    public Contacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public Contacto(Long idContacto, String nombreContacto, String descripcionContacto) {
        this.idContacto = idContacto;
        this.nombreContacto = nombreContacto;
        this.descripcionContacto = descripcionContacto;
    }

    public Long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Long idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getDescripcionContacto() {
        return descripcionContacto;
    }

    public void setDescripcionContacto(String descripcionContacto) {
        this.descripcionContacto = descripcionContacto;
    }

    public Set<ClienteContacto> getClienteContactoSet() {
        return clienteContactoSet;
    }

    public void setClienteContactoSet(Set<ClienteContacto> clienteContactoSet) {
        this.clienteContactoSet = clienteContactoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContacto != null ? idContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idContacto == null && other.idContacto != null) || (this.idContacto != null && !this.idContacto.equals(other.idContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Contacto[ idContacto=" + idContacto + " ]";
    }
    
}
