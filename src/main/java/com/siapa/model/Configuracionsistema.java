package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Entity
@Table(name = "configuracionsistema", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuracionsistema.findAll", query = "SELECT cs FROM Configuracionsistema cs")})
public class Configuracionsistema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "CONFIGURACIONSISTEMAID", nullable = true)
    private Integer configuracionSistemaId;
    @Size(max = 45)
    @Column(name = "CONFIGURACIONSISTEMANOMBRE", length = 45)
    private String configuracionSistemaNombre;
    @Size(max = 45)
    @Column(name = "CONFIGURACIONSISTEMAVALOR", length = 45)
    private String configuracionSistemaValor;
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

    public Configuracionsistema() {
    }

    public Configuracionsistema(Integer configuracionSistemaId) {
        this.configuracionSistemaId = configuracionSistemaId;
    }

    public Configuracionsistema(Integer configuracionSistemaId, String usuarioRegistro, Date fechaRegistro) {
        this.configuracionSistemaId = configuracionSistemaId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }


    public Integer getConfiguracionSistemaId() {
        return configuracionSistemaId;
    }

    public void setConfiguracionSistemaId(Integer configuracionSistemaId) {
        this.configuracionSistemaId = configuracionSistemaId;
    }

    public String getConfiguracionSistemaNombre() {
        return configuracionSistemaNombre;
    }

    public void setConfiguracionSistemaNombre(String configuracionSistemaNombre) {
        this.configuracionSistemaNombre = configuracionSistemaNombre;
    }

    public String getConfiguracionSistemaValor() {
        return configuracionSistemaValor;
    }

    public void setConfiguracionSistemaValor(String configuracionSistemaValor) {
        this.configuracionSistemaValor = configuracionSistemaValor;
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
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionSistemaId != null ? configuracionSistemaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuracionsistema)) {
            return false;
        }
        Configuracionsistema other = (Configuracionsistema) object;
        if ((this.configuracionSistemaId == null && other.configuracionSistemaId != null) || (this.configuracionSistemaId != null && !this.configuracionSistemaId.equals(other.configuracionSistemaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Configuracionsistema[ configuracionSistemaId=" + configuracionSistemaId + " ]";
    }
}