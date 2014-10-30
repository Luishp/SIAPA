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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "tipo_comprobante", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoComprobante.findAll", query = "SELECT t FROM TipoComprobante t")})
public class TipoComprobante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_COMPROBANTE", nullable = false)
    private Long idTipoComprobante;
    @Column(name = "NOMBRE_TIPO_COMPROBANTE", length = 50)
    private String nombreTipoComprobante;
    @Column(name = "DESCRIPCION_TIPO_COMPROBANTE", length = 500)
    private String descripcionTipoComprobante;
    @OneToMany(mappedBy = "idTipoComprobante", fetch = FetchType.LAZY)
    private Set<ComprobanteVenta> comprobanteVentaSet;

    public TipoComprobante() {
    }

    public TipoComprobante(Long idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public Long getIdTipoComprobante() {
        return idTipoComprobante;
    }

    public void setIdTipoComprobante(Long idTipoComprobante) {
        this.idTipoComprobante = idTipoComprobante;
    }

    public String getNombreTipoComprobante() {
        return nombreTipoComprobante;
    }

    public void setNombreTipoComprobante(String nombreTipoComprobante) {
        this.nombreTipoComprobante = nombreTipoComprobante;
    }

    public String getDescripcionTipoComprobante() {
        return descripcionTipoComprobante;
    }

    public void setDescripcionTipoComprobante(String descripcionTipoComprobante) {
        this.descripcionTipoComprobante = descripcionTipoComprobante;
    }

    public Set<ComprobanteVenta> getComprobanteVentaSet() {
        return comprobanteVentaSet;
    }

    public void setComprobanteVentaSet(Set<ComprobanteVenta> comprobanteVentaSet) {
        this.comprobanteVentaSet = comprobanteVentaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoComprobante != null ? idTipoComprobante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoComprobante)) {
            return false;
        }
        TipoComprobante other = (TipoComprobante) object;
        if ((this.idTipoComprobante == null && other.idTipoComprobante != null) || (this.idTipoComprobante != null && !this.idTipoComprobante.equals(other.idTipoComprobante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.TipoComprobante[ idTipoComprobante=" + idTipoComprobante + " ]";
    }
    
}
