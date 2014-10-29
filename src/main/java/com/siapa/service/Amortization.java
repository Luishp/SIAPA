/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

/**
 *
 * @author Fm
 */
public class Amortization {

    int period = 0;
    double balance = 0.0;
    double periodInterest = 0.0;
    double periodPrincipal = 0.0;

    Amortization(int period, double balance, double periodInterest, double periodPrincipal) {
        this.period = period;
        this.balance = balance;
        this.periodInterest = periodInterest;
        this.periodPrincipal = periodPrincipal;
    }

     // getters for inner class; we only need to set values with the constructor,  
    // so we don't need setters  
    public int getPeriod() {
        return period;
    }

    public double getBalance() {
        return balance;
    }

    public double getPeriodInterest() {
        return periodInterest;
    }

    public double getPeriodPrincipal() {
        return periodPrincipal;
    }

}
