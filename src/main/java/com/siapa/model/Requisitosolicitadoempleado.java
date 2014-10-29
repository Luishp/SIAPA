/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "requisitosolicitadoempleado",catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitosolicitadoempleado.findAll", query = "SELECT r FROM Requisitosolicitadoempleado r")})
public class Requisitosolicitadoempleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitosolicitadoempleadoPK requisitosolicitadoempleadoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RSN_ENTREGADO", nullable = false)
    private boolean rsnEntregado;
    @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asesoria asesoria;
    @JoinColumn(name = "REQUISITOLINEACREDITOEMPLEADO_ID", referencedColumnName = "REQUISITOLINEACREDITOEMPLEADO_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Requisitolineacreditoempleado requisitolineacreditoempleado;

    public Requisitosolicitadoempleado() {
    }

    public Requisitosolicitadoempleado(RequisitosolicitadoempleadoPK requisitosolicitadoempleadoPK) {
        this.requisitosolicitadoempleadoPK = requisitosolicitadoempleadoPK;
    }

    public Requisitosolicitadoempleado(RequisitosolicitadoempleadoPK requisitosolicitadoempleadoPK, boolean rsnEntregado) {
        this.requisitosolicitadoempleadoPK = requisitosolicitadoempleadoPK;
        this.rsnEntregado = rsnEntregado;
    }

    public Requisitosolicitadoempleado(int requisitolineacreditoempleadoId, int asesoriaId) {
        this.requisitosolicitadoempleadoPK = new RequisitosolicitadoempleadoPK(requisitolineacreditoempleadoId, asesoriaId);
    }

    public RequisitosolicitadoempleadoPK getRequisitosolicitadoempleadoPK() {
        return requisitosolicitadoempleadoPK;
    }

    public void setRequisitosolicitadoempleadoPK(RequisitosolicitadoempleadoPK requisitosolicitadoempleadoPK) {
        this.requisitosolicitadoempleadoPK = requisitosolicitadoempleadoPK;
    }

    public boolean getRsnEntregado() {
        return rsnEntregado;
    }

    public void setRsnEntregado(boolean rsnEntregado) {
        this.rsnEntregado = rsnEntregado;
    }

    public Asesoria getAsesoria() {
        return asesoria;
    }

    public void setAsesoria(Asesoria asesoria) {
        this.asesoria = asesoria;
    }

    public Requisitolineacreditoempleado getRequisitolineacreditoempleado() {
        return requisitolineacreditoempleado;
    }

    public void setRequisitolineacreditoempleado(Requisitolineacreditoempleado requisitolineacreditoempleado) {
        this.requisitolineacreditoempleado = requisitolineacreditoempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitosolicitadoempleadoPK != null ? requisitosolicitadoempleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitosolicitadoempleado)) {
            return false;
        }
        Requisitosolicitadoempleado other = (Requisitosolicitadoempleado) object;
        if ((this.requisitosolicitadoempleadoPK == null && other.requisitosolicitadoempleadoPK != null) || (this.requisitosolicitadoempleadoPK != null && !this.requisitosolicitadoempleadoPK.equals(other.requisitosolicitadoempleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitosolicitadoempleado[ requisitosolicitadoempleadoPK=" + requisitosolicitadoempleadoPK + " ]";
    }
    
}
