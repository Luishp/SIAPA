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
@Table(name = "registro_alimentacion", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "RegistroAlimentacion.findAll", query = "SELECT r FROM RegistroAlimentacion r")})
public class RegistroAlimentacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_REGISTRO_ALIMENTACION", nullable = false)
    private Long idRegistroAlimentacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_REGISTRO_ALIMENTACION", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadRegistroAlimentacion;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_REG_ALIMENTACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraRegAlimentacion;
    @Basic(optional = false)
    @Column(name = "USUARIO_REGISTRO_ALIMENTACION", nullable = false, length = 30)
    private String usuarioRegistroAlimentacion;
    @JoinColumn(name = "ID_ALIMENTO", referencedColumnName = "ID_ALIMENTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Alimento idAlimento;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;

    public RegistroAlimentacion() {
    }

    public RegistroAlimentacion(Long idRegistroAlimentacion) {
        this.idRegistroAlimentacion = idRegistroAlimentacion;
    }

    public RegistroAlimentacion(Long idRegistroAlimentacion, BigDecimal cantidadRegistroAlimentacion, Date fechaHoraRegAlimentacion, String usuarioRegistroAlimentacion) {
        this.idRegistroAlimentacion = idRegistroAlimentacion;
        this.cantidadRegistroAlimentacion = cantidadRegistroAlimentacion;
        this.fechaHoraRegAlimentacion = fechaHoraRegAlimentacion;
        this.usuarioRegistroAlimentacion = usuarioRegistroAlimentacion;
    }

    public Long getIdRegistroAlimentacion() {
        return idRegistroAlimentacion;
    }

    public void setIdRegistroAlimentacion(Long idRegistroAlimentacion) {
        this.idRegistroAlimentacion = idRegistroAlimentacion;
    }

    public BigDecimal getCantidadRegistroAlimentacion() {
        return cantidadRegistroAlimentacion;
    }

    public void setCantidadRegistroAlimentacion(BigDecimal cantidadRegistroAlimentacion) {
        this.cantidadRegistroAlimentacion = cantidadRegistroAlimentacion;
    }

    public Date getFechaHoraRegAlimentacion() {
        return fechaHoraRegAlimentacion;
    }

    public void setFechaHoraRegAlimentacion(Date fechaHoraRegAlimentacion) {
        this.fechaHoraRegAlimentacion = fechaHoraRegAlimentacion;
    }

    public String getUsuarioRegistroAlimentacion() {
        return usuarioRegistroAlimentacion;
    }

    public void setUsuarioRegistroAlimentacion(String usuarioRegistroAlimentacion) {
        this.usuarioRegistroAlimentacion = usuarioRegistroAlimentacion;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
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
        hash += (idRegistroAlimentacion != null ? idRegistroAlimentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroAlimentacion)) {
            return false;
        }
        RegistroAlimentacion other = (RegistroAlimentacion) object;
        if ((this.idRegistroAlimentacion == null && other.idRegistroAlimentacion != null) || (this.idRegistroAlimentacion != null && !this.idRegistroAlimentacion.equals(other.idRegistroAlimentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.RegistroAlimentacion[ idRegistroAlimentacion=" + idRegistroAlimentacion + " ]";
    }
    
}
