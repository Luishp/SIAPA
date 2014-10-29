/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "pagaduria", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagaduria.findAll", query = "SELECT p FROM Pagaduria p")})
public class Pagaduria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "PAGADURIA_ID", nullable = true)
    private Integer pagaduriaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PAGADURIA_NOMBRE", nullable = false, length = 100)
    private String pagaduriaNombre;
    @Size(max = 500)
    @Column(name = "PAGADURIA_DESCRIPCION", length = 500)
    private String pagaduriaDescripcion;
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
    @OneToMany(mappedBy = "pagaduriaId", fetch = FetchType.LAZY)
    private List<Desembolso> desembolsoList;

    public Pagaduria() {
    }

    public Pagaduria(Integer pagaduriaId) {
        this.pagaduriaId = pagaduriaId;
    }

    public Pagaduria(Integer pagaduriaId, String pagaduriaNombre, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.pagaduriaId = pagaduriaId;
        this.pagaduriaNombre = pagaduriaNombre;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPagaduriaId() {
        return pagaduriaId;
    }

    public void setPagaduriaId(Integer pagaduriaId) {
        this.pagaduriaId = pagaduriaId;
    }

    public String getPagaduriaNombre() {
        return pagaduriaNombre;
    }

    public void setPagaduriaNombre(String pagaduriaNombre) {
        this.pagaduriaNombre = pagaduriaNombre;
    }

    public String getPagaduriaDescripcion() {
        return pagaduriaDescripcion;
    }

    public void setPagaduriaDescripcion(String pagaduriaDescripcion) {
        this.pagaduriaDescripcion = pagaduriaDescripcion;
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
    public List<Desembolso> getDesembolsoList() {
        return desembolsoList;
    }

    public void setDesembolsoList(List<Desembolso> desembolsoList) {
        this.desembolsoList = desembolsoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagaduriaId != null ? pagaduriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagaduria)) {
            return false;
        }
        Pagaduria other = (Pagaduria) object;
        if ((this.pagaduriaId == null && other.pagaduriaId != null) || (this.pagaduriaId != null && !this.pagaduriaId.equals(other.pagaduriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Pagaduria[ pagaduriaId=" + pagaduriaId + " ]";
    }

}
