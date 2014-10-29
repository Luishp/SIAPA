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
@Table(name = "asistente", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a")})
public class Asistente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsistentePK asistentePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASISTENTE_ASISTIRA", nullable = false)
    private Boolean asistenteAsistira;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ASSISTENTE_PERMISO", nullable = false)
    private Boolean assistentePermiso;
    @Column(name = "ASSISTENTE_ASISTIO")
    private Boolean assistenteAsistio;
    @JoinColumn(name = "MCC_ID", referencedColumnName = "MCC_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Miembroscomitecreditos miembroscomitecreditos;
    @JoinColumn(name = "ACC_ID", referencedColumnName = "ACC_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agendacomitecreditos agendacomitecreditos;
    private transient boolean selected;

    public Asistente() {
    }

    public Asistente(AsistentePK asistentePK) {
        this.asistentePK = asistentePK;
    }

    public Asistente(AsistentePK asistentePK, boolean asistenteAsistira, boolean assistentePermiso) {
        this.asistentePK = asistentePK;
        this.asistenteAsistira = asistenteAsistira;
        this.assistentePermiso = assistentePermiso;
    }

    public Asistente(int accId, int mccId) {
        this.asistentePK = new AsistentePK(accId, mccId);
    }

    public AsistentePK getAsistentePK() {
        return asistentePK;
    }

    public void setAsistentePK(AsistentePK asistentePK) {
        this.asistentePK = asistentePK;
    }

    public Boolean getAsistenteAsistira() {
        return asistenteAsistira;
    }

    public void setAsistenteAsistira(Boolean asistenteAsistira) {
        this.asistenteAsistira = asistenteAsistira;
    }

    public Boolean getAssistentePermiso() {
        return assistentePermiso;
    }

    public void setAssistentePermiso(Boolean assistentePermiso) {
        this.assistentePermiso = assistentePermiso;
    }

    public Boolean getAssistenteAsistio() {
        return assistenteAsistio;
    }

    public void setAssistenteAsistio(Boolean assistenteAsistio) {
        this.assistenteAsistio = assistenteAsistio;
    }

    public Miembroscomitecreditos getMiembroscomitecreditos() {
        return miembroscomitecreditos;
    }

    public void setMiembroscomitecreditos(Miembroscomitecreditos miembroscomitecreditos) {
        this.miembroscomitecreditos = miembroscomitecreditos;
    }

    public Agendacomitecreditos getAgendacomitecreditos() {
        return agendacomitecreditos;
    }

    public void setAgendacomitecreditos(Agendacomitecreditos agendacomitecreditos) {
        this.agendacomitecreditos = agendacomitecreditos;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asistentePK != null ? asistentePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistente)) {
            return false;
        }
        Asistente other = (Asistente) object;
        if ((this.asistentePK == null && other.asistentePK != null) || (this.asistentePK != null && !this.asistentePK.equals(other.asistentePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Asistente[ asistentePK=" + asistentePK + " ]";
    }
  
}
