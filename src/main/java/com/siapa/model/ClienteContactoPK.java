/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Angel
 */
@Embeddable
public class ClienteContactoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_CONTACTO", nullable = false)
    private long idContacto;
    @Basic(optional = false)
    @Column(name = "ID_PERSONA", nullable = false)
    private long idPersona;

    public ClienteContactoPK() {
    }

    public ClienteContactoPK(long idContacto, long idPersona) {
        this.idContacto = idContacto;
        this.idPersona = idPersona;
    }

    public long getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(long idContacto) {
        this.idContacto = idContacto;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idContacto;
        hash += (int) idPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClienteContactoPK)) {
            return false;
        }
        ClienteContactoPK other = (ClienteContactoPK) object;
        if (this.idContacto != other.idContacto) {
            return false;
        }
        if (this.idPersona != other.idPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.ClienteContactoPK[ idContacto=" + idContacto + ", idPersona=" + idPersona + " ]";
    }
    
}
