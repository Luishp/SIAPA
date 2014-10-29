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
 * @author monte
 */
@Entity
@Table(name = "prestamosasociados", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PrestamosAsociados.findAll", query = "SELECT a FROM PrestamosAsociados a")})
public class PrestamosAsociados implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private PrestamosAsociadosPK prestamosAsociadosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO", nullable = true)
    private String tipo;
    @JoinColumn(name = "PRESTAMO_ID", referencedColumnName = "PRESTAMO_ID", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Prestamo prestamo;
    @JoinColumn(name = "IDASOCIADOS", referencedColumnName = "IDASOCIADOS", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asociados asociados;
   

    public PrestamosAsociados() {
    }

    public PrestamosAsociados(PrestamosAsociadosPK prestamosAsociadosPK) {
        this.prestamosAsociadosPK = prestamosAsociadosPK;
    }

    public PrestamosAsociados(PrestamosAsociadosPK prestamosAsociadosPK, String tipo) {
        this.prestamosAsociadosPK = prestamosAsociadosPK;
        this.tipo = tipo;
    }

    public PrestamosAsociados(int prestamoId, int idasociados) {
        this.prestamosAsociadosPK = new PrestamosAsociadosPK(prestamoId, idasociados);
    }

   
    public PrestamosAsociadosPK getPrestamosAsociadosPK() {
        return prestamosAsociadosPK;
    }

    public void setPrestamosAsociadosPK(PrestamosAsociadosPK prestamosAsociadosPK) {
        this.prestamosAsociadosPK = prestamosAsociadosPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Asociados getAsociados() {
        return asociados;
    }

    public void setAsociados(Asociados asociados) {
        this.asociados = asociados;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prestamosAsociadosPK != null ? prestamosAsociadosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asistente)) {
            return false;
        }
        PrestamosAsociados other = (PrestamosAsociados) object;
        if ((this.prestamosAsociadosPK == null && other.prestamosAsociadosPK != null) || (this.prestamosAsociadosPK != null && !this.prestamosAsociadosPK.equals(other.prestamosAsociadosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.PrestamosAsociados[ prestamosAsociadosPK=" + prestamosAsociadosPK + " ]";
    }



}
