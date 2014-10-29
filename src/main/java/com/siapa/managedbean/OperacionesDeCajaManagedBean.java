package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.managedbean.lazymodel.DesembolsoDeEfectivoLazyModel;
import com.siapa.model.Efectivo;
import com.siapa.model.Prestamo;
import com.siapa.model.managedbean.crud.util.JsfUtil;
import com.siapa.service.DesembolsoDeEfectivoService;
import com.siapa.service.PrestamoService;
import com.siapa.service.generic.GenericService;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Fm
 */
@Named("operacionesDeCajaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class OperacionesDeCajaManagedBean extends GenericManagedBean<Efectivo, Integer> {

    @Autowired
    @Qualifier(value = "desembolsoDeEfectivoService")
    private DesembolsoDeEfectivoService desembolsoDeEfectivoService;

    @Autowired
    @Qualifier(value = "prestamoService")
    private PrestamoService prestamoService;

    private List<Efectivo> desembolsoEfectivoNoEntregadoList;
    private Efectivo efectivoSelected;

    private List<Prestamo> prestamosActivosItems;
    private Prestamo prestamoSelected;

    //variables para pago
    //antes del pago
    private Float saldoActual;

    private Float interesNormal_ant;
    private Float interesMoratorio_ant;

    private Float aportaciones_ant;
    private Float ahorro_ant;

    private Float costasProcesales_ant;
    private Float interesDiferido_ant;
    private Float capitalDiferido_ant;

    //despues del pago
    private Float nuevoSaldo;
    private Float pagoCapital;

    private Float interesNormal_des;
    private Float interesMoratorio_des;

    private Float aportaciones_des;
    private Float ahorro_des;

    private Float costasProcesales_des;
    private Float interesDiferido_des;
    private Float capitalDiferido_des;

    @PostConstruct
    public void init() {
        actualizarEfectivoItems();
        actualizarPrestamosActivosItems();
    }

    public OperacionesDeCajaManagedBean() {
    }

    @Override
    public GenericService<Efectivo, Integer> getService() {
        return desembolsoDeEfectivoService;
    }

    @Override
    public LazyDataModel<Efectivo> getNewLazyModel() {
        return new DesembolsoDeEfectivoLazyModel(desembolsoDeEfectivoService);
    }

    public void saveDesembolso(ActionEvent event) {
        if (getUsuario() != null) {
            String msg = "Registro de efectivo realizado con exito";
            Date hoy = new Date();

            try {
                //Guardar desembolso
                efectivoSelected.setEfectivoEntregado(Boolean.TRUE);
                efectivoSelected.setUsuarioUltimamodificacion(getUsuario());
                efectivoSelected.setFechaUltimamodificacion(hoy);
                desembolsoDeEfectivoService.merge(efectivoSelected);

                actualizarEfectivoItems();
                JsfUtil.addSuccessMessage(msg);

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo modificar el desembolso");
            }

        }
    }

    public void preparePago(ActionEvent event) {
        if (getUsuario() != null) {

            try {
                prestamoSelected = prestamoService.fillPrestamo(prestamoSelected);

            } catch (Exception e) {
                JsfUtil.addErrorMessage("No se pudo cargar el prestamo");
            }

        }
    }

    public void actualizarEfectivoItems() {
        desembolsoEfectivoNoEntregadoList = desembolsoDeEfectivoService.efectivoPendienteDeEntrega();
    }

    public void actualizarPrestamosActivosItems() {
        prestamosActivosItems = prestamoService.findAll();
    }

    public List<Efectivo> getDesembolsoEfectivoNoEntregadoList() {
        return desembolsoEfectivoNoEntregadoList;
    }

    public void setDesembolsoEfectivoNoEntregadoList(List<Efectivo> desembolsoEfectivoNoEntregadoList) {
        this.desembolsoEfectivoNoEntregadoList = desembolsoEfectivoNoEntregadoList;
    }

    public Efectivo getEfectivoSelected() {
        return efectivoSelected;
    }

    public void setEfectivoSelected(Efectivo efectivoSelected) {
        this.efectivoSelected = efectivoSelected;
    }

    public List<Prestamo> getPrestamosActivosItems() {
        return prestamosActivosItems;
    }

    public void setPrestamosActivosItems(List<Prestamo> prestamosActivosItems) {
        this.prestamosActivosItems = prestamosActivosItems;
    }

    public Prestamo getPrestamoSelected() {
        return prestamoSelected;
    }

    public void setPrestamoSelected(Prestamo prestamoSelected) {
        this.prestamoSelected = prestamoSelected;
    }

    public Float getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(Float saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Float getInteresNormal_ant() {
        return interesNormal_ant;
    }

    public void setInteresNormal_ant(Float interesNormal_ant) {
        this.interesNormal_ant = interesNormal_ant;
    }

    public Float getInteresMoratorio_ant() {
        return interesMoratorio_ant;
    }

    public void setInteresMoratorio_ant(Float interesMoratorio_ant) {
        this.interesMoratorio_ant = interesMoratorio_ant;
    }

    public Float getAportaciones_ant() {
        return aportaciones_ant;
    }

    public void setAportaciones_ant(Float aportaciones_ant) {
        this.aportaciones_ant = aportaciones_ant;
    }

    public Float getAhorro_ant() {
        return ahorro_ant;
    }

    public void setAhorro_ant(Float ahorro_ant) {
        this.ahorro_ant = ahorro_ant;
    }

    public Float getCostasProcesales_ant() {
        return costasProcesales_ant;
    }

    public void setCostasProcesales_ant(Float costasProcesales_ant) {
        this.costasProcesales_ant = costasProcesales_ant;
    }

    public Float getInteresDiferido_ant() {
        return interesDiferido_ant;
    }

    public void setInteresDiferido_ant(Float interesDiferido_ant) {
        this.interesDiferido_ant = interesDiferido_ant;
    }

    public Float getCapitalDiferido_ant() {
        return capitalDiferido_ant;
    }

    public void setCapitalDiferido_ant(Float capitalDiferido_ant) {
        this.capitalDiferido_ant = capitalDiferido_ant;
    }

    public Float getNuevoSaldo() {
        return nuevoSaldo;
    }

    public void setNuevoSaldo(Float nuevoSaldo) {
        this.nuevoSaldo = nuevoSaldo;
    }

    public Float getPagoCapital() {
        return pagoCapital;
    }

    public void setPagoCapital(Float pagoCapital) {
        this.pagoCapital = pagoCapital;
    }

    public Float getInteresNormal_des() {
        return interesNormal_des;
    }

    public void setInteresNormal_des(Float interesNormal_des) {
        this.interesNormal_des = interesNormal_des;
    }

    public Float getInteresMoratorio_des() {
        return interesMoratorio_des;
    }

    public void setInteresMoratorio_des(Float interesMoratorio_des) {
        this.interesMoratorio_des = interesMoratorio_des;
    }

    public Float getAportaciones_des() {
        return aportaciones_des;
    }

    public void setAportaciones_des(Float aportaciones_des) {
        this.aportaciones_des = aportaciones_des;
    }

    public Float getAhorro_des() {
        return ahorro_des;
    }

    public void setAhorro_des(Float ahorro_des) {
        this.ahorro_des = ahorro_des;
    }

    public Float getCostasProcesales_des() {
        return costasProcesales_des;
    }

    public void setCostasProcesales_des(Float costasProcesales_des) {
        this.costasProcesales_des = costasProcesales_des;
    }

    public Float getInteresDiferido_des() {
        return interesDiferido_des;
    }

    public void setInteresDiferido_des(Float interesDiferido_des) {
        this.interesDiferido_des = interesDiferido_des;
    }

    public Float getCapitalDiferido_des() {
        return capitalDiferido_des;
    }

    public void setCapitalDiferido_des(Float capitalDiferido_des) {
        this.capitalDiferido_des = capitalDiferido_des;
    }

}
