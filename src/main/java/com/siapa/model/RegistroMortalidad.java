/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "registro_mortalidad", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "RegistroMortalidad.findAll", query = "SELECT r FROM RegistroMortalidad r")})
public class RegistroMortalidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_REGISTRO_MORTALIDAD", nullable = false)
    private Long idRegistroMortalidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_REGISTRO_MORTALIDAD", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadRegistroMortalidad;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO_MORTALIDAD", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroMortalidad;
    @Basic(optional = false)
    @Column(name = "USUARIO_REGISTRO_MORTALIDAD", nullable = false, length = 30)
    private String usuarioRegistroMortalidad;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO_REG_MORTALIDAD", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngresoRegMortalidad;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;

    public RegistroMortalidad() {
    }

    public RegistroMortalidad(Long idRegistroMortalidad) {
        this.idRegistroMortalidad = idRegistroMortalidad;
    }

    public RegistroMortalidad(Long idRegistroMortalidad, BigDecimal cantidadRegistroMortalidad, Date fechaRegistroMortalidad, String usuarioRegistroMortalidad, Date fechaIngresoRegMortalidad) {
        this.idRegistroMortalidad = idRegistroMortalidad;
        this.cantidadRegistroMortalidad = cantidadRegistroMortalidad;
        this.fechaRegistroMortalidad = fechaRegistroMortalidad;
        this.usuarioRegistroMortalidad = usuarioRegistroMortalidad;
        this.fechaIngresoRegMortalidad = fechaIngresoRegMortalidad;
    }

    public Long getIdRegistroMortalidad() {
        return idRegistroMortalidad;
    }

    public void setIdRegistroMortalidad(Long idRegistroMortalidad) {
        this.idRegistroMortalidad = idRegistroMortalidad;
    }

    public BigDecimal getCantidadRegistroMortalidad() {
        return cantidadRegistroMortalidad;
    }

    public void setCantidadRegistroMortalidad(BigDecimal cantidadRegistroMortalidad) {
        this.cantidadRegistroMortalidad = cantidadRegistroMortalidad;
    }

    public Date getFechaRegistroMortalidad() {
        return fechaRegistroMortalidad;
    }

    public void setFechaRegistroMortalidad(Date fechaRegistroMortalidad) {
        this.fechaRegistroMortalidad = fechaRegistroMortalidad;
    }

    public String getUsuarioRegistroMortalidad() {
        return usuarioRegistroMortalidad;
    }

    public void setUsuarioRegistroMortalidad(String usuarioRegistroMortalidad) {
        this.usuarioRegistroMortalidad = usuarioRegistroMortalidad;
    }

    public Date getFechaIngresoRegMortalidad() {
        return fechaIngresoRegMortalidad;
    }

    public void setFechaIngresoRegMortalidad(Date fechaIngresoRegMortalidad) {
        this.fechaIngresoRegMortalidad = fechaIngresoRegMortalidad;
    }

    public Jaula getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(Jaula idJaula) {
        this.idJaula = idJaula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistroMortalidad != null ? idRegistroMortalidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroMortalidad)) {
            return false;
        }
        RegistroMortalidad other = (RegistroMortalidad) object;
        if ((this.idRegistroMortalidad == null && other.idRegistroMortalidad != null) || (this.idRegistroMortalidad != null && !this.idRegistroMortalidad.equals(other.idRegistroMortalidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.RegistroMortalidad[ idRegistroMortalidad=" + idRegistroMortalidad + " ]";
    }
    
}
