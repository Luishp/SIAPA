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
@Table(name = "consultaburocredito", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Consultaburocredito.findAll", query = "SELECT c FROM Consultaburocredito c")})
public class Consultaburocredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
//    @NotNull
    @Column(name = "CBC_ID", nullable = false)
    private Integer cbcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CBC_NOMBRE", nullable = false, length = 50)
    private String cbcNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CBD_CALIFICACION", nullable = false, length = 20)
    private String cbdCalificacion;
    @Size(max = 500)
    @Column(name = "CBC_COMENTARIO", length = 500)
    private String cbcComentario;
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
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisis analisisId;
    @JoinColumn(name = "AC_ID", referencedColumnName = "AC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Analisiscodeudor acId;

    public Consultaburocredito() {
    }

    public Consultaburocredito(Integer cbcId) {
        this.cbcId = cbcId;
    }

    public Consultaburocredito(Integer cbcId, String cbcNombre, String cbdCalificacion, String usuarioRegistro, Date fechaRegistro) {
        this.cbcId = cbcId;
        this.cbcNombre = cbcNombre;
        this.cbdCalificacion = cbdCalificacion;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCbcId() {
        return cbcId;
    }

    public void setCbcId(Integer cbcId) {
        this.cbcId = cbcId;
    }

    public String getCbcNombre() {
        return cbcNombre;
    }

    public void setCbcNombre(String cbcNombre) {
        this.cbcNombre = cbcNombre;
    }

    public String getCbdCalificacion() {
        return cbdCalificacion;
    }

    public void setCbdCalificacion(String cbdCalificacion) {
        this.cbdCalificacion = cbdCalificacion;
    }

    public String getCbcComentario() {
        return cbcComentario;
    }

    public void setCbcComentario(String cbcComentario) {
        this.cbcComentario = cbcComentario;
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

    public Analisis getAnalisisId() {
        return analisisId;
    }

    public void setAnalisisId(Analisis analisisId) {
        this.analisisId = analisisId;
    }

    public Analisiscodeudor getAcId() {
        return acId;
    }

    public void setAcId(Analisiscodeudor acId) {
        this.acId = acId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cbcId != null ? cbcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultaburocredito)) {
            return false;
        }
        Consultaburocredito other = (Consultaburocredito) object;
        if ((this.cbcId == null && other.cbcId != null) || (this.cbcId != null && !this.cbcId.equals(other.cbcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Consultaburocredito[ cbcId=" + cbcId + " ]";
    }
    
}
