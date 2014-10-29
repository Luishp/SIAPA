/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author marlon.andrade
 */
@Entity
@Table(catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Analisiscodeudor.findAll", query = "SELECT a FROM Analisiscodeudor a")})
public class Analisiscodeudor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "AC_ID", nullable = false)
    private Integer acId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AC_FECHACREACION", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date acFechacreacion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AC_GASTOVIDA", precision = 10, scale = 2)
    private BigDecimal acGastovida;
    @Column(name = "AC_PAGODEUDAACTUAL", precision = 10, scale = 2)
    private BigDecimal acPagodeudaactual;
    @Column(name = "AC_PAGOVIVIENDA", precision = 10, scale = 2)
    private BigDecimal acPagovivienda;
    @Column(name = "AC_DESCUENTOLEY", precision = 10, scale = 2)
    private BigDecimal acDescuentoley;
    @Column(name = "AC_TOTALEGRESO", precision = 10, scale = 2)
    private BigDecimal acTotalegreso;
    @Column(name = "AC_TOTALINGRESO", precision = 10, scale = 2)
    private BigDecimal acTotalingreso;
    @Column(name = "AC_RENTANETA", precision = 10, scale = 2)
    private BigDecimal acRentaneta;
    @Column(name = "AC_TOTALLIQUIDO", precision = 10, scale = 2)
    private BigDecimal acTotalliquido;
    @Column(name = "AC_APORTACIONAHORROACTIVO", precision = 10, scale = 2)
    private BigDecimal acAportacionahorroactivo;
    @Column(name = "AC_OTROACTIVO", precision = 10, scale = 2)
    private BigDecimal acOtroactivo;
    @Column(name = "AC_VALORPROPIEDAD", precision = 10, scale = 2)
    private BigDecimal acValorpropiedad;
    @Column(name = "AC_VALORVEHICULO", precision = 10, scale = 2)
    private BigDecimal acValorvehiculo;
    @Column(name = "AC_TOTALACTIVO", precision = 10, scale = 2)
    private BigDecimal acTotalactivo;
    @Column(name = "AC_PRESTAMO", precision = 10, scale = 2)
    private BigDecimal acPrestamo;
    @Column(name = "AC_TARJETACREDITO", precision = 10, scale = 2)
    private BigDecimal acTarjetacredito;
    @Column(name = "AC_DEUDACOMERCIAL", precision = 10, scale = 2)
    private BigDecimal acDeudacomercial;
    @Column(name = "AC_DEUDAPERSONAL", precision = 10, scale = 2)
    private BigDecimal acDeudapersonal;
    @Column(name = "AC_TOTALPASIVO", precision = 10, scale = 2)
    private BigDecimal acTotalpasivo;
    @Column(name = "AC_CAPITALACTUAL", precision = 10, scale = 2)
    private BigDecimal acCapitalactual;
    @Column(name = "AC_EXAMENMEDICO")
    private Boolean acExamenmedico;
    @Column(name = "AC_POSEECOBERTURA")
    private Boolean acPoseecobertura;
    @Column(name = "AC_DECLARAPROBLEMASALUD")
    private Boolean acDeclaraproblemasalud;
    @Size(max = 500)
    @Column(name = "AC_OBSERVACION", length = 500)
    private String acObservacion;
    @Size(max = 500)
    @Column(name = "AC_CONCLUSION", length = 500)
    private String acConclusion;
    @Size(max = 500)
    @Column(name = "AC_RECOMENDACION", length = 500)
    private String acRecomendacion;
    @Column(name = "AC_COMPLETO")
    private Boolean acCompleto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String activo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "USUARIO_REGISTRO", nullable = false, length = 15)
    private String usuarioRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_REGISTRO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 15)
    @Column(name = "USUARIO_ULTIMAMODIFICACION", length = 15)
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @OneToMany(mappedBy = "acId", fetch = FetchType.LAZY)
    private List<Descuento> descuentoList;
    @JoinColumn(name = "RGC_ID", referencedColumnName = "RGC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Registrogarantiacodeudor rgcId;
    @OneToMany(mappedBy = "acId", fetch = FetchType.LAZY)
    private List<Deuda> deudaList;
    @OneToMany(mappedBy = "acId", fetch = FetchType.LAZY)
    private List<Consultaburocredito> consultaburocreditoList;

    public Analisiscodeudor() {
    }

    public Analisiscodeudor(Integer acId) {
        this.acId = acId;
    }

    public Analisiscodeudor(Integer acId, Date acFechacreacion, String activo, String usuarioRegistro, Date fechaRegistro) {
        this.acId = acId;
        this.acFechacreacion = acFechacreacion;
        this.activo = activo;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getAcId() {
        return acId;
    }

    public void setAcId(Integer acId) {
        this.acId = acId;
    }

    public Date getAcFechacreacion() {
        return acFechacreacion;
    }

    public void setAcFechacreacion(Date acFechacreacion) {
        this.acFechacreacion = acFechacreacion;
    }

    public BigDecimal getAcGastovida() {
        return acGastovida;
    }

    public void setAcGastovida(BigDecimal acGastovida) {
        this.acGastovida = acGastovida;
    }

    public BigDecimal getAcPagodeudaactual() {
        return acPagodeudaactual;
    }

    public void setAcPagodeudaactual(BigDecimal acPagodeudaactual) {
        this.acPagodeudaactual = acPagodeudaactual;
    }

    public BigDecimal getAcPagovivienda() {
        return acPagovivienda;
    }

    public void setAcPagovivienda(BigDecimal acPagovivienda) {
        this.acPagovivienda = acPagovivienda;
    }

    public BigDecimal getAcDescuentoley() {
        return acDescuentoley;
    }

    public void setAcDescuentoley(BigDecimal acDescuentoley) {
        this.acDescuentoley = acDescuentoley;
    }

    public BigDecimal getAcTotalegreso() {
        return acTotalegreso;
    }

    public void setAcTotalegreso(BigDecimal acTotalegreso) {
        this.acTotalegreso = acTotalegreso;
    }

    public BigDecimal getAcTotalingreso() {
        return acTotalingreso;
    }

    public void setAcTotalingreso(BigDecimal acTotalingreso) {
        this.acTotalingreso = acTotalingreso;
    }

    public BigDecimal getAcRentaneta() {
        return acRentaneta;
    }

    public void setAcRentaneta(BigDecimal acRentaneta) {
        this.acRentaneta = acRentaneta;
    }

    public BigDecimal getAcTotalliquido() {
        return acTotalliquido;
    }

    public void setAcTotalliquido(BigDecimal acTotalliquido) {
        this.acTotalliquido = acTotalliquido;
    }

    public BigDecimal getAcAportacionahorroactivo() {
        return acAportacionahorroactivo;
    }

    public void setAcAportacionahorroactivo(BigDecimal acAportacionahorroactivo) {
        this.acAportacionahorroactivo = acAportacionahorroactivo;
    }

    public BigDecimal getAcOtroactivo() {
        return acOtroactivo;
    }

    public void setAcOtroactivo(BigDecimal acOtroactivo) {
        this.acOtroactivo = acOtroactivo;
    }

    public BigDecimal getAcValorpropiedad() {
        return acValorpropiedad;
    }

    public void setAcValorpropiedad(BigDecimal acValorpropiedad) {
        this.acValorpropiedad = acValorpropiedad;
    }

    public BigDecimal getAcValorvehiculo() {
        return acValorvehiculo;
    }

    public void setAcValorvehiculo(BigDecimal acValorvehiculo) {
        this.acValorvehiculo = acValorvehiculo;
    }

    public BigDecimal getAcTotalactivo() {
        return acTotalactivo;
    }

    public void setAcTotalactivo(BigDecimal acTotalactivo) {
        this.acTotalactivo = acTotalactivo;
    }

    public BigDecimal getAcPrestamo() {
        return acPrestamo;
    }

    public void setAcPrestamo(BigDecimal acPrestamo) {
        this.acPrestamo = acPrestamo;
    }

    public BigDecimal getAcTarjetacredito() {
        return acTarjetacredito;
    }

    public void setAcTarjetacredito(BigDecimal acTarjetacredito) {
        this.acTarjetacredito = acTarjetacredito;
    }

    public BigDecimal getAcDeudacomercial() {
        return acDeudacomercial;
    }

    public void setAcDeudacomercial(BigDecimal acDeudacomercial) {
        this.acDeudacomercial = acDeudacomercial;
    }

    public BigDecimal getAcDeudapersonal() {
        return acDeudapersonal;
    }

    public void setAcDeudapersonal(BigDecimal acDeudapersonal) {
        this.acDeudapersonal = acDeudapersonal;
    }

    public BigDecimal getAcTotalpasivo() {
        return acTotalpasivo;
    }

    public void setAcTotalpasivo(BigDecimal acTotalpasivo) {
        this.acTotalpasivo = acTotalpasivo;
    }

    public BigDecimal getAcCapitalactual() {
        return acCapitalactual;
    }

    public void setAcCapitalactual(BigDecimal acCapitalactual) {
        this.acCapitalactual = acCapitalactual;
    }

    public Boolean getAcExamenmedico() {
        return acExamenmedico;
    }

    public void setAcExamenmedico(Boolean acExamenmedico) {
        this.acExamenmedico = acExamenmedico;
    }

    public Boolean getAcPoseecobertura() {
        return acPoseecobertura;
    }

    public void setAcPoseecobertura(Boolean acPoseecobertura) {
        this.acPoseecobertura = acPoseecobertura;
    }

    public Boolean getAcDeclaraproblemasalud() {
        return acDeclaraproblemasalud;
    }

    public void setAcDeclaraproblemasalud(Boolean acDeclaraproblemasalud) {
        this.acDeclaraproblemasalud = acDeclaraproblemasalud;
    }

    public String getAcObservacion() {
        return acObservacion;
    }

    public void setAcObservacion(String acObservacion) {
        this.acObservacion = acObservacion;
    }

    public String getAcConclusion() {
        return acConclusion;
    }

    public void setAcConclusion(String acConclusion) {
        this.acConclusion = acConclusion;
    }

    public String getAcRecomendacion() {
        return acRecomendacion;
    }

    public void setAcRecomendacion(String acRecomendacion) {
        this.acRecomendacion = acRecomendacion;
    }

    public Boolean getAcCompleto() {
        return acCompleto;
    }

    public void setAcCompleto(Boolean acCompleto) {
        this.acCompleto = acCompleto;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getUsuarioRegistro() {
        return usuarioRegistro;
    }

    public void setUsuarioRegistro(String usuarioRegistro) {
        this.usuarioRegistro = usuarioRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUsuarioUltimamodificacion() {
        return usuarioUltimamodificacion;
    }

    public void setUsuarioUltimamodificacion(String usuarioUltimamodificacion) {
        this.usuarioUltimamodificacion = usuarioUltimamodificacion;
    }

    public Date getFechaUltimamodificacion() {
        return fechaUltimamodificacion;
    }

    public void setFechaUltimamodificacion(Date fechaUltimamodificacion) {
        this.fechaUltimamodificacion = fechaUltimamodificacion;
    }

    @XmlTransient
    @JsonIgnore
    public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }

    public Registrogarantiacodeudor getRgcId() {
        return rgcId;
    }

    public void setRgcId(Registrogarantiacodeudor rgcId) {
        this.rgcId = rgcId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Deuda> getDeudaList() {
        return deudaList;
    }

    public void setDeudaList(List<Deuda> deudaList) {
        this.deudaList = deudaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Consultaburocredito> getConsultaburocreditoList() {
        return consultaburocreditoList;
    }

    public void setConsultaburocreditoList(List<Consultaburocredito> consultaburocreditoList) {
        this.consultaburocreditoList = consultaburocreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acId != null ? acId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analisiscodeudor)) {
            return false;
        }
        Analisiscodeudor other = (Analisiscodeudor) object;
        if ((this.acId == null && other.acId != null) || (this.acId != null && !this.acId.equals(other.acId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Analisiscodeudor[ acId=" + acId + " ]";
    }
    
}
