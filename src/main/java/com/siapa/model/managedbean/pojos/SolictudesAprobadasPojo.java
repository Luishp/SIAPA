/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model.managedbean.pojos;

import com.siapa.model.Analisis;
import com.siapa.model.Asociados;
import com.siapa.model.Lineacredito;
import com.siapa.model.Tiporesolucion;
import java.io.Serializable;


/**
 *
 * @author Mely
 */
public class SolictudesAprobadasPojo implements Serializable{
    private String fechaResolucion;
    private Lineacredito lineaCredito;
    private Asociados asociado; 
    private Analisis analisis;
    private Tiporesolucion tipoResolucion;

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public Lineacredito getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(Lineacredito lineaCredito) {
        this.lineaCredito = lineaCredito;
    }

    public Asociados getAsociado() {
        return asociado;
    }

    public void setAsociado(Asociados asociado) {
        this.asociado = asociado;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
    }

    public Tiporesolucion getTipoResolucion() {
        return tipoResolucion;
    }

    public void setTipoResolucion(Tiporesolucion tipoResolucion) {
        this.tipoResolucion = tipoResolucion;
    }
    
    
    
    
    
}
