/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "referenciapersonal", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referenciapersonal.findAll", query = "SELECT r FROM Referenciapersonal r")})
public class Referenciapersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RP_ID", nullable = false)
    private Integer rpId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RP_NOMBRECOMPLETO", nullable = false, length = 60)
    private String rpNombrecompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "RP_DIRECCION", nullable = false, length = 300)
    private String rpDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "RP_TELEFONO", nullable = false, length = 9)
    private String rpTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RF_TIEMPOCONOCERLO", nullable = false, length = 20)
    private String rfTiempoconocerlo;
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
    @JoinColumn(name = "SOLICITUD_ID", referencedColumnName = "SOLICITUD_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Solicitud solicitudId;
    @JoinColumn(name = "RGC_ID", referencedColumnName = "RGC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Registrogarantiacodeudor rgcId;

    public Referenciapersonal() {
    }

    public Referenciapersonal(Integer rpId) {
        this.rpId = rpId;
    }

    public Referenciapersonal(Integer rpId, String rpNombrecompleto, String rpDireccion, String rpTelefono, String rfTiempoconocerlo, String usuarioRegistro, Date fechaRegistro) {
        this.rpId = rpId;
        this.rpNombrecompleto = rpNombrecompleto;
        this.rpDireccion = rpDireccion;
        this.rpTelefono = rpTelefono;
        this.rfTiempoconocerlo = rfTiempoconocerlo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRpId() {
        return rpId;
    }

    public void setRpId(Integer rpId) {
        this.rpId = rpId;
    }

    public String getRpNombrecompleto() {
        return rpNombrecompleto;
    }

    public void setRpNombrecompleto(String rpNombrecompleto) {
        this.rpNombrecompleto = rpNombrecompleto;
    }

    public String getRpDireccion() {
        return rpDireccion;
    }

    public void setRpDireccion(String rpDireccion) {
        this.rpDireccion = rpDireccion;
    }

    public String getRpTelefono() {
        return rpTelefono;
    }

    public void setRpTelefono(String rpTelefono) {
        this.rpTelefono = rpTelefono;
    }

    public String getRfTiempoconocerlo() {
        return rfTiempoconocerlo;
    }

    public void setRfTiempoconocerlo(String rfTiempoconocerlo) {
        this.rfTiempoconocerlo = rfTiempoconocerlo;
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

    public Solicitud getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Solicitud solicitudId) {
        this.solicitudId = solicitudId;
    }

    public Registrogarantiacodeudor getRgcId() {
        return rgcId;
    }

    public void setRgcId(Registrogarantiacodeudor rgcId) {
        this.rgcId = rgcId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rpId != null ? rpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referenciapersonal)) {
            return false;
        }
        Referenciapersonal other = (Referenciapersonal) object;
        if ((this.rpId == null && other.rpId != null) || (this.rpId != null && !this.rpId.equals(other.rpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Referenciapersonal[ rpId=" + rpId + " ]";
    }
    
}
