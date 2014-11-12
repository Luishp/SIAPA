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
    @NamedQuery(name = "Jaula.findAll", query = "SELECT j FROM Jaula j")})
public class Jaula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "ID_JAULA", nullable = true)
    private Integer idJaula;

    @Basic(optional = false)
    @Column(name = "NOMBRE_JAULA", nullable = false, length = 50)
    private String nombreJaula;
    @Column(name = "DESCRIPCION_JAULA", length = 500)
    private String descripcionJaula;
    @Column(name = "LISTA_VENTA_JAULA")
    private Boolean listaVentaJaula;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA_JAULA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVentaJaula;
    @Basic(optional = false)
    @Column(name = "FECHA_SIEMBRA_JAULA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaSiembraJaula;
    @Basic(optional = false)
    @Column(name = "VENTA_JAULA", nullable = false)
    private int ventaJaula;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<IngresoProducto> ingresoProductoSet;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<RegistroMortalidad> registroMortalidadSet;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<Muestreo> muestreoSet;
    @JoinColumn(name = "ID_TIPO_JAULA", referencedColumnName = "ID_TIPO_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private TipoJaula idTipoJaula;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<Traslados> trasladosSet;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<DetalleVenta> detalleVentaSet;
    @OneToMany(mappedBy = "idJaula", fetch = FetchType.LAZY)
    private Set<RegistroAlimentacion> registroAlimentacionSet;

    public Jaula() {
    }

    public Jaula(Integer idJaula) {
        this.idJaula = idJaula;
    }

    public Jaula(Integer idJaula, String nombreJaula, Date fechaVentaJaula, Date fechaSiembraJaula, int ventaJaula) {
        this.idJaula = idJaula;
        this.nombreJaula = nombreJaula;
        this.fechaVentaJaula = fechaVentaJaula;
        this.fechaSiembraJaula = fechaSiembraJaula;
        this.ventaJaula = ventaJaula;
    }

    public Integer getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(Integer idJaula) {
        this.idJaula = idJaula;
    }

    public String getNombreJaula() {
        return nombreJaula;
    }

    public void setNombreJaula(String nombreJaula) {
        this.nombreJaula = nombreJaula;
    }

    public String getDescripcionJaula() {
        return descripcionJaula;
    }

    public void setDescripcionJaula(String descripcionJaula) {
        this.descripcionJaula = descripcionJaula;
    }

    public Boolean getListaVentaJaula() {
        return listaVentaJaula;
    }

    public void setListaVentaJaula(Boolean listaVentaJaula) {
        this.listaVentaJaula = listaVentaJaula;
    }

    public Date getFechaVentaJaula() {
        return fechaVentaJaula;
    }

    public void setFechaVentaJaula(Date fechaVentaJaula) {
        this.fechaVentaJaula = fechaVentaJaula;
    }

    public Date getFechaSiembraJaula() {
        return fechaSiembraJaula;
    }

    public void setFechaSiembraJaula(Date fechaSiembraJaula) {
        this.fechaSiembraJaula = fechaSiembraJaula;
    }

    public int getVentaJaula() {
        return ventaJaula;
    }

    public void setVentaJaula(int ventaJaula) {
        this.ventaJaula = ventaJaula;
    }

    public Set<IngresoProducto> getIngresoProductoSet() {
        return ingresoProductoSet;
    }

    public void setIngresoProductoSet(Set<IngresoProducto> ingresoProductoSet) {
        this.ingresoProductoSet = ingresoProductoSet;
    }

    public Set<RegistroMortalidad> getRegistroMortalidadSet() {
        return registroMortalidadSet;
    }

    public void setRegistroMortalidadSet(Set<RegistroMortalidad> registroMortalidadSet) {
        this.registroMortalidadSet = registroMortalidadSet;
    }

    public Set<Muestreo> getMuestreoSet() {
        return muestreoSet;
    }

    public void setMuestreoSet(Set<Muestreo> muestreoSet) {
        this.muestreoSet = muestreoSet;
    }

    public TipoJaula getIdTipoJaula() {
        return idTipoJaula;
    }

    public void setIdTipoJaula(TipoJaula idTipoJaula) {
        this.idTipoJaula = idTipoJaula;
    }

    public Set<Traslados> getTrasladosSet() {
        return trasladosSet;
    }

    public void setTrasladosSet(Set<Traslados> trasladosSet) {
        this.trasladosSet = trasladosSet;
    }

    public Set<DetalleVenta> getDetalleVentaSet() {
        return detalleVentaSet;
    }

    public void setDetalleVentaSet(Set<DetalleVenta> detalleVentaSet) {
        this.detalleVentaSet = detalleVentaSet;
    }

    public Set<RegistroAlimentacion> getRegistroAlimentacionSet() {
        return registroAlimentacionSet;
    }

    public void setRegistroAlimentacionSet(Set<RegistroAlimentacion> registroAlimentacionSet) {
        this.registroAlimentacionSet = registroAlimentacionSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJaula != null ? idJaula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jaula)) {
            return false;
        }
        Jaula other = (Jaula) object;
        if ((this.idJaula == null && other.idJaula != null) || (this.idJaula != null && !this.idJaula.equals(other.idJaula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Jaula[ idJaula=" + idJaula + " ]";
    }

}
