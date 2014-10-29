package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Cristian Oswaldo Fuentes
 */
@Entity
@Table(name = "propietarioinmueble", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propietarioinmueble.findAll", query = "SELECT p FROM Propietarioinmueble p")})
public class Propietarioinmueble implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PropietarioinmueblePK propietarioinmueblePK;
    @Basic(optional = false)
    @Column(name = "PI_NOMBREPROPIETARIO")
    private String piNombrepropietario;
    @Basic(optional = false)
    @Column(name = "PI_DUIPROPIETARIO")
    private String piDuipropietario;
    @Basic(optional = false)
    @Column(name = "PI_NITPROPIETARIO")
    private String piNitpropietario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PI_PORCENTAJEPROPIEDAD")
    private BigDecimal piPorcentajepropiedad;
    @Basic(optional = false)
    @Column(name = "PI_TIPOTENENCIA")
    private String piTipotenencia;
    @Basic(optional = false)
    @Column(name = "ACTIVO")
    private String activo;
    @Basic(optional = false)
    @Column(name = "USUARIO_REGISTRO")
    private String usuarioRegistro;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Column(name = "USUARIO_ULTIMAMODIFICACION")
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @JoinColumn(name = "RGH_ID", referencedColumnName = "RGH_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Registrogarantiahipotecaria registrogarantiahipotecaria;

    public Propietarioinmueble() {
    }

    public Propietarioinmueble(PropietarioinmueblePK propietarioinmueblePK) {
        this.propietarioinmueblePK = propietarioinmueblePK;
    }

    public Propietarioinmueble(PropietarioinmueblePK propietarioinmueblePK, String piNombrepropietario, String piDuipropietario, String piNitpropietario, BigDecimal piPorcentajepropiedad, String piTipotenencia, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.propietarioinmueblePK = propietarioinmueblePK;
        this.piNombrepropietario = piNombrepropietario;
        this.piDuipropietario = piDuipropietario;
        this.piNitpropietario = piNitpropietario;
        this.piPorcentajepropiedad = piPorcentajepropiedad;
        this.piTipotenencia = piTipotenencia;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Propietarioinmueble(int rghId, int correlativo) {
        this.propietarioinmueblePK = new PropietarioinmueblePK(rghId, correlativo);
    }

    public PropietarioinmueblePK getPropietarioinmueblePK() {
        return propietarioinmueblePK;
    }

    public void setPropietarioinmueblePK(PropietarioinmueblePK propietarioinmueblePK) {
        this.propietarioinmueblePK = propietarioinmueblePK;
    }

    public String getPiNombrepropietario() {
        return piNombrepropietario;
    }

    public void setPiNombrepropietario(String piNombrepropietario) {
        this.piNombrepropietario = piNombrepropietario;
    }

    public String getPiDuipropietario() {
        return piDuipropietario;
    }

    public void setPiDuipropietario(String piDuipropietario) {
        this.piDuipropietario = piDuipropietario;
    }

    public String getPiNitpropietario() {
        return piNitpropietario;
    }

    public void setPiNitpropietario(String piNitpropietario) {
        this.piNitpropietario = piNitpropietario;
    }

    public BigDecimal getPiPorcentajepropiedad() {
        return piPorcentajepropiedad;
    }

    public void setPiPorcentajepropiedad(BigDecimal piPorcentajepropiedad) {
        this.piPorcentajepropiedad = piPorcentajepropiedad;
    }

    public String getPiTipotenencia() {
        return piTipotenencia;
    }

    public void setPiTipotenencia(String piTipotenencia) {
        this.piTipotenencia = piTipotenencia;
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

    public Registrogarantiahipotecaria getRegistrogarantiahipotecaria() {
        return registrogarantiahipotecaria;
    }

    public void setRegistrogarantiahipotecaria(Registrogarantiahipotecaria registrogarantiahipotecaria) {
        this.registrogarantiahipotecaria = registrogarantiahipotecaria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (propietarioinmueblePK != null ? propietarioinmueblePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propietarioinmueble)) {
            return false;
        }
        Propietarioinmueble other = (Propietarioinmueble) object;
        if ((this.propietarioinmueblePK == null && other.propietarioinmueblePK != null) || (this.propietarioinmueblePK != null && !this.propietarioinmueblePK.equals(other.propietarioinmueblePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Propietarioinmueble[ propietarioinmueblePK=" + propietarioinmueblePK + " ]";
    }

}
