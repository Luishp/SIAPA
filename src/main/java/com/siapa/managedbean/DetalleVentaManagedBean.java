/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siapa.managedbean;

import com.siapa.managedbean.generic.GenericManagedBean;
import com.siapa.model.Categorias;
import com.siapa.model.Cliente;
import com.siapa.model.Descuento;
import com.siapa.model.DetalleVenta;
import com.siapa.model.Producto;
import com.siapa.service.ClienteService;
import com.siapa.service.DescuentoService;
import com.siapa.service.DetalleVentaService;
import com.siapa.service.ProductoService;
import com.siapa.service.generic.GenericService;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
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
@Named("detalleVentaManagedBean")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class DetalleVentaManagedBean extends GenericManagedBean<DetalleVenta, Integer> {

    @Autowired
    @Qualifier(value = "clienteService")
    private ClienteService clienteService;
    @Autowired
    @Qualifier(value = "detalleVentaService")
    private DetalleVentaService detalleVentaService;
    @Autowired
    @Qualifier(value = "productoService")
    private ProductoService productoService;
    @Autowired
    @Qualifier(value = "descuentoService")
    private DescuentoService descuentoService;
    
    private Cliente cliente;
    private List<Cliente> clienteList;
    private List<DetalleVenta> detalleVentaList;
    private List<Descuento> descuentoList;
    private DetalleVenta detalleVenta;
    private Descuento descuento;
    private Producto producto;
    private BigDecimal sumaTotal = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;

    @PostConstruct
    public void init() {
        clienteList = clienteService.findAll();
        descuentoList = productoService.getProducto();
        detalleVentaList = detalleVentaService.getDetalleVentaAll();
       
    }

   
    
    public void prepareCreateDetalle() {
        try {
            detalleVenta = new DetalleVenta();
        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
    }
    
    public void cargarOutput(){
        System.out.println("...-..-.-."+getDescuento());
    }

    public Descuento desc(){
        Categorias idCategorias=cliente.getIdCategorias();
        descuento = descuentoService.findById(idCategorias.getIdCategorias());
        return descuento;
    }
    
      public void toCreateVenta() {
        try {
            FacesContext contex = FacesContext.getCurrentInstance();

            setSelected(new DetalleVenta());
            contex.getExternalContext().redirect("/siapa/views/detalleCompraAlimento/Create.xhtml");
        } catch (IOException ex) {
            //   log.error("Error al rederigir a la pagina de asesoria", null, ex);
        }
    }
    
    public BigDecimal calcularTotal() {
        BigDecimal total1 = BigDecimal.ZERO;
        BigDecimal imp = BigDecimal.ZERO;
        BigDecimal descuentototal;
        if(descuento !=null ){
           double des= descuento.getPorcentajeDescuento().doubleValue();
           double porce=des/100;
           BigDecimal des1=new BigDecimal(porce);
           descuentototal= descuento.getIdProducto().getPrecioProducto().multiply(detalleVenta.getCantidadDetalleVenta()).multiply(des1);
           total1=descuento.getIdProducto().getPrecioProducto().multiply(detalleVenta.getCantidadDetalleVenta()).subtract(descuentototal);
        }
        return total1;
    }
    
    @Override
    public GenericService<DetalleVenta, Integer> getService() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LazyDataModel<DetalleVenta> getNewLazyModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getSumaTotal() {
        return sumaTotal;
    }

    public void setSumaTotal(BigDecimal sumaTotal) {
        this.sumaTotal = sumaTotal;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

  

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
         total = calcularTotal();
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DescuentoService getDescuentoService() {
        return descuentoService;
    }

    public void setDescuentoService(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }
    
    
    
}
