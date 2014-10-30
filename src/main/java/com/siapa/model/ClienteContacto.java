/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "cliente_contacto", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "ClienteContacto.findAll", query = "SELECT c FROM ClienteContacto c")})
public class ClienteContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClienteContactoPK clienteContactoPK;
    @Basic(optional = false)
    @Column(name = "VALOR_CLIENTE_CONTACTO", nullable = false, length = 100)
    private String valorClienteContacto;
    @Basic(optional = false)
    @Column(name = "ACTIVO_CLIENTE_CONTACTO", nullable = false)
    private boolean activoClienteContacto;
    @JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID_CONTACTO", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contacto contacto;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Persona persona;

    public ClienteContacto() {
    }

    public ClienteContacto(ClienteContactoPK clienteContactoPK) {
        this.clienteContactoPK = clienteContactoPK;
    }

    public ClienteContacto(ClienteContactoPK clienteContactoPK, String valorClienteContacto, boolean activoClienteContacto) {
        this.clienteContactoPK = clienteContactoPK;
        this.valorClienteContacto = valorClienteContacto;
        this.activoClienteContacto = activoClienteContacto;
    }

    public ClienteContacto(long idContacto, long idPersona) {
        this.clienteContactoPK = new ClienteContactoPK(idContacto, idPersona);
    }

    public ClienteContactoPK getClienteContactoPK() {
        return clienteContactoPK;
    }

    public void setClienteContactoPK(ClienteContactoPK clienteContactoPK) {
        this.clienteContactoPK = clienteContactoPK;
    }

    public String getValorClienteContacto() {
        return valorClienteContacto;
    }

    public void setValorClienteContacto(String valorClienteContacto) {
        this.valorClienteContacto = valorClienteContacto;
    }

    public boolean getActivoClienteContacto() {
        return activoClienteContacto;
    }

    public void setActivoClienteContacto(boolean activoClienteContacto) {
        this.activoClienteContacto = activoClienteContacto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteContactoPK != null ? clienteContactoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteContacto)) {
            return false;
        }
        ClienteContacto other = (ClienteContacto) object;
        if ((this.clienteContactoPK == null && other.clienteContactoPK != null) || (this.clienteContactoPK != null && !this.clienteContactoPK.equals(other.clienteContactoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.ClienteContacto[ clienteContactoPK=" + clienteContactoPK + " ]";
    }
    
}
