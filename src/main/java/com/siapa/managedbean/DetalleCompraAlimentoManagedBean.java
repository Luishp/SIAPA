/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Alimento;
import com.siapa.model.DetalleCompraAlimento;
import com.siapa.model.Proveedor;
import com.siapa.model.TipoAlimento;
import com.siapa.service.AlimentoService;
import com.siapa.service.CompraService;
import com.siapa.service.DetalleCompraAlimentoService;
import com.siapa.service.ProveedorService;
import com.siapa.service.TipoAlimentoService;
import com.siapa.service.generic.GenericService;
import java.util.ArrayList;
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
 * @author Joao
 */
@Named("detalleCompraAlimentoManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DetalleCompraAlimentoManagedBean extends GenericManagedBean<DetalleCompraAlimento, Integer> {

    @Autowired
    @Qualifier(value = "detalleCompraAlimentoService")
    private DetalleCompraAlimentoService detalleCompraAlimentoService;

    @Autowired
    @Qualifier(value = "compraService")
    private CompraService compraService;

    @Autowired
    @Qualifier(value = "alimentoService")
    private AlimentoService alimentoService;

    @Autowired
    @Qualifier(value = "proveedorService")
    private ProveedorService proveedorService;
   
    @Autowired
    @Qualifier(value = "tipoAlimentoService")
    private TipoAlimentoService tipoAlimentoService;

    private List<Proveedor> proveedorList;
    private List<DetalleCompraAlimento> detalleCompraAlimentoList;
    private List<Alimento> alimentoList;
    private List<Alimento> alimentoByIdList;
    private List<TipoAlimento> tipoAlimentoList; 

    private TipoAlimento tipoAlimento;
    private Proveedor proveedor;
    private Alimento alimento;

    @PostConstruct
    public void init() {
        tipoAlimento=new TipoAlimento();
        detalleCompraAlimentoList = detalleCompraAlimentoService.getDetalleCompraAlimentoAll();
        proveedorList = proveedorService.getProveedor();
        alimentoList = alimentoService.getTypeFood();
        tipoAlimentoList = tipoAlimentoService.findAll();
        alimentoByIdList = new ArrayList<Alimento>();
    }
    
    
    public void cargarComboAlimentoMarca(){
         alimentoByIdList = alimentoService.getByIdTypeFood(tipoAlimento.getIdTipoAlimento());
    
    }

    @Override
    public GenericService<DetalleCompraAlimento, Integer> getService() {
        return detalleCompraAlimentoService;
    }

    @Override
    public LazyDataModel<DetalleCompraAlimento> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Proveedor> getProveedorList() {
        return proveedorList;
    }

    public void setProveedorList(List<Proveedor> proveedorList) {
        this.proveedorList = proveedorList;
    }

    public List<DetalleCompraAlimento> getDetalleCompraAlimentoList() {
        return detalleCompraAlimentoList;
    }

    public void setDetalleCompraAlimentoList(List<DetalleCompraAlimento> detalleCompraAlimentoList) {
        this.detalleCompraAlimentoList = detalleCompraAlimentoList;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Alimento> getAlimentoList() {
        return alimentoList;
    }

    public void setAlimentoList(List<Alimento> alimentoList) {
        this.alimentoList = alimentoList;
    }

    public Alimento getAlimento() {
        return alimento;
    }

    public void setAlimento(Alimento alimento) {
        this.alimento = alimento;
    }

    public TipoAlimento getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(TipoAlimento tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public List<TipoAlimento> getTipoAlimentoList() {
        return tipoAlimentoList;
    }

    public void setTipoAlimentoList(List<TipoAlimento> tipoAlimentoList) {
        this.tipoAlimentoList = tipoAlimentoList;
    }

    public List<Alimento> getAlimentoByIdList() {
        return alimentoByIdList;
    }

    public void setAlimentoByIdList(List<Alimento> alimentoByIdList) {
        this.alimentoByIdList = alimentoByIdList;
    }

    
    
}
