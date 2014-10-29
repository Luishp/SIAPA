/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "fuenteingreso", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fuenteingreso.findAll", query = "SELECT f FROM Fuenteingreso f")})
public class Fuenteingreso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "FI_ID", nullable = true)
    private Integer fiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FI_NOMBRE", nullable = false, length = 60)
    private String fiNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuenteingreso", fetch = FetchType.LAZY)
    private Set<Ingreso> ingresoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fuenteingreso", fetch = FetchType.LAZY)
    private Set<Ingresoanalisis> ingresoanalisisList;

    public Fuenteingreso() {
    }

    public Fuenteingreso(Integer fiId) {
        this.fiId = fiId;
    }

    public Fuenteingreso(Integer fiId, String fiNombre) {
        this.fiId = fiId;
        this.fiNombre = fiNombre;
    }

    public Integer getFiId() {
        return fiId;
    }

    public void setFiId(Integer fiId) {
        this.fiId = fiId;
    }

    public String getFiNombre() {
        return fiNombre;
    }

    public void setFiNombre(String fiNombre) {
        this.fiNombre = fiNombre;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Ingreso> getIngresoList() {
        return ingresoList;
    }

    public void setIngresoList(Set<Ingreso> ingresoList) {
        this.ingresoList = ingresoList;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Ingresoanalisis> getIngresoanalisisList() {
        return ingresoanalisisList;
    }

    public void setIngresoanalisisList(Set<Ingresoanalisis> ingresoanalisisList) {
        this.ingresoanalisisList = ingresoanalisisList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fiId != null ? fiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fuenteingreso)) {
            return false;
        }
        Fuenteingreso other = (Fuenteingreso) object;
        if ((this.fiId == null && other.fiId != null) || (this.fiId != null && !this.fiId.equals(other.fiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Fuenteingreso[ fiId=" + fiId + " ]";
    }
    
}
