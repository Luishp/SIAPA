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
import javax.persistence.GenerationType;
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
 * @author Josue
 */
@Entity
@Table(name = "asociados", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asociados.findAll", query = "SELECT a FROM Asociados a")})
public class Asociados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idasociados;
    @Size(max = 40)
    private String codigo;
    @Size(max = 2)
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aportaciones", nullable = false, precision = 10, scale = 2)
    private BigDecimal aportacion;
    @Column(name = "date_ingre")
    @Temporal(TemporalType.DATE)
    private Date dateIngre;
    @Column(name = "date_actu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateActu;
    @Size(max = 255)
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_reg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    private String eliminado;
    @OneToMany(mappedBy = "idasocrefer", fetch = FetchType.LAZY)
    private Set<Asocnatu> asocnatuList;
    @JoinColumn(name = "idasocnatu", referencedColumnName = "idasocnatu")
    @ManyToOne(fetch = FetchType.EAGER)
    private Asocnatu idasocnatu;
    @JoinColumn(name = "idasocjuri", referencedColumnName = "idasocjuri")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asocjuri idasocjuri;
    @OneToMany(mappedBy = "asesoriaId", fetch = FetchType.LAZY)
    private Set<Asesoria> asesoriasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asociados", fetch = FetchType.LAZY)
    private Set<PrestamosAsociados> prestamosAsociadosList;
    
    
    public Set<Asesoria> getAsesoriasList() {
        return asesoriasList;
    }

    public void setAsesoriasList(Set<Asesoria> asesoriasList) {
        this.asesoriasList = asesoriasList;
    }
    
    public Asociados() {
    }

    public Asociados(Integer idasociados) {
        this.idasociados = idasociados;
    }

    public Asociados(Integer idasociados, Date dateReg, String activo, String eliminado) {
        this.idasociados = idasociados;
        this.dateReg = dateReg;
        this.activo = activo;
        this.eliminado = eliminado;
    }

    public Integer getIdasociados() {
        return idasociados;
    }

    public void setIdasociados(Integer idasociados) {
        this.idasociados = idasociados;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getDateIngre() {
        return dateIngre;
    }

    public void setDateIngre(Date dateIngre) {
        this.dateIngre = dateIngre;
    }

    public Date getDateActu() {
        return dateActu;
    }

    public void setDateActu(Date dateActu) {
        this.dateActu = dateActu;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getEliminado() {
        return eliminado;
    }

    public void setEliminado(String eliminado) {
        this.eliminado = eliminado;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Asocnatu> getAsocnatuList() {
        return asocnatuList;
    }

    public void setAsocnatuList(Set<Asocnatu> asocnatuList) {
        this.asocnatuList = asocnatuList;
    }

    public Asocnatu getIdasocnatu() {
        return idasocnatu;
    }

    public void setIdasocnatu(Asocnatu idasocnatu) {
        this.idasocnatu = idasocnatu;
    }

    public Asocjuri getIdasocjuri() {
        return idasocjuri;
    }

    public void setIdasocjuri(Asocjuri idasocjuri) {
        this.idasocjuri = idasocjuri;
    }

    public Set<PrestamosAsociados> getPrestamosAsociadosList() {
        return prestamosAsociadosList;
    }

    public void setPrestamosAsociadosList(Set<PrestamosAsociados> prestamosAsociadosList) {
        this.prestamosAsociadosList = prestamosAsociadosList;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasociados != null ? idasociados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asociados)) {
            return false;
        }
        Asociados other = (Asociados) object;
        if ((this.idasociados == null && other.idasociados != null) || (this.idasociados != null && !this.idasociados.equals(other.idasociados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Asociados[ idasociados=" + idasociados + " ]";
    }

    public BigDecimal getAportacion() {
        return aportacion;
    }

    public void setAportacion(BigDecimal aportacion) {
        this.aportacion = aportacion;
    }
       
     }
