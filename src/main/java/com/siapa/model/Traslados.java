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
@Table(catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "Traslados.findAll", query = "SELECT t FROM Traslados t")})
public class Traslados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TRASLADOS", nullable = false)
    private Long idTraslados;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_TRASLADOS", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraTraslados;
    @Basic(optional = false)
    @Column(name = "USUARIO_TRASLADOS", nullable = false, length = 30)
    private String usuarioTraslados;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANTIDAD_TRASLADOS", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadTraslados;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;

    public Traslados() {
    }

    public Traslados(Long idTraslados) {
        this.idTraslados = idTraslados;
    }

    public Traslados(Long idTraslados, Date fechaHoraTraslados, String usuarioTraslados, BigDecimal cantidadTraslados) {
        this.idTraslados = idTraslados;
        this.fechaHoraTraslados = fechaHoraTraslados;
        this.usuarioTraslados = usuarioTraslados;
        this.cantidadTraslados = cantidadTraslados;
    }

    public Long getIdTraslados() {
        return idTraslados;
    }

    public void setIdTraslados(Long idTraslados) {
        this.idTraslados = idTraslados;
    }

    public Date getFechaHoraTraslados() {
        return fechaHoraTraslados;
    }

    public void setFechaHoraTraslados(Date fechaHoraTraslados) {
        this.fechaHoraTraslados = fechaHoraTraslados;
    }

    public String getUsuarioTraslados() {
        return usuarioTraslados;
    }

    public void setUsuarioTraslados(String usuarioTraslados) {
        this.usuarioTraslados = usuarioTraslados;
    }

    public BigDecimal getCantidadTraslados() {
        return cantidadTraslados;
    }

    public void setCantidadTraslados(BigDecimal cantidadTraslados) {
        this.cantidadTraslados = cantidadTraslados;
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
        hash += (idTraslados != null ? idTraslados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traslados)) {
            return false;
        }
        Traslados other = (Traslados) object;
        if ((this.idTraslados == null && other.idTraslados != null) || (this.idTraslados != null && !this.idTraslados.equals(other.idTraslados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Traslados[ idTraslados=" + idTraslados + " ]";
    }
    
}
