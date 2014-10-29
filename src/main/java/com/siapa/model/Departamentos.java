package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
@Entity
@Table(name = "departamentos", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamentos.findAll", query = "SELECT d FROM Departamentos d")})
public class Departamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_DEPARTAMENTO", nullable = false)
    private Integer idDepartamento;
    @Basic(optional = false)
    @Column(name = "CODIGO_DEPARTAMENTO")
    private String codigoDepartamento;
    @Column(name = "NOMBRE_DEPARTAMENTO",nullable = false,length = 100)
    private String nombreDepartamento;
    @Column(name = "ZONA_DEPARTAMENTO")
    private String zonaDepartamento;
    @Column(name = "FECHA_INICIAL_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaInicialVigencia;
    @Column(name = "FECHA_FINAL_VIGENCIA")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalVigencia;
    @Basic(optional = false)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 15)
    private String usuarioRegistro;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 15)
    private String usuarioUltimaModificacion;
    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<Municipios> municipiosList;

    public Departamentos() {
    }

    public Departamentos(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public Departamentos(Integer idDepartamento, String codigoDepartamento, String usuarioRegistro, Date fechaRegistro) {
        this.idDepartamento = idDepartamento;
        this.codigoDepartamento = codigoDepartamento;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getZonaDepartamento() {
        return zonaDepartamento;
    }

    public void setZonaDepartamento(String zonaDepartamento) {
        this.zonaDepartamento = zonaDepartamento;
    }

    public Date getFechaInicialVigencia() {
        return fechaInicialVigencia;
    }

    public void setFechaInicialVigencia(Date fechaInicialVigencia) {
        this.fechaInicialVigencia = fechaInicialVigencia;
    }

    public Date getFechaFinalVigencia() {
        return fechaFinalVigencia;
    }

    public void setFechaFinalVigencia(Date fechaFinalVigencia) {
        this.fechaFinalVigencia = fechaFinalVigencia;
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

    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    @XmlTransient
    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamentos)) {
            return false;
        }
        Departamentos other = (Departamentos) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Departamentos[ idDepartamento=" + idDepartamento + " ]";
    }

}
