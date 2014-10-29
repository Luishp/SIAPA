/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(name = "analisisenagendacomitecreditos", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analisisenagendacomitecreditos.findAll", query = "SELECT a FROM Analisisenagendacomitecreditos a")})
public class Analisisenagendacomitecreditos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnalisisenagendacomitecreditosPK analisisenagendacomitecreditosPK;
    @JoinColumn(name = "ANALISIS_ID", referencedColumnName = "ANALISIS_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Analisis analisis;
    @JoinColumn(name = "ACC_ID", referencedColumnName = "ACC_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Agendacomitecreditos agendacomitecreditos;
    @JoinColumn(name = "TIPORESOLUCION_ID", referencedColumnName = "TIPORESOLUCION_ID", nullable = true, insertable = false, updatable = true)
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Tiporesolucion tiporesolucionId;

    public Analisisenagendacomitecreditos() {
    }

    public Analisisenagendacomitecreditos(AnalisisenagendacomitecreditosPK analisisenagendacomitecreditosPK) {
        this.analisisenagendacomitecreditosPK = analisisenagendacomitecreditosPK;
    }

    public Analisisenagendacomitecreditos(int accId, int analisisId) {
        this.analisisenagendacomitecreditosPK = new AnalisisenagendacomitecreditosPK(accId, analisisId);
    }

    public AnalisisenagendacomitecreditosPK getAnalisisenagendacomitecreditosPK() {
        return analisisenagendacomitecreditosPK;
    }

    public void setAnalisisenagendacomitecreditosPK(AnalisisenagendacomitecreditosPK analisisenagendacomitecreditosPK) {
        this.analisisenagendacomitecreditosPK = analisisenagendacomitecreditosPK;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    public Agendacomitecreditos getAgendacomitecreditos() {
        return agendacomitecreditos;
    }

    public void setAgendacomitecreditos(Agendacomitecreditos agendacomitecreditos) {
        this.agendacomitecreditos = agendacomitecreditos;
    }

    public Tiporesolucion getTiporesolucionId() {
        return tiporesolucionId;
    }

    public void setTiporesolucionId(Tiporesolucion tiporesolucionId) {
        this.tiporesolucionId = tiporesolucionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (analisisenagendacomitecreditosPK != null ? analisisenagendacomitecreditosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analisisenagendacomitecreditos)) {
            return false;
        }
        Analisisenagendacomitecreditos other = (Analisisenagendacomitecreditos) object;
        if ((this.analisisenagendacomitecreditosPK == null && other.analisisenagendacomitecreditosPK != null) || (this.analisisenagendacomitecreditosPK != null && !this.analisisenagendacomitecreditosPK.equals(other.analisisenagendacomitecreditosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Analisisenagendacomitecreditos[ analisisenagendacomitecreditosPK=" + analisisenagendacomitecreditosPK + " ]";
    }

}
