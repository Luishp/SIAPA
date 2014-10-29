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
@Table(name = "referenciafamiliar", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referenciafamiliar.findAll", query = "SELECT r FROM Referenciafamiliar r")})
public class Referenciafamiliar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "RF_ID", nullable = false)
    private Integer rfId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "RF_NOMBRECOMPLETO", nullable = false, length = 60)
    private String rfNombrecompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "RF_DIRECCION", nullable = false, length = 300)
    private String rfDireccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "RF_TELEFONO", nullable = false, length = 9)
    private String rfTelefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "RF_PARENTESCO", nullable = false, length = 50)
    private String rfParentesco;
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

    public Referenciafamiliar() {
    }

    public Referenciafamiliar(Integer rfId) {
        this.rfId = rfId;
    }

    public Referenciafamiliar(Integer rfId, String rfNombrecompleto, String rfDireccion, String rfTelefono, String rfParentesco, String usuarioRegistro, Date fechaRegistro) {
        this.rfId = rfId;
        this.rfNombrecompleto = rfNombrecompleto;
        this.rfDireccion = rfDireccion;
        this.rfTelefono = rfTelefono;
        this.rfParentesco = rfParentesco;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRfId() {
        return rfId;
    }

    public void setRfId(Integer rfId) {
        this.rfId = rfId;
    }

    public String getRfNombrecompleto() {
        return rfNombrecompleto;
    }

    public void setRfNombrecompleto(String rfNombrecompleto) {
        this.rfNombrecompleto = rfNombrecompleto;
    }

    public String getRfDireccion() {
        return rfDireccion;
    }

    public void setRfDireccion(String rfDireccion) {
        this.rfDireccion = rfDireccion;
    }

    public String getRfTelefono() {
        return rfTelefono;
    }

    public void setRfTelefono(String rfTelefono) {
        this.rfTelefono = rfTelefono;
    }

    public String getRfParentesco() {
        return rfParentesco;
    }

    public void setRfParentesco(String rfParentesco) {
        this.rfParentesco = rfParentesco;
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
        hash += (rfId != null ? rfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referenciafamiliar)) {
            return false;
        }
        Referenciafamiliar other = (Referenciafamiliar) object;
        if ((this.rfId == null && other.rfId != null) || (this.rfId != null && !this.rfId.equals(other.rfId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Referenciafamiliar[ rfId=" + rfId + " ]";
    }
    
}
