/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "Muestreo.findAll", query = "SELECT m FROM Muestreo m")})
public class Muestreo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MUESTREO", nullable = false)
    private Long idMuestreo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PESO_PROMEDIO_MUESTREO", nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoPromedioMuestreo;
    @Basic(optional = false)
    @Column(name = "FECHA_MUESTREO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMuestreo;
    @Basic(optional = false)
    @Column(name = "USUARIO_MUESTREO", nullable = false, length = 30)
    private String usuarioMuestreo;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO_MUESTREO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistroMuestreo;
    @JoinColumn(name = "ID_JAULA", referencedColumnName = "ID_JAULA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Jaula idJaula;
    @OneToMany(mappedBy = "idMuestreo", fetch = FetchType.LAZY)
    private Set<DetalleMuestreo> detalleMuestreoSet;

    public Muestreo() {
    }

    public Muestreo(Long idMuestreo) {
        this.idMuestreo = idMuestreo;
    }

    public Muestreo(Long idMuestreo, BigDecimal pesoPromedioMuestreo, Date fechaMuestreo, String usuarioMuestreo, Date fechaRegistroMuestreo) {
        this.idMuestreo = idMuestreo;
        this.pesoPromedioMuestreo = pesoPromedioMuestreo;
        this.fechaMuestreo = fechaMuestreo;
        this.usuarioMuestreo = usuarioMuestreo;
        this.fechaRegistroMuestreo = fechaRegistroMuestreo;
    }

    public Long getIdMuestreo() {
        return idMuestreo;
    }

    public void setIdMuestreo(Long idMuestreo) {
        this.idMuestreo = idMuestreo;
    }

    public BigDecimal getPesoPromedioMuestreo() {
        return pesoPromedioMuestreo;
    }

    public void setPesoPromedioMuestreo(BigDecimal pesoPromedioMuestreo) {
        this.pesoPromedioMuestreo = pesoPromedioMuestreo;
    }

    public Date getFechaMuestreo() {
        return fechaMuestreo;
    }

    public void setFechaMuestreo(Date fechaMuestreo) {
        this.fechaMuestreo = fechaMuestreo;
    }

    public String getUsuarioMuestreo() {
        return usuarioMuestreo;
    }

    public void setUsuarioMuestreo(String usuarioMuestreo) {
        this.usuarioMuestreo = usuarioMuestreo;
    }

    public Date getFechaRegistroMuestreo() {
        return fechaRegistroMuestreo;
    }

    public void setFechaRegistroMuestreo(Date fechaRegistroMuestreo) {
        this.fechaRegistroMuestreo = fechaRegistroMuestreo;
    }

    public Jaula getIdJaula() {
        return idJaula;
    }

    public void setIdJaula(Jaula idJaula) {
        this.idJaula = idJaula;
    }

    public Set<DetalleMuestreo> getDetalleMuestreoSet() {
        return detalleMuestreoSet;
    }

    public void setDetalleMuestreoSet(Set<DetalleMuestreo> detalleMuestreoSet) {
        this.detalleMuestreoSet = detalleMuestreoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMuestreo != null ? idMuestreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Muestreo)) {
            return false;
        }
        Muestreo other = (Muestreo) object;
        if ((this.idMuestreo == null && other.idMuestreo != null) || (this.idMuestreo != null && !this.idMuestreo.equals(other.idMuestreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.Muestreo[ idMuestreo=" + idMuestreo + " ]";
    }
    
}
