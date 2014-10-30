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
@Table(name = "tipo_alimento", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "TipoAlimento.findAll", query = "SELECT t FROM TipoAlimento t")})
public class TipoAlimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ALIMENTO", nullable = false)
    private Long idTipoAlimento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_ALIMENTO", nullable = false, length = 50)
    private String nombreTipoAlimento;
    @Column(name = "DESCRICION_TIPO_ALIMENTO", length = 500)
    private String descricionTipoAlimento;
    @Column(name = "PORCE_PROTEINA_TIPO_ALIMENTO", length = 30)
    private String porceProteinaTipoAlimento;
    @OneToMany(mappedBy = "idTipoAlimento", fetch = FetchType.LAZY)
    private Set<Alimento> alimentoSet;

    public TipoAlimento() {
    }

    public TipoAlimento(Long idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }

    public TipoAlimento(Long idTipoAlimento, String nombreTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
        this.nombreTipoAlimento = nombreTipoAlimento;
    }

    public Long getIdTipoAlimento() {
        return idTipoAlimento;
    }

    public void setIdTipoAlimento(Long idTipoAlimento) {
        this.idTipoAlimento = idTipoAlimento;
    }

    public String getNombreTipoAlimento() {
        return nombreTipoAlimento;
    }

    public void setNombreTipoAlimento(String nombreTipoAlimento) {
        this.nombreTipoAlimento = nombreTipoAlimento;
    }

    public String getDescricionTipoAlimento() {
        return descricionTipoAlimento;
    }

    public void setDescricionTipoAlimento(String descricionTipoAlimento) {
        this.descricionTipoAlimento = descricionTipoAlimento;
    }

    public String getPorceProteinaTipoAlimento() {
        return porceProteinaTipoAlimento;
    }

    public void setPorceProteinaTipoAlimento(String porceProteinaTipoAlimento) {
        this.porceProteinaTipoAlimento = porceProteinaTipoAlimento;
    }

    public Set<Alimento> getAlimentoSet() {
        return alimentoSet;
    }

    public void setAlimentoSet(Set<Alimento> alimentoSet) {
        this.alimentoSet = alimentoSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoAlimento != null ? idTipoAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoAlimento)) {
            return false;
        }
        TipoAlimento other = (TipoAlimento) object;
        if ((this.idTipoAlimento == null && other.idTipoAlimento != null) || (this.idTipoAlimento != null && !this.idTipoAlimento.equals(other.idTipoAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.TipoAlimento[ idTipoAlimento=" + idTipoAlimento + " ]";
    }
    
}
