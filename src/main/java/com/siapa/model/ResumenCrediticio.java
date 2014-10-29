/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.math.BigDecimal;

/**
 *
 * @author Cristian Oswaldo Fuentes
 */
public class ResumenCrediticio {
    
    private String categoria;
    private int numeroPrestamoDeudor; 
    private BigDecimal saldoActualDeudor; 
    private BigDecimal sumatoriaCuotas; 
    private String categoriaCodeudor;
    private int numeroPrestamoCodeudor; 
    private BigDecimal saldoActualCodeudor; 

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroPrestamoDeudor() {
        return numeroPrestamoDeudor;
    }

    public void setNumeroPrestamoDeudor(int numeroPrestamoDeudor) {
        this.numeroPrestamoDeudor = numeroPrestamoDeudor;
    }

    public BigDecimal getSaldoActualDeudor() {
        return saldoActualDeudor;
    }

    public void setSaldoActualDeudor(BigDecimal saldoActualDeudor) {
        this.saldoActualDeudor = saldoActualDeudor;
    }

    public BigDecimal getSumatoriaCuotas() {
        return sumatoriaCuotas;
    }

    public void setSumatoriaCuotas(BigDecimal sumatoriaCuotas) {
        this.sumatoriaCuotas = sumatoriaCuotas;
    }

    public String getCategoriaCodeudor() {
        return categoriaCodeudor;
    }

    public void setCategoriaCodeudor(String categoriaCodeudor) {
        this.categoriaCodeudor = categoriaCodeudor;
    }

    public int getNumeroPrestamoCodeudor() {
        return numeroPrestamoCodeudor;
    }

    public void setNumeroPrestamoCodeudor(int numeroPrestamoCodeudor) {
        this.numeroPrestamoCodeudor = numeroPrestamoCodeudor;
    }

    public BigDecimal getSaldoActualCodeudor() {
        return saldoActualCodeudor;
    }

    public void setSaldoActualCodeudor(BigDecimal saldoActualCodeudor) {
        this.saldoActualCodeudor = saldoActualCodeudor;
    }
   
}
