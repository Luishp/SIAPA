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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "agendacomitecreditos", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendacomitecreditos.findAll", query = "SELECT a FROM Agendacomitecreditos a")})
public class Agendacomitecreditos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ACC_ID", nullable = true)
    private Integer accId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_FECHAREUNION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date accFechareunion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACC_HORAREUNION", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date accHorareunion;
    @Size(max = 100)
    @Column(name = "ACC_LUGARREUNION", length = 100)
    private String accLugarreunion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String activo;
    @Column(name = "REALIZADA")
    private Boolean realizada;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendacomitecreditos", fetch = FetchType.LAZY)
    private Set<Asistente> asistenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendacomitecreditos", fetch = FetchType.LAZY)
    private Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList;
    private transient Integer esperados;
    private transient Integer permisos;
    private transient Integer asistencia;
    private transient Integer solicitudes;

    public Agendacomitecreditos() {
    }

    public Agendacomitecreditos(Integer accId) {
        this.accId = accId;
    }

    public Agendacomitecreditos(Integer accId, Date accFechareunion, Date accHorareunion, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.accId = accId;
        this.accFechareunion = accFechareunion;
        this.accHorareunion = accHorareunion;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getAccId() {
        return accId;
    }

    public void setAccId(Integer accId) {
        this.accId = accId;
    }

    public Date getAccFechareunion() {
        return accFechareunion;
    }

    public void setAccFechareunion(Date accFechareunion) {
        this.accFechareunion = accFechareunion;
    }

    public Date getAccHorareunion() {
        return accHorareunion;
    }

    public void setAccHorareunion(Date accHorareunion) {
        this.accHorareunion = accHorareunion;
    }

    public String getAccLugarreunion() {
        return accLugarreunion;
    }

    public void setAccLugarreunion(String accLugarreunion) {
        this.accLugarreunion = accLugarreunion;
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

    public Boolean getRealizada() {
        return realizada;
    }

    public void setRealizada(Boolean realizada) {
        this.realizada = realizada;
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
    public Set<Asistente> getAsistenteList() {
        return asistenteList;
    }

    public void setAsistenteList(Set<Asistente> asistenteList) {
        this.asistenteList = asistenteList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Analisisenagendacomitecreditos> getAnalisisenagendacomitecreditosList() {
        return analisisenagendacomitecreditosList;
    }

    public void setAnalisisenagendacomitecreditosList(Set<Analisisenagendacomitecreditos> analisisenagendacomitecreditosList) {
        this.analisisenagendacomitecreditosList = analisisenagendacomitecreditosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accId != null ? accId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendacomitecreditos)) {
            return false;
        }
        Agendacomitecreditos other = (Agendacomitecreditos) object;
        if ((this.accId == null && other.accId != null) || (this.accId != null && !this.accId.equals(other.accId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Agendacomitecreditos[ accId=" + accId + " ]";
    }

    public Integer getEsperados() {
        return esperados;
    }

    public void setEsperados(Integer esperados) {
        this.esperados = esperados;
    }

    public Integer getPermisos() {
        return permisos;
    }

    public void setPermisos(Integer permisos) {
        this.permisos = permisos;
    }

    public Integer getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Integer asistencia) {
        this.asistencia = asistencia;
    }

    public Integer getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Integer solicitudes) {
        this.solicitudes = solicitudes;
    }

}
