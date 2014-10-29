/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.service;

import com.siapa.dao.DesembolsoDao;
import com.siapa.dao.generic.GenericDao;
import com.siapa.model.Deducciones;
import com.siapa.model.Desembolso;
import com.siapa.model.Periodicidadpago;
import com.siapa.pojos.rpt.comprobantedesembolso.RptComprobanteDesembolso;
import com.siapa.pojos.rpt.comprobantedesembolso.RptTablaDesembolso;
import com.siapa.pojos.rpt.tablateoricaamortizacion.DetalleTablaTeoricaAmortizacionPojo;
import com.siapa.pojos.rpt.tablateoricaamortizacion.ReporteTablaTeoricaAmortizacionPojo;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.avro.generic.GenericData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author monte
 */
@Service(value = "desembolsoService")
public class DesembolsoService extends GenericService<Desembolso, Integer> {

    @Autowired
    private DesembolsoDao desembolsoDao;
    @Autowired
    private PeriodicidadPagoService periodicidadPagoService;

    @Override
    public GenericDao<Desembolso, Integer> getDao() {
        return desembolsoDao;
    }

    private double term;
    private double rate;
    private double originalPrincipal;
    private double payment;
    private ArrayList amortizationTable = new ArrayList();
    public static final double UNKNOWN = -1.0;

    public List<Desembolso> buscarParaEditar() {
        return desembolsoDao.buscarParaEditar();
    }

    public List<Desembolso> buscarParaAplicar() {
        return desembolsoDao.buscarParaAplicar();
    }

    public List<Desembolso> buscarParaReporte() {
        return desembolsoDao.buscarParaReporte();
    }

    public Desembolso fillDesembolso(Desembolso desembolso) {
        return desembolsoDao.fillDesembolso(desembolso);
    }

    public RptComprobanteDesembolso fillComprobanteDesembolso(Desembolso desembolso) {
        RptComprobanteDesembolso pojo = new RptComprobanteDesembolso();
        List<RptTablaDesembolso> list = new ArrayList<RptTablaDesembolso>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Desembolso tmp = desembolsoDao.findById(desembolso.getDesembolsoId());

        pojo.setNombreasociado(tmp.getResolucionId().getAnalisisId().getSolicitudId().getNombreCompleto());
        pojo.setCodigo(tmp.getResolucionId().getAnalisisId().getSolicitudId().getSolicitudCodigoasociado());
        pojo.setLinea(tmp.getResolucionId().getAnalisisId().getSolicitudId().getAsesoriaId().getDetallelineacreditoId().getLineacreditoId().getLineacreditoNombre());
        pojo.setMonto(tmp.getResolucionId().getAnalisisId().getAnalisisMonto().toString());
        pojo.setNumeros(tmp.getResolucionId().getAnalisisId().getAnalisisMonto().toString());
        pojo.setPlazo(tmp.getResolucionId().getAnalisisId().getAnalisisPlazo().toString());
        pojo.setGarantia("");

        pojo.setTasaanual(tmp.getResolucionId().getAnalisisId().getAnalisisTasa().toString());
        pojo.setPeriocidad(tmp.getResolucionId().getAnalisisId().getSolicitudId().getPpId().getPpNombre());
        pojo.setFormapago(tmp.getResolucionId().getAnalisisId().getSolicitudId().getFpId().getFpNombre());
        pojo.setValorcuota(tmp.getResolucionId().getAnalisisId().getAnalisisCuotacapitalmasintereses().toString());
        pojo.setPrimerpago(df.format(tmp.getDesembolsoFechaprimerpago()));
        pojo.setDiapago(String.valueOf(tmp.getResolucionId().getAnalisisId().getSolicitudId().getSolicitudDiapago()));

        for (Deducciones deduccion : tmp.getDeduccionesList()) {
            RptTablaDesembolso r = new RptTablaDesembolso();
            r.setCuentacontable("1105");
            r.setDescripcion(deduccion.getDeduccionesDescripcion());
            r.setValor(deduccion.getDeduccionesValor().toString());
        }

        return pojo;
    }

