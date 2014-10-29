/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "promocion", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promocion.findAll", query = "SELECT p FROM Promocion p")})
public class Promocion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "PROMOCION_ID", nullable = true)
    private Integer promocionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "PROMOCION_NOMBRE", nullable = false, length = 50)
    private String promocionNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMOCION_FECHAINICIO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date promocionFechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROMOCION_FECHAFINAL", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date promocionFechafinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "PROMOCION_DESCRIPCION", nullable = false, length = 500)
    private String promocionDescripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 15)
    private String usuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 15)
    @Column(name = "USUARIO_ULTIMAMODIFICACION", length = 15)
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @ManyToMany(mappedBy = "promocionList", fetch = FetchType.LAZY)
    private Set<Analisis> analisisList;
    @ManyToMany(mappedBy = "promocionList", fetch = FetchType.LAZY)
    private Set<Asesoria> asesoriaList;

    public Promocion() {
    }

    public Promocion(Integer promocionId) {
        this.promocionId = promocionId;
    }

    public Promocion(Integer promocionId, String promocionNombre, Date promocionFechainicio, Date promocionFechafinal, String promocionDescripcion, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.promocionId = promocionId;
        this.promocionNombre = promocionNombre;
        this.promocionFechainicio = promocionFechainicio;
        this.promocionFechafinal = promocionFechafinal;
        this.promocionDescripcion = promocionDescripcion;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Integer promocionId) {
        this.promocionId = promocionId;
    }

    public String getPromocionNombre() {
        return promocionNombre;
    }

    public void setPromocionNombre(String promocionNombre) {
        this.promocionNombre = promocionNombre;
    }

    public Date getPromocionFechainicio() {
        return promocionFechainicio;
    }

    public void setPromocionFechainicio(Date promocionFechainicio) {
        this.promocionFechainicio = promocionFechainicio;
    }

    public Date getPromocionFechafinal() {
        return promocionFechafinal;
    }

    public void setPromocionFechafinal(Date promocionFechafinal) {
        this.promocionFechafinal = promocionFechafinal;
    }

    public String getPromocionDescripcion() {
        return promocionDescripcion;
    }

    public void setPromocionDescripcion(String promocionDescripcion) {
        this.promocionDescripcion = promocionDescripcion;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioUltimamodificacion() {
        return usuarioUltimamodificacion;
    }

    public void setUsuarioUltimamodificacion(String usuarioUltimamodificacion) {
        this.usuarioUltimamodificacion = usuarioUltimamodificacion;
    }

    public Date getFechaUltimamodificacion() {
        return fechaUltimamodificacion;
    }

    public void setFechaUltimamodificacion(Date fechaUltimamodificacion) {
        this.fechaUltimamodificacion = fechaUltimamodificacion;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setAnalisisList(Set<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Asesoria> getAsesoriaList() {
        return asesoriaList;
    }

    public void setAsesoriaList(Set<Asesoria> asesoriaList) {
        this.asesoriaList = asesoriaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promocionId != null ? promocionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promocion)) {
            return false;
        }
        Promocion other = (Promocion) object;
        if ((this.promocionId == null && other.promocionId != null) || (this.promocionId != null && !this.promocionId.equals(other.promocionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Promocion[ promocionId=" + promocionId + " ]";
    }

}
