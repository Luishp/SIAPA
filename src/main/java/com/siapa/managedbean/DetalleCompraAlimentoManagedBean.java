/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Alimento;
import com.siapa.model.Compra;
import com.siapa.model.DetalleCompraAlimento;
import com.siapa.model.Proveedor;
import com.siapa.model.TipoAlimento;
import com.siapa.pojos.TablaDetalleAlimentoPojo;
import com.siapa.service.AlimentoService;
import com.siapa.service.CompraService;
import com.siapa.service.DetalleCompraAlimentoService;
import com.siapa.service.ProveedorService;
import com.siapa.service.TipoAlimentoService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import static java.lang.Math.round;
import static java.lang.Math.round;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ComponentSystemEvent;
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
    private DetalleCompraAlimento detalleCompraAlimento;
    private Proveedor proveedor;
    private Alimento alimento;

    private BigDecimal total;
    private BigDecimal cantidad;
    private BigDecimal precio;
    private BigDecimal sumaTotal = BigDecimal.ZERO;

    TablaDetalleAlimentoPojo tablaDetalleAlimentoPojo;
    private List<TablaDetalleAlimentoPojo> tablaDetalleAlimentoPojoList;

    @PostConstruct
    public void init() {
        tipoAlimento = new TipoAlimento();
        detalleCompraAlimentoList = detalleCompraAlimentoService.getDetalleCompraAlimentoAll();
        proveedorList = proveedorService.getProveedor();
        alimentoList = alimentoService.getTypeFood();
        tipoAlimentoList = tipoAlimentoService.findAll();
        alimentoByIdList = new ArrayList<Alimento>();
        detalleCompraAlimento = new DetalleCompraAlimento();
        tablaDetalleAlimentoPojo = new TablaDetalleAlimentoPojo();
        tablaDetalleAlimentoPojoList = new ArrayList<TablaDetalleAlimentoPojo>();
    }

    public void cargarComboAlimentoMarca() {
        alimentoByIdList = alimentoService.getByIdTypeFood(tipoAlimento.getIdTipoAlimento());

    }

    @Override
    public GenericService<DetalleCompraAlimento, Integer> getService() {
        return detalleCompraAlimentoService;
    }

    public BigDecimal calcularTotal() {
        BigDecimal total1 = BigDecimal.ZERO;
        BigDecimal imp = BigDecimal.ZERO;
        if (detalleCompraAlimento.getCantDetalleCompraAlimento() != null) {
            if (detalleCompraAlimento.getPrecioDetalleCompraAlimento() != null) {
                if (detalleCompraAlimento.getImpuestoDetCompraAlimento() != null) {

                    total1 = total1.add((detalleCompraAlimento.getCantDetalleCompraAlimento().multiply(detalleCompraAlimento.getPrecioDetalleCompraAlimento())).multiply(detalleCompraAlimento.getImpuestoDetCompraAlimento().divide(new BigDecimal(100)).add(new BigDecimal(1))));
                }
            }
        }
        return total1;
    }
//    
//    public DetalleCompraAlimento todetalleCompra() {
//        detalleCompraAlimento = new DetalleCompraAlimento();
//
//        return detalleCompraAlimento;
//    }

    public void cargar() {
        try {

            tablaDetalleAlimentoPojo = new TablaDetalleAlimentoPojo();

            tablaDetalleAlimentoPojo.setIdTipoAlimento(getTipoAlimento().getIdTipoAlimento());
            tablaDetalleAlimentoPojo.setIdAlimento(getAlimento().getIdAlimento());

            tablaDetalleAlimentoPojo.setImpuesto(getDetalleCompraAlimento().getImpuestoDetCompraAlimento());
            tablaDetalleAlimentoPojo.setMarca(getAlimento().getMarcaAlimento());
            tablaDetalleAlimentoPojo.setTipoAlimento(getTipoAlimento().getNombreTipoAlimento());
            tablaDetalleAlimentoPojo.setPrecio(getDetalleCompraAlimento().getPrecioDetalleCompraAlimento().setScale(2, BigDecimal.ROUND_HALF_UP));
            tablaDetalleAlimentoPojo.setCantidad(getDetalleCompraAlimento().getCantDetalleCompraAlimento());
            tablaDetalleAlimentoPojo.setTotal(getTotal().setScale(2, BigDecimal.ROUND_HALF_UP));/**/

            sumaTotal = sumaTotal.add(getTotal().setScale(2, BigDecimal.ROUND_HALF_UP));

            tablaDetalleAlimentoPojoList.add(tablaDetalleAlimentoPojo);
        } catch (Exception e) {
        }
    }

    @Override
    public void saveNew(ActionEvent event) {

        try {
           if(getSumaTotal().compareTo(BigDecimal.ZERO) > 0){
            
            Compra newcompra = new Compra();
            newcompra.setIdProveedor(getProveedor());
            newcompra.setFechaHoraCompra(new Date());
            newcompra.setUsuarioCompra(getUsuario());
            newcompra.setTotalCompra((BigDecimal) ((getSumaTotal() != null) ? getSumaTotal() : 0.0));
 //               compraService.save(newcompra);

            for (TablaDetalleAlimentoPojo l : tablaDetalleAlimentoPojoList) {

//                DetalleCompraAlimento newCompraAlimento = getDetalleCompraAlimento();
//                newCompraAlimento.setIdCompra(newcompra);
//                newCompraAlimento.setIdAlimento(getAlimento());
//                detalleCompraAlimentoService.save(newCompraAlimento);
//
//                Alimento newAlimento = getAlimento();
//                BigDecimal cactual = newAlimento.getExistenciaAlimento();
//                BigDecimal compra = newCompraAlimento.getCantDetalleCompraAlimento();
//                BigDecimal existencia = cactual.add(compra);
//
//                newAlimento.setExistenciaAlimento(existencia);
//                alimentoService.merge(newAlimento);
            }
           }
        } catch (Exception e) {
        }

    }

    public void toCreateCompra() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            setSelected(new DetalleCompraAlimento());
            contex.getExternalContext().redirect("/siapa/views/detalleCompraAlimento/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
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

    public BigDecimal getTotal() {
        total = calcularTotal();
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public DetalleCompraAlimento getDetalleCompraAlimento() {
        return detalleCompraAlimento;
    }

    public void setDetalleCompraAlimento(DetalleCompraAlimento detalleCompraAlimento) {
        this.detalleCompraAlimento = detalleCompraAlimento;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public TablaDetalleAlimentoPojo getTablaDetalleAlimentoPojo() {
        return tablaDetalleAlimentoPojo;
    }

    public void setTablaDetalleAlimentoPojo(TablaDetalleAlimentoPojo tablaDetalleAlimentoPojo) {
        this.tablaDetalleAlimentoPojo = tablaDetalleAlimentoPojo;
    }

    public List<TablaDetalleAlimentoPojo> getTablaDetalleAlimentoPojoList() {
        return tablaDetalleAlimentoPojoList;
    }

    public void setTablaDetalleAlimentoPojoList(List<TablaDetalleAlimentoPojo> tablaDetalleAlimentoPojoList) {
        this.tablaDetalleAlimentoPojoList = tablaDetalleAlimentoPojoList;
    }

    public BigDecimal getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(BigDecimal sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

}
