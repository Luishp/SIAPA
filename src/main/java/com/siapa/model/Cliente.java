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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE", nullable = true)
    private Integer idCliente;

    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE_COMP_VENTA", nullable = false, length = 50)
    private String nombreClienteCompVenta;

    @Column(name = "DIRECCION_CLIENTE", length = 500)
    private String direccionCliente;
    @Basic(optional = false)
    @Column(name = "TIPO_CLIENTE", nullable = false, length = 1)
    private String tipoCliente;
    @OneToMany(mappedBy = "idCliente", fetch = FetchType.LAZY)
    private Set<Venta> ventaSet;
    @JoinColumn(name = "ID_CATEGORIAS", referencedColumnName = "ID_CATEGORIAS")
    @ManyToOne(fetch = FetchType.LAZY)
    private Categorias idCategorias;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ID_PERSONA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Persona idPersona;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreClienteCompVenta, String tipoCliente) {
        this.idCliente = idCliente;
        this.nombreClienteCompVenta = nombreClienteCompVenta;
        this.tipoCliente = tipoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreClienteCompVenta() {
        return nombreClienteCompVenta;
    }

    public void setNombreClienteCompVenta(String nombreClienteCompVenta) {
        this.nombreClienteCompVenta = nombreClienteCompVenta;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Set<Venta> getVentaSet() {
        return ventaSet;
    }

    public void setVentaSet(Set<Venta> ventaSet) {
        this.ventaSet = ventaSet;
    }

    public Categorias getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Categorias idCategorias) {
        this.idCategorias = idCategorias;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Cliente[ idCliente=" + idCliente + " ]";
    }

}
