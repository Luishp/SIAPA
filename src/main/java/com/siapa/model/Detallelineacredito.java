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
@Table(name="detallelineacredito",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallelineacredito.findAll", query = "SELECT d FROM Detallelineacredito d")})
public class Detallelineacredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "DETALLELINEACREDITO_ID", nullable = false)
    private Integer detallelineacreditoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLELINEACREDITO_MONTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal detallelineacreditoMonto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLELINEACREDITO_TASA", nullable = false, precision = 4, scale = 4)
    private BigDecimal detallelineacreditoTasa;
    @Basic(optional = false)
    @Column(name = "DETALLELINEACREDITOCOMOTOR", nullable = true, precision = 4, scale = 4)
    private BigDecimal detallelineacreditocomotor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLELINEACREDITOCOMAPORT", nullable = false, precision = 10, scale = 2)
    private BigDecimal detallelineacreditocomaport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DETALLELINEACREDITO_PLAZO", nullable = false)
    private short detallelineacreditoPlazo;
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
    @OneToMany(mappedBy = "detallelineacreditoId", fetch = FetchType.LAZY)
    private List<Asesoria> asesoriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detallelineacredito", fetch = FetchType.LAZY)
    private Set<Garantiaexigida> garantiaexigidaList;
    @JoinColumn(name = "LINEACREDITO_ID", referencedColumnName = "LINEACREDITO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Lineacredito lineacreditoId;

    public Detallelineacredito() {
    }

    public Detallelineacredito(Integer detallelineacreditoId) {
        this.detallelineacreditoId = detallelineacreditoId;
    }

    public Detallelineacredito(Integer detallelineacreditoId, BigDecimal detallelineacreditoMonto, BigDecimal detallelineacreditoTasa, short detallelineacreditoPlazo, String usuarioRegistro, Date fechaRegistro) {
        this.detallelineacreditoId = detallelineacreditoId;
        this.detallelineacreditoMonto = detallelineacreditoMonto;
        this.detallelineacreditoTasa = detallelineacreditoTasa;
        this.detallelineacreditoPlazo = detallelineacreditoPlazo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getDetallelineacreditoId() {
        return detallelineacreditoId;
    }

    public void setDetallelineacreditoId(Integer detallelineacreditoId) {
        this.detallelineacreditoId = detallelineacreditoId;
    }

    public BigDecimal getDetallelineacreditoMonto() {
        return detallelineacreditoMonto;
    }

    public void setDetallelineacreditoMonto(BigDecimal detallelineacreditoMonto) {
        this.detallelineacreditoMonto = detallelineacreditoMonto;
    }

    public BigDecimal getDetallelineacreditoTasa() {
        return detallelineacreditoTasa;
    }

    public void setDetallelineacreditoTasa(BigDecimal detallelineacreditoTasa) {
        this.detallelineacreditoTasa = detallelineacreditoTasa;
    }

    public short getDetallelineacreditoPlazo() {
        return detallelineacreditoPlazo;
    }

    public void setDetallelineacreditoPlazo(short detallelineacreditoPlazo) {
        this.detallelineacreditoPlazo = detallelineacreditoPlazo;
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

    @XmlTransient
    @JsonIgnore
    public List<Asesoria> getAsesoriaList() {
        return asesoriaList;
    }

    public void setAsesoriaList(List<Asesoria> asesoriaList) {
        this.asesoriaList = asesoriaList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Garantiaexigida> getGarantiaexigidaList() {
        return garantiaexigidaList;
    }

    public void setGarantiaexigidaList(Set<Garantiaexigida> garantiaexigidaList) {
        this.garantiaexigidaList = garantiaexigidaList;
    }

    public Lineacredito getLineacreditoId() {
        return lineacreditoId;
    }

    public void setLineacreditoId(Lineacredito lineacreditoId) {
        this.lineacreditoId = lineacreditoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallelineacreditoId != null ? detallelineacreditoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallelineacredito)) {
            return false;
        }
        Detallelineacredito other = (Detallelineacredito) object;
        if ((this.detallelineacreditoId == null && other.detallelineacreditoId != null) || (this.detallelineacreditoId != null && !this.detallelineacreditoId.equals(other.detallelineacreditoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Detallelineacredito[ detallelineacreditoId=" + detallelineacreditoId + " ]";
    }

    public BigDecimal getDetallelineacreditocomotor() {
        return detallelineacreditocomotor;
    }

    public void setDetallelineacreditocomotor(BigDecimal detallelineacreditocomotor) {
        this.detallelineacreditocomotor = detallelineacreditocomotor;
    }

    public BigDecimal getDetallelineacreditocomaport() {
        return detallelineacreditocomaport;
    }

    public void setDetallelineacreditocomaport(BigDecimal detallelineacreditocomaport) {
        this.detallelineacreditocomaport = detallelineacreditocomaport;
    }
    
}
