package com.siapa.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
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
    @NamedQuery(name = "Desembolso.findAll", query = "SELECT d FROM Desembolso d")})
public class Desembolso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "DESEMBOLSO_ID", nullable = false)
    private Integer desembolsoId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DESEMBOLSO_CAPITALMASINTERES", precision = 10, scale = 2,columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal desembolsoCapitalmasinteres;
    @Column(name = "DESEMBOLSO_SEGUROS", precision = 10, scale = 2,columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal desembolsoSeguros;
    @Column(name = "DESEMBOLSO_EXTRAPRIMA", precision = 10, scale = 2,columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal desembolsoExtraprima;
    @Column(name = "DESEMBOLSO_APORTCION", precision = 10, scale = 2,columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal desembolsoAportcion;
    @Column(name = "DESEMBOLSO_AHORROPROGRAMADO", precision = 10, scale = 2,columnDefinition="Decimal(10,2) default '0.00'")
    private BigDecimal desembolsoAhorroprogramado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESEMBOLSO_TASAEFECTIVA", nullable = false, precision = 4, scale = 4)
    private BigDecimal desembolsoTasaefectiva;
    @Column(name = "DESEMBOLSO_INTERESDIFERIDOS", precision = 10, scale = 2)
    private BigDecimal desembolsoInteresdiferidos;
    @Column(name = "DESEMBOLSO_CAPITALDIFERIDO", precision = 10, scale = 2)
    private BigDecimal desembolsoCapitaldiferido;
    @Column(name = "DESEMBOLSO_COSTASPROCESALES", precision = 10, scale = 2)
    private BigDecimal desembolsoCostasprocesales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESEMBOLSO_FECHAPRIMERPAGO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desembolsoFechaprimerpago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DESEMBOLSO_FECHAVENCIMIENTO", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date desembolsoFechavencimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DESEMBOLSO_DIRECCIONCOBRO", nullable = false, length = 500)
    private String desembolsoDireccioncobro;
    @Column(name = "DESEMBOLSO_COMPLETO")
    private Boolean desembolsoCompleto;
    @Column(name = "DESEMBOLSO_LISTO")
    private Boolean desembolsoListo;
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
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Prestamo> prestamoList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Ahorro> ahorroList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Deducciones> deduccionesList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Efectivo> efectivoList;
    @JoinColumn(name = "SUCURSAL_ID", referencedColumnName = "SUCURSAL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sucursal sucursalId;
    @JoinColumn(name = "RESOLUCION_ID", referencedColumnName = "RESOLUCION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Resolucion resolucionId;
    @JoinColumn(name = "PRESTAMO_ID", referencedColumnName = "PRESTAMO_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Prestamo prestamoId;
    @JoinColumn(name = "PAGADURIA_ID", referencedColumnName = "PAGADURIA_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pagaduria pagaduriaId;
    @JoinColumn(name = "CC_ID", referencedColumnName = "CC_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Comprobantecaja ccId;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Cheque> chequeList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Abonoprestamo> abonoprestamoList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Comprobantecaja> comprobantecajaList;
    @OneToMany(mappedBy = "desembolsoId", fetch = FetchType.LAZY)
    private List<Resolucion> resolucionList;

    public Desembolso() {
    }

    public Desembolso(Integer desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    public Desembolso(Integer desembolsoId, BigDecimal desembolsoAportcion, BigDecimal desembolsoTasaefectiva, Date desembolsoFechaprimerpago, Date desembolsoFechavencimiento, String desembolsoDireccioncobro, String usuarioRegistro, Date fechaRegistro) {
        this.desembolsoId = desembolsoId;
        this.desembolsoAportcion = desembolsoAportcion;
        this.desembolsoTasaefectiva = desembolsoTasaefectiva;
        this.desembolsoFechaprimerpago = desembolsoFechaprimerpago;
        this.desembolsoFechavencimiento = desembolsoFechavencimiento;
        this.desembolsoDireccioncobro = desembolsoDireccioncobro;
        this.usuarioRegistro = usuarioRegistro;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getDesembolsoId() {
        return desembolsoId;
    }

    public void setDesembolsoId(Integer desembolsoId) {
        this.desembolsoId = desembolsoId;
    }

    public BigDecimal getDesembolsoCapitalmasinteres() {
        return desembolsoCapitalmasinteres;
    }

    public void setDesembolsoCapitalmasinteres(BigDecimal desembolsoCapitalmasinteres) {
        this.desembolsoCapitalmasinteres = desembolsoCapitalmasinteres;
    }
   
    public BigDecimal getDesembolsoSeguros() {
        return desembolsoSeguros;
    }

    public void setDesembolsoSeguros(BigDecimal desembolsoSeguros) {
        this.desembolsoSeguros = desembolsoSeguros;
    }

    public BigDecimal getDesembolsoExtraprima() {
        return desembolsoExtraprima;
    }

    public void setDesembolsoExtraprima(BigDecimal desembolsoExtraprima) {
        this.desembolsoExtraprima = desembolsoExtraprima;
    }

    public BigDecimal getDesembolsoAportcion() {
        return desembolsoAportcion;
    }

    public void setDesembolsoAportcion(BigDecimal desembolsoAportcion) {
        this.desembolsoAportcion = desembolsoAportcion;
    }

    public BigDecimal getDesembolsoAhorroprogramado() {
        return desembolsoAhorroprogramado;
    }

    public void setDesembolsoAhorroprogramado(BigDecimal desembolsoAhorroprogramado) {
        this.desembolsoAhorroprogramado = desembolsoAhorroprogramado;
    }

    public BigDecimal getDesembolsoTasaefectiva() {
        return desembolsoTasaefectiva;
    }

    public void setDesembolsoTasaefectiva(BigDecimal desembolsoTasaefectiva) {
        this.desembolsoTasaefectiva = desembolsoTasaefectiva;
    }

    public BigDecimal getDesembolsoInteresdiferidos() {
        return desembolsoInteresdiferidos;
    }

    public void setDesembolsoInteresdiferidos(BigDecimal desembolsoInteresdiferidos) {
        this.desembolsoInteresdiferidos = desembolsoInteresdiferidos;
    }

    public BigDecimal getDesembolsoCapitaldiferido() {
        return desembolsoCapitaldiferido;
    }

    public void setDesembolsoCapitaldiferido(BigDecimal desembolsoCapitaldiferido) {
        this.desembolsoCapitaldiferido = desembolsoCapitaldiferido;
    }

    public BigDecimal getDesembolsoCostasprocesales() {
        return desembolsoCostasprocesales;
    }

    public void setDesembolsoCostasprocesales(BigDecimal desembolsoCostasprocesales) {
        this.desembolsoCostasprocesales = desembolsoCostasprocesales;
    }

    public Date getDesembolsoFechaprimerpago() {
        return desembolsoFechaprimerpago;
    }

    public void setDesembolsoFechaprimerpago(Date desembolsoFechaprimerpago) {
        this.desembolsoFechaprimerpago = desembolsoFechaprimerpago;
    }

    public Date getDesembolsoFechavencimiento() {
        return desembolsoFechavencimiento;
    }

    public void setDesembolsoFechavencimiento(Date desembolsoFechavencimiento) {
        this.desembolsoFechavencimiento = desembolsoFechavencimiento;
    }

    public String getDesembolsoDireccioncobro() {
        return desembolsoDireccioncobro;
    }

    public void setDesembolsoDireccioncobro(String desembolsoDireccioncobro) {
        this.desembolsoDireccioncobro = desembolsoDireccioncobro;
    }

    public Boolean getDesembolsoCompleto() {
        return desembolsoCompleto;
    }

    public void setDesembolsoCompleto(Boolean desembolsoCompleto) {
        this.desembolsoCompleto = desembolsoCompleto;
    }

    public Boolean getDesembolsoListo() {
        return desembolsoListo;
    }

    public void setDesembolsoListo(Boolean desembolsoListo) {
        this.desembolsoListo = desembolsoListo;
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
    public List<Prestamo> getPrestamoList() {
        return prestamoList;
    }

    public void setPrestamoList(List<Prestamo> prestamoList) {
        this.prestamoList = prestamoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Ahorro> getAhorroList() {
        return ahorroList;
    }

    public void setAhorroList(List<Ahorro> ahorroList) {
        this.ahorroList = ahorroList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Deducciones> getDeduccionesList() {
        return deduccionesList;
    }

    public void setDeduccionesList(List<Deducciones> deduccionesList) {
        this.deduccionesList = deduccionesList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Efectivo> getEfectivoList() {
        return efectivoList;
    }

    public void setEfectivoList(List<Efectivo> efectivoList) {
        this.efectivoList = efectivoList;
    }

    public Sucursal getSucursalId() {
        return sucursalId;
    }

    public void setSucursalId(Sucursal sucursalId) {
        this.sucursalId = sucursalId;
    }

    public Resolucion getResolucionId() {
        return resolucionId;
    }

    public void setResolucionId(Resolucion resolucionId) {
        this.resolucionId = resolucionId;
    }

    public Prestamo getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(Prestamo prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Pagaduria getPagaduriaId() {
        return pagaduriaId;
    }

    public void setPagaduriaId(Pagaduria pagaduriaId) {
        this.pagaduriaId = pagaduriaId;
    }

    public Comprobantecaja getCcId() {
        return ccId;
    }

    public void setCcId(Comprobantecaja ccId) {
        this.ccId = ccId;
    }

    @XmlTransient
    @JsonIgnore
    public List<Cheque> getChequeList() {
        return chequeList;
    }

    public void setChequeList(List<Cheque> chequeList) {
        this.chequeList = chequeList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Abonoprestamo> getAbonoprestamoList() {
        return abonoprestamoList;
    }

    public void setAbonoprestamoList(List<Abonoprestamo> abonoprestamoList) {
        this.abonoprestamoList = abonoprestamoList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Comprobantecaja> getComprobantecajaList() {
        return comprobantecajaList;
    }

    public void setComprobantecajaList(List<Comprobantecaja> comprobantecajaList) {
        this.comprobantecajaList = comprobantecajaList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Resolucion> getResolucionList() {
        return resolucionList;
    }

    public void setResolucionList(List<Resolucion> resolucionList) {
        this.resolucionList = resolucionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (desembolsoId != null ? desembolsoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desembolso)) {
            return false;
        }
        Desembolso other = (Desembolso) object;
        if ((this.desembolsoId == null && other.desembolsoId != null) || (this.desembolsoId != null && !this.desembolsoId.equals(other.desembolsoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Desembolso[ desembolsoId=" + desembolsoId + " ]";
    }

}
