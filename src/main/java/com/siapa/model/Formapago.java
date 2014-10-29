/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "formapago", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Formapago.findAll", query = "SELECT f FROM Formapago f")})
public class Formapago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "FP_ID", nullable = true)
    private Integer fpId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FP_NOMBRE", nullable = false, length = 60)
    private String fpNombre;
  
    public Formapago() {
    }

    public Formapago(Integer fpId) {
        this.fpId = fpId;
    }

    public Formapago(Integer fpId, String fpNombre) {
        this.fpId = fpId;
        this.fpNombre = fpNombre;
    }

    public Integer getFpId() {
        return fpId;
    }

    public void setFpId(Integer fpId) {
        this.fpId = fpId;
    }

    public String getFpNombre() {
        return fpNombre;
    }

    public void setFpNombre(String fpNombre) {
        this.fpNombre = fpNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fpId != null ? fpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formapago)) {
            return false;
        }
        Formapago other = (Formapago) object;
        if ((this.fpId == null && other.fpId != null) || (this.fpId != null && !this.fpId.equals(other.fpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Formapago[ fpId=" + fpId + " ]";
    }
    
}
