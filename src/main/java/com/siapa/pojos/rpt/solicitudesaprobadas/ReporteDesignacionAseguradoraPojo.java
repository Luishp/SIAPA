/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.pojos.rpt.solicitudesaprobadas;

import java.io.Serializable;

/**
 *
 * @author Fm
 */
public class ReporteDesignacionAseguradoraPojo implements Serializable{
    
    private String fecha;
    
    private String asociadoNombre;
    private String asociadoDui;
    private String asociadoCodigo;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsociadoNombre() {
        return asociadoNombre;
    }

    public void setAsociadoNombre(String asociadoNombre) {
        this.asociadoNombre = asociadoNombre;
    }

    public String getAsociadoDui() {
        return asociadoDui;
    }

    public void setAsociadoDui(String asociadoDui) {
        this.asociadoDui = asociadoDui;
    }

    public String getAsociadoCodigo() {
        return asociadoCodigo;
    }

    public void setAsociadoCodigo(String asociadoCodigo) {
        this.asociadoCodigo = asociadoCodigo;
    }
    
}
