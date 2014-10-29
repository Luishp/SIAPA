package com.siapa.pojos.rpt.actacomitecredito;

import java.io.Serializable;

/**
 *
 * @author Fm
 */
public class ReporteActaComiteCreditopojo implements Serializable {
    
    private String actaNumero;
    private String reunionLugar;
    private String reunionFecha;
    private String reunionHora;
    
    private String asistentes;
    private String solicitudesAprobadas;
    private String solicitudesDevueltas;
    private String solicitudesDenegadas;


     public String getReunionHora() {
        return reunionHora;
    }

    public void setReunionHora(String reunionHora) {
        this.reunionHora = reunionHora;
    }
    
    public String getActaNumero() {
        return actaNumero;
    }

    public void setActaNumero(String actaNumero) {
        this.actaNumero = actaNumero;
    }

    public String getReunionLugar() {
        return reunionLugar;
    }

    public void setReunionLugar(String reunionLugar) {
        this.reunionLugar = reunionLugar;
    }

    public String getReunionFecha() {
        return reunionFecha;
    }

    public void setReunionFecha(String reunionFecha) {
        this.reunionFecha = reunionFecha;
    }

    public String getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    public String getSolicitudesAprobadas() {
        return solicitudesAprobadas;
    }

    public void setSolicitudesAprobadas(String solicitudesAprobadas) {
        this.solicitudesAprobadas = solicitudesAprobadas;
    }

    public String getSolicitudesDevueltas() {
        return solicitudesDevueltas;
    }

    public void setSolicitudesDevueltas(String solicitudesDevueltas) {
        this.solicitudesDevueltas = solicitudesDevueltas;
    }

    public String getSolicitudesDenegadas() {
        return solicitudesDenegadas;
    }

    public void setSolicitudesDenegadas(String solicitudesDenegadas) {
        this.solicitudesDenegadas = solicitudesDenegadas;
    }
    
}
