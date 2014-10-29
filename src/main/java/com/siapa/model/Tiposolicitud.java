/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.util.Set;
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
@Table(name="tiposolicitud", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tiposolicitud.findAll", query = "SELECT t FROM Tiposolicitud t")})
public class Tiposolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TS_ID", nullable = false)
    private Integer tsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TS_NOMBRE", nullable = false, length = 50)
    private String tsNombre;
    @OneToMany(mappedBy = "tsId", fetch = FetchType.LAZY)
    private Set<Analisis> analisisList;

    public Tiposolicitud() {
    }

    public Tiposolicitud(Integer tsId) {
        this.tsId = tsId;
    }

    public Tiposolicitud(Integer tsId, String tsNombre) {
        this.tsId = tsId;
        this.tsNombre = tsNombre;
    }

    public Integer getTsId() {
        return tsId;
    }

    public void setTsId(Integer tsId) {
        this.tsId = tsId;
    }

    public String getTsNombre() {
        return tsNombre;
    }

    public void setTsNombre(String tsNombre) {
        this.tsNombre = tsNombre;
    }
    
    @XmlTransient
    @JsonIgnore
    public Set<Analisis> getAnalisisList() {
        return analisisList;
    }

    public void setResolucionList(Set<Analisis> analisisList) {
        this.analisisList = analisisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tsId != null ? tsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tiposolicitud)) {
            return false;
        }
        Tiposolicitud other = (Tiposolicitud) object;
        if ((this.tsId == null && other.tsId != null) || (this.tsId != null && !this.tsId.equals(other.tsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Tiposolicitud[ tsId=" + tsId + " ]";
    }

}
