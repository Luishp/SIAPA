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
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
 * @author Josue
 */
@Entity
@Table(name = "asocnatu", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asocnatu.findAll", query = "SELECT a FROM Asocnatu a")})
public class Asocnatu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idasocnatu;
    @Size(max = 100)
    @Column(name = "dui_nombre1")
    private String duiNombre1;
    @Size(max = 100)
    @Column(name = "dui_nombre2")
    private String duiNombre2;
    @Size(max = 100)
    @Column(name = "dui_nombre3")
    private String duiNombre3;
    @Size(max = 100)
    @Column(name = "dui_apellido1")
    private String duiApellido1;
    @Size(max = 100)
    @Column(name = "dui_apellido2")
    private String duiApellido2;
    @Size(max = 100)
    @Column(name = "dui_apecasada")
    private String duiApecasada;
    @Size(max = 100)
    @Column(name = "nit_nombre1")
    private String nitNombre1;
    @Size(max = 100)
    @Column(name = "nit_nombre2")
    private String nitNombre2;
    @Size(max = 100)
    @Column(name = "nit_nombre3")
    private String nitNombre3;
    @Size(max = 100)
    @Column(name = "nit_apellido1")
    private String nitApellido1;
    @Size(max = 100)
    @Column(name = "nit_apellido2")
    private String nitApellido2;
    @Size(max = 100)
    @Column(name = "nit_apecasada")
    private String nitApecasada;
    @Size(max = 100)
    @Column(name = "isss_nombre1")
    private String isssNombre1;
    @Size(max = 100)
    @Column(name = "isss_nombre2")
    private String isssNombre2;
    @Size(max = 100)
    @Column(name = "isss_nombre3")
    private String isssNombre3;
    @Size(max = 100)
    @Column(name = "isss_apellido1")
    private String isssApellido1;
    @Size(max = 100)
    @Column(name = "isss_apellido2")
    private String isssApellido2;
    @Size(max = 100)
    @Column(name = "isss_apecasada")
    private String isssApecasada;
    @Size(max = 100)
    @Column(name = "otro_nombre1")
    private String otroNombre1;
    @Size(max = 100)
    @Column(name = "otro_nombre2")
    private String otroNombre2;
    @Size(max = 100)
    @Column(name = "otro_nombre3")
    private String otroNombre3;
    @Size(max = 100)
    @Column(name = "otro_apellido1")
    private String otroApellido1;
    @Size(max = 100)
    @Column(name = "otro_apellido2")
    private String otroApellido2;
    @Size(max = 100)
    @Column(name = "otro_apecasada")
    private String otroApecasada;
    @Size(max = 10)
    @Column(name = "no_dui")
    private String noDui;
    @Column(name = "date_exped")
    @Temporal(TemporalType.DATE)
    private Date dateExped;
    @Size(max = 200)
    @Column(name = "lugar_exped")
    private String lugarExped;
    @Size(max = 17)
    @Column(name = "no_nit")
    private String noNit;
    @Size(max = 20)
    @Column(name = "no_nup")
    private String noNup;
    @Size(max = 9)
    @Column(name = "no_isss")
    private String noIsss;
    @Size(max = 25)
    @Column(name = "no_otrodoc")
    private String noOtrodoc;
    @Size(max = 160)
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "estatus_legal")
    private String estatusLegal;
    @Column(name = "date_naci")
    @Temporal(TemporalType.DATE)
    private Date dateNaci;
    @Size(max = 250)
    @Column(name = "lugar_naci")
    private String lugarNaci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "estado_fam")
    private String estadoFam;
    private Integer perdepen;
    @Size(max = 150)
    @Column(name = "nivel_estudio")
    private String nivelEstudio;
    @Column(name = "anio_gradu")
    private Integer anioGradu;
    @Size(max = 250)
    private String institucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_residencia")
    private String tipoResidencia;
    private Integer thanios;
    private Integer thmeses;
    @Size(max = 11)
    @Column(name = "tel_casa1")
    private String telCasa1;
    @Size(max = 11)
    @Column(name = "tel_casa2")
    private String telCasa2;
    @Size(max = 11)
    @Column(name = "tel_cel1")
    private String telCel1;
    @Size(max = 11)
    @Column(name = "tel_cel2")
    private String telCel2;
    @Size(max = 250)
    @Column(name = "direccion_res")
    private String direccionRes;
    @Size(max = 255)
    private String email1;
    @Size(max = 255)
    private String email2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String correpondencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "fuente_ingre")
    private String fuenteIngre;
    @Size(max = 200)
    @Column(name = "explique_foi")
    private String expliqueFoi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_empresa")
    private String tipoEmpresa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal sueldo;
    private BigDecimal otrosingre;
    @Size(max = 250)
    @Column(name = "direccion_emp")
    private String direccionEmp;
    private Integer ttanios;
    private Integer ttmeses;
    @Size(max = 11)
    @Column(name = "tel_ofis1")
    private String telOfis1;
    @Size(max = 11)
    @Column(name = "tel_ofis2")
    private String telOfis2;
    @Size(max = 11)
    @Column(name = "tel_fax1")
    private String telFax1;
    @Size(max = 11)
    @Column(name = "tel_fax2")
    private String telFax2;
    @Column(name = "no_nrc")
    private Integer noNrc;
    @Column(name = "no_nit_emp")
    private Integer noNitEmp;
    @Size(max = 3)
    @Column(name = "pp_unico")
    private String ppUnico;
    @Column(name = "no_propietarios")
    private Integer noPropietarios;
    private Integer participacion;
    @Size(max = 100)
    @Column(name = "cony_nombre1")
    private String conyNombre1;
    @Size(max = 100)
    @Column(name = "cony_nombre2")
    private String conyNombre2;
    @Size(max = 100)
    @Column(name = "cony_nombre3")
    private String conyNombre3;
    @Size(max = 100)
    @Column(name = "cony_apellido1")
    private String conyApellido1;
    @Size(max = 100)
    @Column(name = "cony_apellido2")
    private String conyApellido2;
    @Size(max = 100)
    @Column(name = "cony_apecasada")
    private String conyApecasada;
    @Size(max = 250)
    @Column(name = "cony_lugar_trab")
    private String conyLugarTrab;
    @Column(name = "cony_sueldo")
    private BigDecimal conySueldo;
    @Size(max = 11)
    @Column(name = "cony_tel_ofis")
    private String conyTelOfis;
    @Size(max = 11)
    @Column(name = "cony_tel_cel")
    private String conyTelCel;
    @Size(max = 3)
    @Column(name = "ref_familiar")
    private String refFamiliar;
    @Size(max = 50)
    @Column(name = "nombre_empresa")
    private String nombreEmpresaAso;
    @Size(max = 45)
    @Column(name = "fuente_ingreso")
    private String fuentesIngresoAso;
    @Size(max = 45)
    @Column(name = "tiempo_trabajo")
    private String tiempoTrabajoAso;
    @JoinColumn(name = "idasocrefer", referencedColumnName = "idasociados")
    @ManyToOne(fetch = FetchType.LAZY)
    private Asociados idasocrefer;
    @OneToMany(mappedBy = "idasocnatu", fetch = FetchType.LAZY)
    private Set<Asociados> asociadosList;

    public Asocnatu() {
    }

    public Asocnatu(Integer idasocnatu) {
        this.idasocnatu = idasocnatu;
    }

    public Asocnatu(Integer idasocnatu, String estatusLegal, String sexo, String estadoFam, String tipoResidencia, String correpondencia, String fuenteIngre, String tipoEmpresa) {
        this.idasocnatu = idasocnatu;
        this.estatusLegal = estatusLegal;
        this.sexo = sexo;
        this.estadoFam = estadoFam;
        this.tipoResidencia = tipoResidencia;
        this.correpondencia = correpondencia;
        this.fuenteIngre = fuenteIngre;
        this.tipoEmpresa = tipoEmpresa;
    }

    public Integer getIdasocnatu() {
        return idasocnatu;
    }

    public void setIdasocnatu(Integer idasocnatu) {
        this.idasocnatu = idasocnatu;
    }

    public String getDuiNombre1() {
        return duiNombre1;
    }

    public void setDuiNombre1(String duiNombre1) {
        this.duiNombre1 = duiNombre1;
    }

    public String getDuiNombre2() {
        return duiNombre2;
    }

    public void setDuiNombre2(String duiNombre2) {
        this.duiNombre2 = duiNombre2;
    }

    public String getDuiNombre3() {
        return duiNombre3;
    }

    public void setDuiNombre3(String duiNombre3) {
        this.duiNombre3 = duiNombre3;
    }

    public String getDuiApellido1() {
        return duiApellido1;
    }

    public void setDuiApellido1(String duiApellido1) {
        this.duiApellido1 = duiApellido1;
    }

    public String getDuiApellido2() {
        return duiApellido2;
    }

    public void setDuiApellido2(String duiApellido2) {
        this.duiApellido2 = duiApellido2;
    }

    public String getDuiApecasada() {
        return duiApecasada;
    }

    public void setDuiApecasada(String duiApecasada) {
        this.duiApecasada = duiApecasada;
    }

    public String getNitNombre1() {
        return nitNombre1;
    }

    public void setNitNombre1(String nitNombre1) {
        this.nitNombre1 = nitNombre1;
    }

    public String getNitNombre2() {
        return nitNombre2;
    }

    public void setNitNombre2(String nitNombre2) {
        this.nitNombre2 = nitNombre2;
    }

    public String getNitNombre3() {
        return nitNombre3;
    }

    public void setNitNombre3(String nitNombre3) {
        this.nitNombre3 = nitNombre3;
    }

    public String getNitApellido1() {
        return nitApellido1;
    }

    public void setNitApellido1(String nitApellido1) {
        this.nitApellido1 = nitApellido1;
    }

    public String getNitApellido2() {
        return nitApellido2;
    }

    public void setNitApellido2(String nitApellido2) {
        this.nitApellido2 = nitApellido2;
    }

    public String getNitApecasada() {
        return nitApecasada;
    }

    public void setNitApecasada(String nitApecasada) {
        this.nitApecasada = nitApecasada;
    }

    public String getIsssNombre1() {
        return isssNombre1;
    }

    public void setIsssNombre1(String isssNombre1) {
        this.isssNombre1 = isssNombre1;
    }

    public String getIsssNombre2() {
        return isssNombre2;
    }

    public void setIsssNombre2(String isssNombre2) {
        this.isssNombre2 = isssNombre2;
    }

    public String getIsssNombre3() {
        return isssNombre3;
    }

    public void setIsssNombre3(String isssNombre3) {
        this.isssNombre3 = isssNombre3;
    }

    public String getIsssApellido1() {
        return isssApellido1;
    }

    public void setIsssApellido1(String isssApellido1) {
        this.isssApellido1 = isssApellido1;
    }

    public String getIsssApellido2() {
        return isssApellido2;
    }

    public void setIsssApellido2(String isssApellido2) {
        this.isssApellido2 = isssApellido2;
    }

    public String getIsssApecasada() {
        return isssApecasada;
    }

    public void setIsssApecasada(String isssApecasada) {
        this.isssApecasada = isssApecasada;
    }

    public String getOtroNombre1() {
        return otroNombre1;
    }

    public void setOtroNombre1(String otroNombre1) {
        this.otroNombre1 = otroNombre1;
    }

    public String getOtroNombre2() {
        return otroNombre2;
    }

    public void setOtroNombre2(String otroNombre2) {
        this.otroNombre2 = otroNombre2;
    }

    public String getOtroNombre3() {
        return otroNombre3;
    }

    public void setOtroNombre3(String otroNombre3) {
        this.otroNombre3 = otroNombre3;
    }

    public String getOtroApellido1() {
        return otroApellido1;
    }

    public void setOtroApellido1(String otroApellido1) {
        this.otroApellido1 = otroApellido1;
    }

    public String getOtroApellido2() {
        return otroApellido2;
    }

    public void setOtroApellido2(String otroApellido2) {
        this.otroApellido2 = otroApellido2;
    }

    public String getOtroApecasada() {
        return otroApecasada;
    }

    public void setOtroApecasada(String otroApecasada) {
        this.otroApecasada = otroApecasada;
    }

    public String getNoDui() {
        return noDui;
    }

    public void setNoDui(String noDui) {
        this.noDui = noDui;
    }

    public Date getDateExped() {
        return dateExped;
    }

    public void setDateExped(Date dateExped) {
        this.dateExped = dateExped;
    }

    public String getLugarExped() {
        return lugarExped;
    }

    public void setLugarExped(String lugarExped) {
        this.lugarExped = lugarExped;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNoNup() {
        return noNup;
    }

    public void setNoNup(String noNup) {
        this.noNup = noNup;
    }

    public String getNoIsss() {
        return noIsss;
    }

    public void setNoIsss(String noIsss) {
        this.noIsss = noIsss;
    }

    public String getNoOtrodoc() {
        return noOtrodoc;
    }

    public void setNoOtrodoc(String noOtrodoc) {
        this.noOtrodoc = noOtrodoc;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getEstatusLegal() {
        return estatusLegal;
    }

    public void setEstatusLegal(String estatusLegal) {
        this.estatusLegal = estatusLegal;
    }

    public Date getDateNaci() {
        return dateNaci;
    }

    public void setDateNaci(Date dateNaci) {
        this.dateNaci = dateNaci;
    }

    public String getLugarNaci() {
        return lugarNaci;
    }

    public void setLugarNaci(String lugarNaci) {
        this.lugarNaci = lugarNaci;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoFam() {
        return estadoFam;
    }

    public void setEstadoFam(String estadoFam) {
        this.estadoFam = estadoFam;
    }

    public Integer getPerdepen() {
        return perdepen;
    }

    public void setPerdepen(Integer perdepen) {
        this.perdepen = perdepen;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public Integer getAnioGradu() {
        return anioGradu;
    }

    public void setAnioGradu(Integer anioGradu) {
        this.anioGradu = anioGradu;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public Integer getThanios() {
        return thanios;
    }

    public void setThanios(Integer thanios) {
        this.thanios = thanios;
    }

    public Integer getThmeses() {
        return thmeses;
    }

    public void setThmeses(Integer thmeses) {
        this.thmeses = thmeses;
    }

    public String getTelCasa1() {
        return telCasa1;
    }

    public void setTelCasa1(String telCasa1) {
        this.telCasa1 = telCasa1;
    }

    public String getTelCasa2() {
        return telCasa2;
    }

    public void setTelCasa2(String telCasa2) {
        this.telCasa2 = telCasa2;
    }

    public String getTelCel1() {
        return telCel1;
    }

    public void setTelCel1(String telCel1) {
        this.telCel1 = telCel1;
    }

    public String getTelCel2() {
        return telCel2;
    }

    public void setTelCel2(String telCel2) {
        this.telCel2 = telCel2;
    }

    public String getDireccionRes() {
        return direccionRes;
    }

    public void setDireccionRes(String direccionRes) {
        this.direccionRes = direccionRes;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getCorrepondencia() {
        return correpondencia;
    }

    public void setCorrepondencia(String correpondencia) {
        this.correpondencia = correpondencia;
    }

    public String getFuenteIngre() {
        return fuenteIngre;
    }

    public void setFuenteIngre(String fuenteIngre) {
        this.fuenteIngre = fuenteIngre;
    }

    public String getExpliqueFoi() {
        return expliqueFoi;
    }

    public void setExpliqueFoi(String expliqueFoi) {
        this.expliqueFoi = expliqueFoi;
    }

    public String getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(String tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public BigDecimal getOtrosingre() {
        return otrosingre;
    }

    public void setOtrosingre(BigDecimal otrosingre) {
        this.otrosingre = otrosingre;
    }

    public String getDireccionEmp() {
        return direccionEmp;
    }

    public void setDireccionEmp(String direccionEmp) {
        this.direccionEmp = direccionEmp;
    }

    public Integer getTtanios() {
        return ttanios;
    }

    public void setTtanios(Integer ttanios) {
        this.ttanios = ttanios;
    }

    public Integer getTtmeses() {
        return ttmeses;
    }

    public void setTtmeses(Integer ttmeses) {
        this.ttmeses = ttmeses;
    }

    public String getTelOfis1() {
        return telOfis1;
    }

    public void setTelOfis1(String telOfis1) {
        this.telOfis1 = telOfis1;
    }

    public String getTelOfis2() {
        return telOfis2;
    }

    public void setTelOfis2(String telOfis2) {
        this.telOfis2 = telOfis2;
    }

    public String getTelFax1() {
        return telFax1;
    }

    public void setTelFax1(String telFax1) {
        this.telFax1 = telFax1;
    }

    public String getTelFax2() {
        return telFax2;
    }

    public void setTelFax2(String telFax2) {
        this.telFax2 = telFax2;
    }

    public Integer getNoNrc() {
        return noNrc;
    }

    public void setNoNrc(Integer noNrc) {
        this.noNrc = noNrc;
    }

    public Integer getNoNitEmp() {
        return noNitEmp;
    }

    public void setNoNitEmp(Integer noNitEmp) {
        this.noNitEmp = noNitEmp;
    }

    public String getPpUnico() {
        return ppUnico;
    }

    public void setPpUnico(String ppUnico) {
        this.ppUnico = ppUnico;
    }

    public Integer getNoPropietarios() {
        return noPropietarios;
    }

    public void setNoPropietarios(Integer noPropietarios) {
        this.noPropietarios = noPropietarios;
    }

    public Integer getParticipacion() {
        return participacion;
    }

    public void setParticipacion(Integer participacion) {
        this.participacion = participacion;
    }

    public String getConyNombre1() {
        return conyNombre1;
    }

    public void setConyNombre1(String conyNombre1) {
        this.conyNombre1 = conyNombre1;
    }

    public String getConyNombre2() {
        return conyNombre2;
    }

    public void setConyNombre2(String conyNombre2) {
        this.conyNombre2 = conyNombre2;
    }

    public String getConyNombre3() {
        return conyNombre3;
    }

    public void setConyNombre3(String conyNombre3) {
        this.conyNombre3 = conyNombre3;
    }

    public String getConyApellido1() {
        return conyApellido1;
    }

    public void setConyApellido1(String conyApellido1) {
        this.conyApellido1 = conyApellido1;
    }

    public String getConyApellido2() {
        return conyApellido2;
    }

    public void setConyApellido2(String conyApellido2) {
        this.conyApellido2 = conyApellido2;
    }

    public String getConyApecasada() {
        return conyApecasada;
    }

    public void setConyApecasada(String conyApecasada) {
        this.conyApecasada = conyApecasada;
    }

    public String getConyLugarTrab() {
        return conyLugarTrab;
    }

    public void setConyLugarTrab(String conyLugarTrab) {
        this.conyLugarTrab = conyLugarTrab;
    }

    public BigDecimal getConySueldo() {
        return conySueldo;
    }

    public void setConySueldo(BigDecimal conySueldo) {
        this.conySueldo = conySueldo;
    }

    public String getConyTelOfis() {
        return conyTelOfis;
    }

    public void setConyTelOfis(String conyTelOfis) {
        this.conyTelOfis = conyTelOfis;
    }

    public String getConyTelCel() {
        return conyTelCel;
    }

    public void setConyTelCel(String conyTelCel) {
        this.conyTelCel = conyTelCel;
    }

    public String getRefFamiliar() {
        return refFamiliar;
    }

    public void setRefFamiliar(String refFamiliar) {
        this.refFamiliar = refFamiliar;
    }

    public Asociados getIdasocrefer() {
        return idasocrefer;
    }

    public void setIdasocrefer(Asociados idasocrefer) {
        this.idasocrefer = idasocrefer;
    }

    @XmlTransient
    @JsonIgnore
    public Set<Asociados> getAsociadosList() {
        return asociadosList;
    }

    public void setAsociadosList(Set<Asociados> asociadosList) {
        this.asociadosList = asociadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idasocnatu != null ? idasocnatu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asocnatu)) {
            return false;
        }
        Asocnatu other = (Asocnatu) object;
        if ((this.idasocnatu == null && other.idasocnatu != null) || (this.idasocnatu != null && !this.idasocnatu.equals(other.idasocnatu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Asocnatu[ idasocnatu=" + idasocnatu + " ]";
    }
    
    public String getNombreCompleto() {
        String nombreCompleto = "";

        if (duiNombre1 != null && !duiNombre1.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + duiNombre1 + " ";
        }

        if (duiNombre2 != null && !duiNombre2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + duiNombre2;
        }

        if (duiApellido1 != null && !duiApellido1.trim().equalsIgnoreCase("")) {

            if (nombreCompleto != null && !nombreCompleto.trim().equalsIgnoreCase("")) {
                nombreCompleto = nombreCompleto + ", ";
            }
            nombreCompleto = nombreCompleto + duiApellido1 + " ";
        }

        if (duiApellido2 != null && !duiApellido2.trim().equalsIgnoreCase("")) {
            nombreCompleto = nombreCompleto + duiApellido2;
        }

        return nombreCompleto;
    }

    public String getNombreEmpresaAso() {
        return nombreEmpresaAso;
    }

    public void setNombreEmpresaAso(String nombreEmpresaAso) {
        this.nombreEmpresaAso = nombreEmpresaAso;
    }

    public String getFuentesIngresoAso() {
        return fuentesIngresoAso;
    }

    public void setFuentesIngresoAso(String fuentesIngresoAso) {
        this.fuentesIngresoAso = fuentesIngresoAso;
    }

    public String getTiempoTrabajoAso() {
        return tiempoTrabajoAso;
    }

    public void setTiempoTrabajoAso(String tiempoTrabajoAso) {
        this.tiempoTrabajoAso = tiempoTrabajoAso;
    }
    
}
