/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "periodicidadpago", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodicidadpago.findAll", query = "SELECT p FROM Periodicidadpago p")})
public class Periodicidadpago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PP_ID", nullable = false)
    private Integer ppId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "PP_NOMBRE", nullable = false, length = 60)
    private String ppNombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PP_MESES", nullable = false, precision = 10, scale = 2)
    private BigDecimal ppMeses;

    public Periodicidadpago() {
    }

    public Periodicidadpago(Integer ppId) {
        this.ppId = ppId;
    }

    public Periodicidadpago(Integer ppId, String ppNombre) {
        this.ppId = ppId;
        this.ppNombre = ppNombre;
    }

    public Integer getPpId() {
        return ppId;
    }

    public void setPpId(Integer ppId) {
        this.ppId = ppId;
    }

    public String getPpNombre() {
        return ppNombre;
    }

    public void setPpNombre(String ppNombre) {
        this.ppNombre = ppNombre;
    }

     public BigDecimal getPpMeses() {
        return ppMeses;
    }

    public void setPpMeses(BigDecimal ppMeses) {
        this.ppMeses = ppMeses;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ppId != null ? ppId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodicidadpago)) {
            return false;
        }
        Periodicidadpago other = (Periodicidadpago) object;
        if ((this.ppId == null && other.ppId != null) || (this.ppId != null && !this.ppId.equals(other.ppId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Periodicidadpago[ ppId=" + ppId + " ]";
    }

}
