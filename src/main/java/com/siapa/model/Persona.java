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
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PERSONA", nullable = false)
    private Long idPersona;
    @Basic(optional = false)
    @Column(name = "NOMBRE_PERSONA", nullable = false, length = 50)
    private String nombrePersona;
    @Column(name = "DIRECCION_PERSONA", length = 500)
    private String direccionPersona;
    @Column(name = "NRC_PERSONA", length = 14)
    private String nrcPersona;
    @Column(name = "NIT_PERSONA", length = 17)
    private String nitPersona;
    @Column(name = "DUI_PERSONA", length = 14)
    private String duiPersona;
    @Basic(optional = false)
    @Column(name = "TIPO_PERSONA", nullable = false, length = 1)
    private String tipoPersona;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private Set<ClienteContacto> clienteContactoSet;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Set<Cliente> clienteSet;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.LAZY)
    private Set<Proveedor> proveedorSet;

    public Persona() {
    }

    public Persona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(Long idPersona, String nombrePersona, String tipoPersona) {
        this.idPersona = idPersona;
        this.nombrePersona = nombrePersona;
        this.tipoPersona = tipoPersona;
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getDireccionPersona() {
        return direccionPersona;
    }

    public void setDireccionPersona(String direccionPersona) {
        this.direccionPersona = direccionPersona;
    }

    public String getNrcPersona() {
        return nrcPersona;
    }

    public void setNrcPersona(String nrcPersona) {
        this.nrcPersona = nrcPersona;
    }

    public String getNitPersona() {
        return nitPersona;
    }

    public void setNitPersona(String nitPersona) {
        this.nitPersona = nitPersona;
    }

    public String getDuiPersona() {
        return duiPersona;
    }

    public void setDuiPersona(String duiPersona) {
        this.duiPersona = duiPersona;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Set<ClienteContacto> getClienteContactoSet() {
        return clienteContactoSet;
    }

    public void setClienteContactoSet(Set<ClienteContacto> clienteContactoSet) {
        this.clienteContactoSet = clienteContactoSet;
    }

    public Set<Cliente> getClienteSet() {
        return clienteSet;
    }

    public void setClienteSet(Set<Cliente> clienteSet) {
        this.clienteSet = clienteSet;
    }

    public Set<Proveedor> getProveedorSet() {
        return proveedorSet;
    }

    public void setProveedorSet(Set<Proveedor> proveedorSet) {
        this.proveedorSet = proveedorSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Persona[ idPersona=" + idPersona + " ]";
    }
    
}
