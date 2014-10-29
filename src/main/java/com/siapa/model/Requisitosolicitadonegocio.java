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
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitosolicitadonegocio.findAll", query = "SELECT r FROM Requisitosolicitadonegocio r")})
public class Requisitosolicitadonegocio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RequisitosolicitadonegocioPK requisitosolicitadonegocioPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RSN_ENTREGADO", nullable = false)
    private boolean rsnEntregado;
    @JoinColumn(name = "ASESORIA_ID", referencedColumnName = "ASESORIA_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asesoria asesoria;
    @JoinColumn(name = "REQUISITO_LINEACREDITONEGOCIO_ID", referencedColumnName = "REQUISITO_LINEACREDITONEGOCIO_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Requisitolineacreditonegocio requisitolineacreditonegocio;

    public Requisitosolicitadonegocio() {
    }

    public Requisitosolicitadonegocio(RequisitosolicitadonegocioPK requisitosolicitadonegocioPK) {
        this.requisitosolicitadonegocioPK = requisitosolicitadonegocioPK;
    }

    public Requisitosolicitadonegocio(RequisitosolicitadonegocioPK requisitosolicitadonegocioPK, boolean rsnEntregado) {
        this.requisitosolicitadonegocioPK = requisitosolicitadonegocioPK;
        this.rsnEntregado = rsnEntregado;
    }

    public Requisitosolicitadonegocio(int requisitoLineacreditonegocioId, int asesoriaId) {
        this.requisitosolicitadonegocioPK = new RequisitosolicitadonegocioPK(requisitoLineacreditonegocioId, asesoriaId);
    }

    public RequisitosolicitadonegocioPK getRequisitosolicitadonegocioPK() {
        return requisitosolicitadonegocioPK;
    }

    public void setRequisitosolicitadonegocioPK(RequisitosolicitadonegocioPK requisitosolicitadonegocioPK) {
        this.requisitosolicitadonegocioPK = requisitosolicitadonegocioPK;
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

    public Requisitolineacreditonegocio getRequisitolineacreditonegocio() {
        return requisitolineacreditonegocio;
    }

    public void setRequisitolineacreditonegocio(Requisitolineacreditonegocio requisitolineacreditonegocio) {
        this.requisitolineacreditonegocio = requisitolineacreditonegocio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requisitosolicitadonegocioPK != null ? requisitosolicitadonegocioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitosolicitadonegocio)) {
            return false;
        }
        Requisitosolicitadonegocio other = (Requisitosolicitadonegocio) object;
        if ((this.requisitosolicitadonegocioPK == null && other.requisitosolicitadonegocioPK != null) || (this.requisitosolicitadonegocioPK != null && !this.requisitosolicitadonegocioPK.equals(other.requisitosolicitadonegocioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Requisitosolicitadonegocio[ requisitosolicitadonegocioPK=" + requisitosolicitadonegocioPK + " ]";
    }
    
}