    public ReporteTablaTeoricaAmortizacionPojo fillTablaAmortizacion(Desembolso desembolso) {
        ReporteTablaTeoricaAmortizacionPojo pojo = new ReporteTablaTeoricaAmortizacionPojo();
        List<DetalleTablaTeoricaAmortizacionPojo> tabla = new ArrayList<DetalleTablaTeoricaAmortizacionPojo>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = new GregorianCalendar();
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        Float nc;
        Desembolso tmp = desembolsoDao.findById(desembolso.getDesembolsoId());

        pojo.setMontoOriginal(tmp.getPrestamoId().getPrestamoMonto().toString());
        pojo.setFechaApertura(df.format(tmp.getPrestamoId().getFechaRegistro()));
        if (tmp.getResolucionId().getAnalisisId().getSolicitudId().getPpId() != null) {
            if (tmp.getResolucionId().getAnalisisId().getSolicitudId().getPpId().getPpMeses().equals(BigDecimal.ZERO)) {
                nc = new Float("1");
            } else {
                nc = tmp.getResolucionId().getAnalisisId().getAnalisisPlazo() / tmp.getResolucionId().getAnalisisId().getSolicitudId().getPpId().getPpMeses().floatValue();
            }
        } else {

            Periodicidadpago p = periodicidadPagoService.findById(1);
            nc = tmp.getResolucionId().getAnalisisId().getAnalisisPlazo() / p.getPpMeses().floatValue();
        }

        pojo.setNumeroCuotas(nc.toString());

        pojo.setTasaInteresNominal(tmp.getPrestamoId().getPrestamoTasa().toString());
        pojo.setFechaVencimiento(df.format(tmp.getPrestamoId().getPrestamoFechavencimiento()));

        amortizationTable.clear();
        populateLoanTerms(tmp.getPrestamoId().getPrestamoMonto().doubleValue(), tmp.getResolucionId().getAnalisisId().getAnalisisPlazo(), tmp.getPrestamoId().getPrestamoTasa().doubleValue());

        for (int i = 0; i < amortizationTable.size(); i++) {
            calendar.setTime(tmp.getDesembolsoFechaprimerpago());
            Amortization line = (Amortization) amortizationTable.get(i);
            DetalleTablaTeoricaAmortizacionPojo p = new DetalleTablaTeoricaAmortizacionPojo();
            calendar.add(Calendar.MONTH, i);

            p.setAnio("Año " + (i % 12) + 1);
            p.setMes(String.valueOf(i + 1));
            p.setFechaPago(df.format(calendar.getTime()));
            p.setPagosARealizar(decimalFormat.format(line.getPeriodPrincipal() + line.getPeriodInterest() + tmp.getDesembolsoSeguros().doubleValue()).replaceAll(",", ""));
            p.setAmortizacionACapital(decimalFormat.format(line.getPeriodPrincipal()).replaceAll(",", ""));
            p.setAmortizacionAIntereses(decimalFormat.format(line.getPeriodInterest()).replaceAll(",", ""));
            p.setSeguros(decimalFormat.format(tmp.getDesembolsoSeguros().doubleValue()).replaceAll(",", ""));
            p.setComisiones("0.00");
            p.setIva("0.00");
            p.setSaldo(decimalFormat.format(line.getBalance()));

            tabla.add(p);

        }

        pojo.setDetalleTablaAmortizacion(tabla);

        return pojo;
    }

    public double getTerm() {
        return term;
    }

    // We don't want to set the term independently of the populateLoanTerms()  
    // method, so setTerm() should have private scope  
    private void setTerm(double term) {
        // assume periodic payments are monthly but the term is expressed in years  
        // so we need o multiple by 12 to convert years to months  

        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    // We don't want to set the rate independently of the populateLoanTerms()  
    // method, so setRate() should have private scope  
    private void setRate(double rate) {
        // assume that the periodic payment is monthly but the rate has been  
        // specified as an annual percentage rate. We need to convert the rate  
        // to fit a monthly payment schedule.  

        this.rate = rate / 12;
    }

    public double getOriginalPrincipal() {
        return originalPrincipal;
    }

    // We don't want to set the loan amount independently of the populateLoanTerms()  
    // method, so setOriginalPrincipal() should have private scope  
    private void setOriginalPrincipal(double originalPrincipal) {
        this.originalPrincipal = originalPrincipal;
    }

    public double getPayment() {
        return payment;
    }

    // We don't want to set the payment independently of the populateLoanTerms()  
    // method, so setPayment() should have private scope  
    private void setPayment(double payment) {
        this.payment = payment;
    }

    public ArrayList getAmortizationTable() {
        return amortizationTable;
    }

    private void setAmortizationTable() {
        for (int i = 1; i <= getTerm(); i++) {
            // get the balance and principal and interest paid for this period;  
            // create an entry in the amortization table  
            double newBalance = (Math.pow(1 + getRate(), i) * getOriginalPrincipal()) - (((Math.pow(1 + getRate(), i) - 1) / getRate()) * getPayment());
            double oldBalance = (Math.pow(1 + getRate(), i - 1) * getOriginalPrincipal()) - (((Math.pow(1 + getRate(), i - 1) - 1) / getRate()) * getPayment());
            double thisPrincipal = oldBalance - newBalance;
            double thisInterest = oldBalance * getRate();
            amortizationTable.add(new Amortization(i, newBalance, thisInterest, thisPrincipal));
        }
    }

    // This method populates all of the loan parameters from a single method.  
    // The loan amount and rate is required, but we need only the term or  To   
    // protect against inaccurate parameters, the payment will be computed  
    // anyway if all parameters were supplied.  
    public void populateLoanTerms(double loanAmount, double term, double rate) {
        setOriginalPrincipal(loanAmount);
        setTerm(term);
        setRate(rate);
    // compute the payment from the other given information  
        // payment = (rate * (1 + rate)^term * loanAmount)/(-1 + (1 + rate)^term)  

        // getRate() returns rate converted to appropriate periodic rate  
        double r = getRate();
        // getTerm() will return a term corrected to monthly periods  
        double t = getTerm();
        // getOriginalPrincipal returns the loan amount  
        double p = getOriginalPrincipal();
        setPayment((r * Math.pow(1 + r, t) * p) / (-1 + Math.pow(1 + r, t)));
        setAmortizationTable();
    }

    // This method displays the loan parameters and the amortization table  
    // n lines at a time.  
    public void displayMortgage(int n) throws IOException {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        System.out.println("Mortgage details");
        System.out.println("Loan amount = " + decimalFormat.format(getOriginalPrincipal()));
        System.out.println("Term = " + decimalFormat.format(getTerm() / 12) + " years");
        System.out.println("Rate = " + decimalFormat.format(getRate() * 12) + "% APR");
        System.out.println("Payment = " + decimalFormat.format(getPayment()));
        System.out.println("Amortization table");
        System.out.println("Period            Principal        Interest          Balance");
        for (int i = 0; i < amortizationTable.size(); i++) {
            Amortization line = (Amortization) amortizationTable.get(i);
            System.out.println(line.getPeriod() + "           " + decimalFormat.format(line.getPeriodPrincipal()) + "       "
                    + decimalFormat.format(line.getPeriodInterest()) + "        " + decimalFormat.format(line.getBalance()));

        }
    }

}
