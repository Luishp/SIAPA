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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "municipios", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")})
public class Municipios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ID_MUNICIPIO", nullable = false)
    private Integer idMunicipio;
    @Column(name = "CODIGO_MUNICIPIO")
    private String codigoMunicipio;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MUNICIPIO", nullable = false, length = 100)
    private String nombreMunicipio;
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
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Column(name = "USUARIO_ULTIMA_MODIFICACION", length = 15)
    private String usuarioUltimaModificacion;
    @Column(name = "FECHA_ULTIMA_MODIFICACION")
    @Temporal(TemporalType.DATE)
    private Date fechaUltimaModificacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicipio")
    private List<Registrogarantiahipotecaria> registrogarantiahipotecariaList;
    @JoinColumn(name = "ID_DEPARTAMENTO", referencedColumnName = "ID_DEPARTAMENTO")
    @ManyToOne(optional = false)
    private Departamentos idDepartamento;

    public Municipios() {
    }

    public Municipios(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Municipios(Integer idMunicipio, String codigoMunicipio, String nombreMunicipio, String usuarioRegistro, Date fechaRegistro) {
        this.idMunicipio = idMunicipio;
        this.codigoMunicipio = codigoMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public void setNombreMunicipio(String nombreMunicipio) {
        this.nombreMunicipio = nombreMunicipio;
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

    public Departamentos getIdDepartamento() {
        return idDepartamento;
    }

    public List<Registrogarantiahipotecaria> getRegistrogarantiahipotecariaList() {
        return registrogarantiahipotecariaList;
    }

    public void setRegistrogarantiahipotecariaList(List<Registrogarantiahipotecaria> registrogarantiahipotecariaList) {
        this.registrogarantiahipotecariaList = registrogarantiahipotecariaList;
    }

    public void setIdDepartamento(Departamentos idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Municipios[ idMunicipio=" + idMunicipio + " ]";
    }

}
