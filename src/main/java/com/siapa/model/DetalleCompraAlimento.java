/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Angel
 */
@Entity
@Table(name = "detalle_compra_alimento", catalog = "siapa", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetalleCompraAlimento.findAll", query = "SELECT d FROM DetalleCompraAlimento d")})
public class DetalleCompraAlimento implements Serializable {
    private static final long serialVersionUID = 1L;
   
   
    
    @Id
    @GeneratedValue
    @Column(name = "ID_DETALLE_COMPRA_ALIMENTO", nullable = true)
    private Integer idDetalleCompraAlimento;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CANT_DETALLE_COMPRA_ALIMENTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantDetalleCompraAlimento;
    @Basic(optional = false)
    @Column(name = "PRECIO_DETALLE_COMPRA_ALIMENTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioDetalleCompraAlimento;
    @Basic(optional = false)
    @Column(name = "IMPUESTO_DET_COMPRA_ALIMENTO", nullable = false, precision = 10, scale = 2)
    private BigDecimal impuestoDetCompraAlimento;
    @JoinColumn(name = "ID_ALIMENTO", referencedColumnName = "ID_ALIMENTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private Alimento idAlimento;
    @JoinColumn(name = "ID_COMPRA", referencedColumnName = "ID_COMPRA")
    @ManyToOne(fetch = FetchType.LAZY)
    private Compra idCompra;
    private transient BigDecimal sumaParcial;

    public DetalleCompraAlimento() {
    }

    public DetalleCompraAlimento(Integer idDetalleCompraAlimento) {
        this.idDetalleCompraAlimento = idDetalleCompraAlimento;
    }

    public DetalleCompraAlimento(Integer idDetalleCompraAlimento, BigDecimal cantDetalleCompraAlimento, BigDecimal precioDetalleCompraAlimento, BigDecimal impuestoDetCompraAlimento) {
        this.idDetalleCompraAlimento = idDetalleCompraAlimento;
        this.cantDetalleCompraAlimento = cantDetalleCompraAlimento;
        this.precioDetalleCompraAlimento = precioDetalleCompraAlimento;
        this.impuestoDetCompraAlimento = impuestoDetCompraAlimento;
    }

    public Integer getIdDetalleCompraAlimento() {
        return idDetalleCompraAlimento;
    }

    public void setIdDetalleCompraAlimento(Integer idDetalleCompraAlimento) {
        this.idDetalleCompraAlimento = idDetalleCompraAlimento;
    }

    public BigDecimal getCantDetalleCompraAlimento() {
        return cantDetalleCompraAlimento;
    }

    public void setCantDetalleCompraAlimento(BigDecimal cantDetalleCompraAlimento) {
        this.cantDetalleCompraAlimento = cantDetalleCompraAlimento;
    }

    public BigDecimal getPrecioDetalleCompraAlimento() {
        return precioDetalleCompraAlimento;
    }

    public void setPrecioDetalleCompraAlimento(BigDecimal precioDetalleCompraAlimento) {
        this.precioDetalleCompraAlimento = precioDetalleCompraAlimento;
    }

    public BigDecimal getImpuestoDetCompraAlimento() {
        return impuestoDetCompraAlimento;
    }

    public void setImpuestoDetCompraAlimento(BigDecimal impuestoDetCompraAlimento) {
        this.impuestoDetCompraAlimento = impuestoDetCompraAlimento;
    }

    public Alimento getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(Alimento idAlimento) {
        this.idAlimento = idAlimento;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCompraAlimento != null ? idDetalleCompraAlimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCompraAlimento)) {
            return false;
        }
        DetalleCompraAlimento other = (DetalleCompraAlimento) object;
        if ((this.idDetalleCompraAlimento == null && other.idDetalleCompraAlimento != null) || (this.idDetalleCompraAlimento != null && !this.idDetalleCompraAlimento.equals(other.idDetalleCompraAlimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siapa.model.DetalleCompraAlimento[ idDetalleCompraAlimento=" + idDetalleCompraAlimento + " ]";
    }

    public BigDecimal getSumaParcial() {
        return sumaParcial;
    }

    public void setSumaParcial(BigDecimal sumaParcial) {
        this.sumaParcial = sumaParcial;
    }
    
    
}
