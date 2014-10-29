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
@Table(name = "codeudor", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codeudor.findAll", query = "SELECT c FROM Codeudor c")})
public class Codeudor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "CODEUDOR_ID", nullable = true)
    private Integer codeudorId;
    @Size(max = 40)
    @Column(name = "CODEUDOR_CODIGOASOCIADO")
    private String codeudorCodigoasociado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODEUDOR_NOMBRE1", nullable = false, length = 20)
    private String codeudorNombre1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODEUDOR_NOMBRE2", nullable = false, length = 20)
    private String codeudorNombre2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODEUDOR_APELLIDO1", nullable = false, length = 20)
    private String codeudorApellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODEUDOR_APELLIDO2", nullable = false, length = 20)
    private String codeudorApellido2;
    @Size(max = 20)
    @Column(name = "CODEUDOR_APELLIDOCASADA", length = 20)
    private String codeudorApellidocasada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODEUDOR_DUI", nullable = false, length = 10)
    private String codeudorDui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CODEUDOR_DUILUGAR", nullable = false, length = 150)
    private String codeudorDuilugar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEUDOR_DUIFECHAEXP", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date codeudorDuifechaexp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "CODEUDOR_NIT", nullable = false, length = 17)
    private String codeudorNit;
    @Size(max = 10)
    @Column(name = "CODEUDOR_ISSS", length = 10)
    private String codeudorIsss;
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
    @OneToMany(mappedBy = "codeudorId", fetch = FetchType.LAZY)
    private List<Registrogarantiacodeudor> registrogarantiacodeudorList;

    public Codeudor() {
    }

    public Codeudor(Integer codeudorId) {
        this.codeudorId = codeudorId;
    }

    public Codeudor(Integer codeudorId, String codeudorNombre1, String codeudorNombre2, String codeudorApellido1, String codeudorApellido2, String codeudorDui, String codeudorDuilugar, Date codeudorDuifechaexp, String codeudorNit, String usuarioRegistro, Date fechaRegistro) {
        this.codeudorId = codeudorId;
        this.codeudorNombre1 = codeudorNombre1;
        this.codeudorNombre2 = codeudorNombre2;
        this.codeudorApellido1 = codeudorApellido1;
        this.codeudorApellido2 = codeudorApellido2;
        this.codeudorDui = codeudorDui;
        this.codeudorDuilugar = codeudorDuilugar;
        this.codeudorDuifechaexp = codeudorDuifechaexp;
        this.codeudorNit = codeudorNit;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCodeudorId() {
        return codeudorId;
    }

    public void setCodeudorId(Integer codeudorId) {
        this.codeudorId = codeudorId;
    }

    public String getCodeudorCodigoasociado() {
        return codeudorCodigoasociado;
    }

    public void setCodeudorCodigoasociado(String codeudorCodigoasociado) {
        this.codeudorCodigoasociado = codeudorCodigoasociado;
    }

    public String getCodeudorNombre1() {
        return codeudorNombre1;
    }

    public void setCodeudorNombre1(String codeudorNombre1) {
        this.codeudorNombre1 = codeudorNombre1;
    }

    public String getCodeudorNombre2() {
        return codeudorNombre2;
    }

    public void setCodeudorNombre2(String codeudorNombre2) {
        this.codeudorNombre2 = codeudorNombre2;
    }

    public String getCodeudorApellido1() {
        return codeudorApellido1;
    }

    public void setCodeudorApellido1(String codeudorApellido1) {
        this.codeudorApellido1 = codeudorApellido1;
    }

    public String getCodeudorApellido2() {
        return codeudorApellido2;
    }

    public void setCodeudorApellido2(String codeudorApellido2) {
        this.codeudorApellido2 = codeudorApellido2;
    }

    public String getCodeudorApellidocasada() {
        return codeudorApellidocasada;
    }

    public void setCodeudorApellidocasada(String codeudorApellidocasada) {
        this.codeudorApellidocasada = codeudorApellidocasada;
    }

    public String getCodeudorDui() {
        return codeudorDui;
    }

    public void setCodeudorDui(String codeudorDui) {
        this.codeudorDui = codeudorDui;
    }

    public String getCodeudorDuilugar() {
        return codeudorDuilugar;
    }

    public void setCodeudorDuilugar(String codeudorDuilugar) {
        this.codeudorDuilugar = codeudorDuilugar;
    }

    public Date getCodeudorDuifechaexp() {
        return codeudorDuifechaexp;
    }

    public void setCodeudorDuifechaexp(Date codeudorDuifechaexp) {
        this.codeudorDuifechaexp = codeudorDuifechaexp;
    }

    public String getCodeudorNit() {
        return codeudorNit;
    }

    public void setCodeudorNit(String codeudorNit) {
        this.codeudorNit = codeudorNit;
    }

    public String getCodeudorIsss() {
        return codeudorIsss;
    }

    public void setCodeudorIsss(String codeudorIsss) {
        this.codeudorIsss = codeudorIsss;
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

    public String getNombreCompleto() {
        String nombreCompleto = "";

        if (codeudorNombre1 != null && !codeudorNombre1.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + codeudorNombre1 + " ";
        }

        if (codeudorNombre2 != null && !codeudorNombre2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + codeudorNombre2;
        }

        if (codeudorApellido1 != null && !codeudorApellido1.trim().equalsIgnoreCase("")) {

            if (nombreCompleto != null && !nombreCompleto.trim().equalsIgnoreCase("")) {
                nombreCompleto = nombreCompleto + ", ";
            }
            nombreCompleto = nombreCompleto + codeudorApellido1 + " ";
        }

        if (codeudorApellido2 != null && !codeudorApellido2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + codeudorApellido2;
        }

        return nombreCompleto;
    }
    
    
    
    @XmlTransient
    @JsonIgnore
    public List<Registrogarantiacodeudor> getRegistrogarantiacodeudorList() {
        return registrogarantiacodeudorList;
    }

    public void setRegistrogarantiacodeudorList(List<Registrogarantiacodeudor> registrogarantiacodeudorList) {
        this.registrogarantiacodeudorList = registrogarantiacodeudorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeudorId != null ? codeudorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codeudor)) {
            return false;
        }
        Codeudor other = (Codeudor) object;
        if ((this.codeudorId == null && other.codeudorId != null) || (this.codeudorId != null && !this.codeudorId.equals(other.codeudorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Codeudor[ codeudorId=" + codeudorId + " ]";
    }

}
