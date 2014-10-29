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
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "prestamo", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "PRESTAMO_ID", nullable = false)
    private Integer prestamoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRESTAMO_MONTO", precision = 10, scale = 2)
    private BigDecimal prestamoMonto;
    @Column(name = "PRESTAMO_PLAZO")
    private Integer prestamoPlazo;
    @Column(name = "PRESTAMO_TASA", precision = 4, scale = 4)
    private BigDecimal prestamoTasa;
    @Column(name = "PRESTAMO_SALDO", precision = 10, scale = 2)
    private BigDecimal prestamoSaldo;
    @Column(name = "PRESTAMO_CUOTA", precision = 10, scale = 2)
    private BigDecimal prestamoCuota;
    @Column(name = "PRESTAMO_FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date prestamoFechapago;
    @Column(name = "PRESTAMO_FECHAVENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date prestamoFechavencimiento;
    @Column(name = "PRESTAMO_FECHAULTIMOPAGO")
    @Temporal(TemporalType.DATE)
    private Date prestamoFechaultimopago;
    @Column(name = "PRESTAMO_FECHAULTIMACAPITAL")
    @Temporal(TemporalType.DATE)
    private Date prestamoFechaultimacapital;
    @Column(name = "PRESTAMO_FECHAULTIMAINTERES")
    @Temporal(TemporalType.DATE)
    private Date prestamoFechaultimainteres;
    @Size(max = 2)
    @Column(name = "PRESTAMO_CATEGORIA", length = 2)
    private String prestamoCategoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String activo;
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
    @JoinColumn(name = "DESEMBOLSO_ID", referencedColumnName = "DESEMBOLSO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Desembolso desembolsoId;
    @OneToMany(mappedBy = "prestamoId", fetch = FetchType.LAZY)
    private List<Pagoprestamo> pagoprestamoList;
    @OneToMany(mappedBy = "prestamoId", fetch = FetchType.LAZY)
    private List<Abonoprestamo> abonoprestamoList;
    @OneToMany(mappedBy = "prestamoId", fetch = FetchType.LAZY)
    private List<Provisiondiaria> provisiondiariaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prestamo", fetch = FetchType.LAZY)
    private Set<PrestamosAsociados> prestamosAsociadosList;

    public Prestamo() {
    }

    public Prestamo(Integer prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Prestamo(Integer prestamoId, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.prestamoId = prestamoId;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Integer prestamoId) {
        this.prestamoId = prestamoId;
    }

    public BigDecimal getPrestamoMonto() {
        return prestamoMonto;
    }

    public void setPrestamoMonto(BigDecimal prestamoMonto) {
        this.prestamoMonto = prestamoMonto;
    }

    public Integer getPrestamoPlazo() {
        return prestamoPlazo;
    }

    public void setPrestamoPlazo(Integer prestamoPlazo) {
        this.prestamoPlazo = prestamoPlazo;
    }

    public BigDecimal getPrestamoTasa() {
        return prestamoTasa;
    }

    public void setPrestamoTasa(BigDecimal prestamoTasa) {
        this.prestamoTasa = prestamoTasa;
    }

    public BigDecimal getPrestamoSaldo() {
        return prestamoSaldo;
    }

    public void setPrestamoSaldo(BigDecimal prestamoSaldo) {
        this.prestamoSaldo = prestamoSaldo;
    }

    public BigDecimal getPrestamoCuota() {
        return prestamoCuota;
    }

    public void setPrestamoCuota(BigDecimal prestamoCuota) {
        this.prestamoCuota = prestamoCuota;
    }

    public Date getPrestamoFechapago() {
        return prestamoFechapago;
    }

    public void setPrestamoFechapago(Date prestamoFechapago) {
        this.prestamoFechapago = prestamoFechapago;
    }

    public Date getPrestamoFechavencimiento() {
        return prestamoFechavencimiento;
    }

    public void setPrestamoFechavencimiento(Date prestamoFechavencimiento) {
        this.prestamoFechavencimiento = prestamoFechavencimiento;
    }

    public Date getPrestamoFechaultimopago() {
        return prestamoFechaultimopago;
    }

    public void setPrestamoFechaultimopago(Date prestamoFechaultimopago) {
        this.prestamoFechaultimopago = prestamoFechaultimopago;
    }

    public Date getPrestamoFechaultimacapital() {
        return prestamoFechaultimacapital;
    }

    public void setPrestamoFechaultimacapital(Date prestamoFechaultimacapital) {
        this.prestamoFechaultimacapital = prestamoFechaultimacapital;
    }

    public Date getPrestamoFechaultimainteres() {
        return prestamoFechaultimainteres;
    }

    public void setPrestamoFechaultimainteres(Date prestamoFechaultimainteres) {
        this.prestamoFechaultimainteres = prestamoFechaultimainteres;
    }

    public String getPrestamoCategoria() {
        return prestamoCategoria;
    }

    public void setPrestamoCategoria(String prestamoCategoria) {
        this.prestamoCategoria = prestamoCategoria;
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

    public Desembolso getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Desembolso desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

        public Set<PrestamosAsociados> getPrestamosAsociadosList() {
        return prestamosAsociadosList;
    }

    public void setPrestamosAsociadosList(Set<PrestamosAsociados> prestamosAsociadosList) {
        this.prestamosAsociadosList = prestamosAsociadosList;
    }

    
    
    @XmlTransient
    @JsonIgnore
    public List<Pagoprestamo> getPagoprestamoList() {
        return pagoprestamoList;
    }

    public void setPagoprestamoList(List<Pagoprestamo> pagoprestamoList) {
        this.pagoprestamoList = pagoprestamoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Abonoprestamo> getAbonoprestamoList() {
        return abonoprestamoList;
    }

    public void setAbonoprestamoList(List<Abonoprestamo> abonoprestamoList) {
        this.abonoprestamoList = abonoprestamoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Provisiondiaria> getProvisiondiariaList() {
        return provisiondiariaList;
    }

    public void setProvisiondiariaList(List<Provisiondiaria> provisiondiariaList) {
        this.provisiondiariaList = provisiondiariaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prestamoId != null ? prestamoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.prestamoId == null && other.prestamoId != null) || (this.prestamoId != null && !this.prestamoId.equals(other.prestamoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Prestamo[ prestamoId=" + prestamoId + " ]";
    }


}
