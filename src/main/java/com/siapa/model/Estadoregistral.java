package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Cristian Oswaldo Fuentes
 */
@Entity
@Table(name = "estadoregistral", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadoregistral.findAll", query = "SELECT e FROM Estadoregistral e")})
public class Estadoregistral implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RGH_ID")
    private Integer rghId;
    @Basic(optional = false)
    @Column(name = "ER_ANOTACIONPREVENTIVA")
    private String erAnotacionpreventiva;
    @Basic(optional = false)
    @Column(name = "ER_NUMEROASIENTO")
    private String erNumeroasiento;
    @Basic(optional = false)
    @Column(name = "ER_FECHAASIENTO")
    @Temporal(TemporalType.DATE)
    private Date erFechaasiento;
    @Basic(optional = false)
    @Column(name = "ER_FECHAPRESENTACIOAP")
    @Temporal(TemporalType.DATE)
    private Date erFechapresentacioap;
    @Basic(optional = false)
    @Column(name = "ER_FECHAVENCIMIENTOAP")
    @Temporal(TemporalType.DATE)
    private Date erFechavencimientoap;
    @Column(name = "ER_OBSERVACIONES")
    private String erObservaciones;
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
    @OneToOne(optional = false)
    private Registrogarantiahipotecaria registrogarantiahipotecaria;

    public Estadoregistral() {
    }

    public Estadoregistral(Integer rghId) {
        this.rghId = rghId;
    }

    public Estadoregistral(Integer rghId, String erAnotacionpreventiva, String erNumeroasiento, Date erFechaasiento, Date erFechapresentacioap, Date erFechavencimientoap, String usuarioRegistro, Date fechaRegistro) {
        this.rghId = rghId;
        this.erAnotacionpreventiva = erAnotacionpreventiva;
        this.erNumeroasiento = erNumeroasiento;
        this.erFechaasiento = erFechaasiento;
        this.erFechapresentacioap = erFechapresentacioap;
        this.erFechavencimientoap = erFechavencimientoap;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getRghId() {
        return rghId;
    }

    public void setRghId(Integer rghId) {
        this.rghId = rghId;
    }

    public String getErAnotacionpreventiva() {
        return erAnotacionpreventiva;
    }

    public void setErAnotacionpreventiva(String erAnotacionpreventiva) {
        this.erAnotacionpreventiva = erAnotacionpreventiva;
    }

    public String getErNumeroasiento() {
        return erNumeroasiento;
    }

    public void setErNumeroasiento(String erNumeroasiento) {
        this.erNumeroasiento = erNumeroasiento;
    }

    public Date getErFechaasiento() {
        return erFechaasiento;
    }

    public void setErFechaasiento(Date erFechaasiento) {
        this.erFechaasiento = erFechaasiento;
    }

    public Date getErFechapresentacioap() {
        return erFechapresentacioap;
    }

    public void setErFechapresentacioap(Date erFechapresentacioap) {
        this.erFechapresentacioap = erFechapresentacioap;
    }

    public Date getErFechavencimientoap() {
        return erFechavencimientoap;
    }

    public void setErFechavencimientoap(Date erFechavencimientoap) {
        this.erFechavencimientoap = erFechavencimientoap;
    }

    public String getErObservaciones() {
        return erObservaciones;
    }

    public void setErObservaciones(String erObservaciones) {
        this.erObservaciones = erObservaciones;
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
        hash += (rghId != null ? rghId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadoregistral)) {
            return false;
        }
        Estadoregistral other = (Estadoregistral) object;
        if ((this.rghId == null && other.rghId != null) || (this.rghId != null && !this.rghId.equals(other.rghId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Estadoregistral[ rghId=" + rghId + " ]";
    }

}
