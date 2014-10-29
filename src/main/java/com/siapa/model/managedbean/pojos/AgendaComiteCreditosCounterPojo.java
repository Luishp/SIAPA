/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.model.managedbean.pojos;

import java.io.Serializable;

/**
 *
 * @author monte
 */
public class AgendaComiteCreditosCounterPojo implements Serializable {

    private Long esperados;
    private Long permisos;
    private Long asistencia;
    private Long solicitudes;

    public Long getEsperados() {
        return esperados;
    }

    public void setEsperados(Long esperados) {
        this.esperados = esperados;
    }

    public Long getPermisos() {
        return permisos;
    }

    public void setPermisos(Long permisos) {
        this.permisos = permisos;
    }

    public Long getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Long asistencia) {
        this.asistencia = asistencia;
    }

    public Long getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(Long solicitudes) {
        this.solicitudes = solicitudes;
    }
    
}
