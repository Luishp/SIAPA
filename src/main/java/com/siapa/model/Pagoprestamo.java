/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagoprestamo.findAll", query = "SELECT p FROM Pagoprestamo p")})
public class Pagoprestamo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAGOPRESTAMO_ID", nullable = false)
    private Long pagoprestamoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PAGOPRESTAMO_MONTOPAGO", precision = 10, scale = 2)
    private BigDecimal pagoprestamoMontopago;
    @Column(name = "PAGOPRESTAMO_ABONOCAPITAL", precision = 10, scale = 2)
    private BigDecimal pagoprestamoAbonocapital;
    @Column(name = "PAGOPRESTAMO_PAGOINTERESNORMAL", precision = 10, scale = 2)
    private BigDecimal pagoprestamoPagointeresnormal;
    @Column(name = "PAGOPRESTAMO_PAGOINTERESMORATORIO", precision = 10, scale = 2)
    private BigDecimal pagoprestamoPagointeresmoratorio;
    @Column(name = "PAGOPRESTAMO_CAPITALDIFERIDO", precision = 10, scale = 2)
    private BigDecimal pagoprestamoCapitaldiferido;
    @Column(name = "PAGOPRESTAMO_INTERESDIFERIDO", precision = 10, scale = 2)
    private BigDecimal pagoprestamoInteresdiferido;
    @Column(name = "PAGOPRESTAMO_COSTASPROCESALES", precision = 10, scale = 2)
    private BigDecimal pagoprestamoCostasprocesales;
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
    @JoinColumn(name = "PRESTAMO_ID", referencedColumnName = "PRESTAMO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prestamo prestamoId;
    @OneToMany(mappedBy = "pagoprestamoId", fetch = FetchType.LAZY)
    private List<Comprobantecaja> comprobantecajaList;

    public Pagoprestamo() {
    }

    public Pagoprestamo(Long pagoprestamoId) {
        this.pagoprestamoId = pagoprestamoId;
    }

    public Pagoprestamo(Long pagoprestamoId, String usuarioRegistro, Date fechaRegistro) {
        this.pagoprestamoId = pagoprestamoId;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getPagoprestamoId() {
        return pagoprestamoId;
    }

    public void setPagoprestamoId(Long pagoprestamoId) {
        this.pagoprestamoId = pagoprestamoId;
    }

    public BigDecimal getPagoprestamoMontopago() {
        return pagoprestamoMontopago;
    }

    public void setPagoprestamoMontopago(BigDecimal pagoprestamoMontopago) {
        this.pagoprestamoMontopago = pagoprestamoMontopago;
    }

    public BigDecimal getPagoprestamoAbonocapital() {
        return pagoprestamoAbonocapital;
    }

    public void setPagoprestamoAbonocapital(BigDecimal pagoprestamoAbonocapital) {
        this.pagoprestamoAbonocapital = pagoprestamoAbonocapital;
    }

    public BigDecimal getPagoprestamoPagointeresnormal() {
        return pagoprestamoPagointeresnormal;
    }

    public void setPagoprestamoPagointeresnormal(BigDecimal pagoprestamoPagointeresnormal) {
        this.pagoprestamoPagointeresnormal = pagoprestamoPagointeresnormal;
    }

    public BigDecimal getPagoprestamoPagointeresmoratorio() {
        return pagoprestamoPagointeresmoratorio;
    }

    public void setPagoprestamoPagointeresmoratorio(BigDecimal pagoprestamoPagointeresmoratorio) {
        this.pagoprestamoPagointeresmoratorio = pagoprestamoPagointeresmoratorio;
    }

    public BigDecimal getPagoprestamoCapitaldiferido() {
        return pagoprestamoCapitaldiferido;
    }

    public void setPagoprestamoCapitaldiferido(BigDecimal pagoprestamoCapitaldiferido) {
        this.pagoprestamoCapitaldiferido = pagoprestamoCapitaldiferido;
    }

    public BigDecimal getPagoprestamoInteresdiferido() {
        return pagoprestamoInteresdiferido;
    }

    public void setPagoprestamoInteresdiferido(BigDecimal pagoprestamoInteresdiferido) {
        this.pagoprestamoInteresdiferido = pagoprestamoInteresdiferido;
    }

    public BigDecimal getPagoprestamoCostasprocesales() {
        return pagoprestamoCostasprocesales;
    }

    public void setPagoprestamoCostasprocesales(BigDecimal pagoprestamoCostasprocesales) {
        this.pagoprestamoCostasprocesales = pagoprestamoCostasprocesales;
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

    public Prestamo getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Prestamo prestamoId) {
        this.prestamoId = prestamoId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Comprobantecaja> getComprobantecajaList() {
        return comprobantecajaList;
    }

    public void setComprobantecajaList(List<Comprobantecaja> comprobantecajaList) {
        this.comprobantecajaList = comprobantecajaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagoprestamoId != null ? pagoprestamoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagoprestamo)) {
            return false;
        }
        Pagoprestamo other = (Pagoprestamo) object;
        if ((this.pagoprestamoId == null && other.pagoprestamoId != null) || (this.pagoprestamoId != null && !this.pagoprestamoId.equals(other.pagoprestamoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Pagoprestamo[ pagoprestamoId=" + pagoprestamoId + " ]";
    }
    
}
