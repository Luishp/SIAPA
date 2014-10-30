/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tipo_jaula", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoJaula.findAll", query = "SELECT t FROM TipoJaula t")})
public class TipoJaula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_JAULA", nullable = false)
    private Long idTipoJaula;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_JAULA", nullable = false, length = 50)
    private String nombreTipoJaula;
    @Column(name = "DESCRIPCION_TIPO_JAULA", length = 500)
    private String descripcionTipoJaula;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ANCHO_TIPO_JAULA", nullable = false, precision = 10, scale = 2)
    private BigDecimal anchoTipoJaula;
    @Basic(optional = false)
    @Column(name = "LARGO_TIPO_JAULA", nullable = false, precision = 10, scale = 2)
    private BigDecimal largoTipoJaula;
    @Basic(optional = false)
    @Column(name = "PROFUNDIDAD_TIPO_JAULA", nullable = false, precision = 10, scale = 2)
    private BigDecimal profundidadTipoJaula;
    @OneToMany(mappedBy = "idTipoJaula", fetch = FetchType.LAZY)
    private Set<Jaula> jaulaSet;

    public TipoJaula() {
    }

    public TipoJaula(Long idTipoJaula) {
        this.idTipoJaula = idTipoJaula;
    }

    public TipoJaula(Long idTipoJaula, String nombreTipoJaula, BigDecimal anchoTipoJaula, BigDecimal largoTipoJaula, BigDecimal profundidadTipoJaula) {
        this.idTipoJaula = idTipoJaula;
        this.nombreTipoJaula = nombreTipoJaula;
        this.anchoTipoJaula = anchoTipoJaula;
        this.largoTipoJaula = largoTipoJaula;
        this.profundidadTipoJaula = profundidadTipoJaula;
    }

    public Long getIdTipoJaula() {
        return idTipoJaula;
    }

    public void setIdTipoJaula(Long idTipoJaula) {
        this.idTipoJaula = idTipoJaula;
    }

    public String getNombreTipoJaula() {
        return nombreTipoJaula;
    }

    public void setNombreTipoJaula(String nombreTipoJaula) {
        this.nombreTipoJaula = nombreTipoJaula;
    }

    public String getDescripcionTipoJaula() {
        return descripcionTipoJaula;
    }

    public void setDescripcionTipoJaula(String descripcionTipoJaula) {
        this.descripcionTipoJaula = descripcionTipoJaula;
    }

    public BigDecimal getAnchoTipoJaula() {
        return anchoTipoJaula;
    }

    public void setAnchoTipoJaula(BigDecimal anchoTipoJaula) {
        this.anchoTipoJaula = anchoTipoJaula;
    }

    public BigDecimal getLargoTipoJaula() {
        return largoTipoJaula;
    }

    public void setLargoTipoJaula(BigDecimal largoTipoJaula) {
        this.largoTipoJaula = largoTipoJaula;
    }

    public BigDecimal getProfundidadTipoJaula() {
        return profundidadTipoJaula;
    }

    public void setProfundidadTipoJaula(BigDecimal profundidadTipoJaula) {
        this.profundidadTipoJaula = profundidadTipoJaula;
    }

    public Set<Jaula> getJaulaSet() {
        return jaulaSet;
    }

    public void setJaulaSet(Set<Jaula> jaulaSet) {
        this.jaulaSet = jaulaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoJaula != null ? idTipoJaula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoJaula)) {
            return false;
        }
        TipoJaula other = (TipoJaula) object;
        if ((this.idTipoJaula == null && other.idTipoJaula != null) || (this.idTipoJaula != null && !this.idTipoJaula.equals(other.idTipoJaula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.TipoJaula[ idTipoJaula=" + idTipoJaula + " ]";
    }
    
}
