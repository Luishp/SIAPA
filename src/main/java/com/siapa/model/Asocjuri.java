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
import javax.persistence.Lob;
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
@Table(name = "asocjuri", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asocjuri.findAll", query = "SELECT a FROM Asocjuri a")})
public class Asocjuri implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idasocjuri;
    @Lob
    private byte[] foto;
    @Lob
    private byte[] firma;
    @Size(max = 100)
    private String nombre1;
    @Size(max = 100)
    private String nombre2;
    @Size(max = 100)
    private String nombre3;
    @Size(max = 100)
    private String apellido1;
    @Size(max = 100)
    private String apellido2;
    @Size(max = 100)
    private String apellido3;
    @Size(max = 100)
    private String apecasada;
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
    @Column(name = "dui_apellido3")
    private String duiApellido3;
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
    @Column(name = "nit_apellido3")
    private String nitApellido3;
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
    @Column(name = "isss_apellido3")
    private String isssApellido3;
    @Size(max = 100)
    @Column(name = "isss_apecasada")
    private String isssApecasada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String sexo;
    @Column(name = "date_naci")
    @Temporal(TemporalType.DATE)
    private Date dateNaci;
    @Size(max = 180)
    private String lugarnaci;
    @Size(max = 255)
    private String direccion;
    @Size(max = 255)
    private String departamento;
    @Size(max = 255)
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String estadocivil;
    @Size(max = 255)
    private String conyugue;
    @Size(max = 25)
    @Column(name = "dui_conyugue")
    private String duiConyugue;
    @Size(max = 25)
    @Column(name = "nit_conyugue")
    private String nitConyugue;
    @Size(max = 150)
    @Column(name = "trab_lugar_conyugue")
    private String trabLugarConyugue;
    @Size(max = 11)
    @Column(name = "tel_ofis_conyugue")
    private String telOfisConyugue;
    @Size(max = 25)
    @Column(name = "no_dui")
    private String noDui;
    @Size(max = 25)
    @Column(name = "no_nit")
    private String noNit;
    @Size(max = 25)
    @Column(name = "no_isss")
    private String noIsss;
    @Column(name = "date_exped")
    @Temporal(TemporalType.DATE)
    private Date dateExped;
    @Size(max = 200)
    @Column(name = "lugar_exped")
    private String lugarExped;
    @Size(max = 160)
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "tipo_residencia")
    private String tipoResidencia;
    private Integer thanios;
    private Integer thmeses;
    private Integer perdepen;
    @Size(max = 11)
    @Column(name = "tel_casa1")
    private String telCasa1;
    @Size(max = 11)
    @Column(name = "tel_casa2")
    private String telCasa2;
    @Size(max = 11)
    @Column(name = "tel_casa3")
    private String telCasa3;
    @Size(max = 11)
    @Column(name = "num_cel1")
    private String numCel1;
    @Size(max = 11)
    @Column(name = "num_cel2")
    private String numCel2;
    @Size(max = 11)
    @Column(name = "num_cel3")
    private String numCel3;
    @Size(max = 11)
    @Column(name = "tel_ofis1")
    private String telOfis1;
    @Size(max = 11)
    @Column(name = "tel_ofis2")
    private String telOfis2;
    @Size(max = 11)
    @Column(name = "tel_ofis3")
    private String telOfis3;
    @Size(max = 11)
    @Column(name = "tel_fax1")
    private String telFax1;
    @Size(max = 11)
    @Column(name = "tel_fax2")
    private String telFax2;
    @Size(max = 255)
    private String email1;
    @Size(max = 255)
    private String email2;
    @Size(max = 255)
    private String email3;
    private Integer idinstituciones;
    @Size(max = 150)
    @Column(name = "trab_lugar")
    private String trabLugar;
    @Size(max = 255)
    @Column(name = "trab_direc")
    private String trabDirec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    private String correpondencia;
    private Integer idprofesiones;
    private Integer idocupaciones;
    @Size(max = 255)
    @Column(name = "nombre_jefe")
    private String nombreJefe;
    private Integer ttanios;
    private Integer ttmeses;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal sueldo;
    private BigDecimal otrosingre;
    private BigDecimal egresos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "emple_acofinges")
    private String empleAcofinges;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    private String directivo;
    private Integer iddirectivos;
    private Integer numact;
    @Column(name = "date_aprob")
    @Temporal(TemporalType.DATE)
    private Date dateAprob;
    @Size(max = 255)
    private String asocrefi1;
    @Size(max = 255)
    private String asocrefi2;
    @Size(max = 2)
    private String tpcuota;
    private Integer ext;
    @OneToMany(mappedBy = "idasocjuri", fetch = FetchType.LAZY)
    private Set<Asociados> asociadosList;

    public Asocjuri() {
    }

    public Asocjuri(Integer idasocjuri) {
        this.idasocjuri = idasocjuri;
    }

    public Asocjuri(Integer idasocjuri, String sexo, String estadocivil, String tipoResidencia, String correpondencia, String empleAcofinges, String directivo) {
        this.idasocjuri = idasocjuri;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.tipoResidencia = tipoResidencia;
        this.correpondencia = correpondencia;
        this.empleAcofinges = empleAcofinges;
        this.directivo = directivo;
    }

    public Integer getIdasocjuri() {
        return idasocjuri;
    }

    public void setIdasocjuri(Integer idasocjuri) {
        this.idasocjuri = idasocjuri;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getFirma() {
        return firma;
    }

    public void setFirma(byte[] firma) {
        this.firma = firma;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getNombre3() {
        return nombre3;
    }

    public void setNombre3(String nombre3) {
        this.nombre3 = nombre3;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getApellido3() {
        return apellido3;
    }

    public void setApellido3(String apellido3) {
        this.apellido3 = apellido3;
    }

    public String getApecasada() {
        return apecasada;
    }

    public void setApecasada(String apecasada) {
        this.apecasada = apecasada;
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

    public String getDuiApellido3() {
        return duiApellido3;
    }

    public void setDuiApellido3(String duiApellido3) {
        this.duiApellido3 = duiApellido3;
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

    public String getNitApellido3() {
        return nitApellido3;
    }

    public void setNitApellido3(String nitApellido3) {
        this.nitApellido3 = nitApellido3;
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

    public String getIsssApellido3() {
        return isssApellido3;
    }

    public void setIsssApellido3(String isssApellido3) {
        this.isssApellido3 = isssApellido3;
    }

    public String getIsssApecasada() {
        return isssApecasada;
    }

    public void setIsssApecasada(String isssApecasada) {
        this.isssApecasada = isssApecasada;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDateNaci() {
        return dateNaci;
    }

    public void setDateNaci(Date dateNaci) {
        this.dateNaci = dateNaci;
    }

    public String getLugarnaci() {
        return lugarnaci;
    }

    public void setLugarnaci(String lugarnaci) {
        this.lugarnaci = lugarnaci;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getConyugue() {
        return conyugue;
    }

    public void setConyugue(String conyugue) {
        this.conyugue = conyugue;
    }

    public String getDuiConyugue() {
        return duiConyugue;
    }

    public void setDuiConyugue(String duiConyugue) {
        this.duiConyugue = duiConyugue;
    }

    public String getNitConyugue() {
        return nitConyugue;
    }

    public void setNitConyugue(String nitConyugue) {
        this.nitConyugue = nitConyugue;
    }

    public String getTrabLugarConyugue() {
        return trabLugarConyugue;
    }

    public void setTrabLugarConyugue(String trabLugarConyugue) {
        this.trabLugarConyugue = trabLugarConyugue;
    }

    public String getTelOfisConyugue() {
        return telOfisConyugue;
    }

    public void setTelOfisConyugue(String telOfisConyugue) {
        this.telOfisConyugue = telOfisConyugue;
    }

    public String getNoDui() {
        return noDui;
    }

    public void setNoDui(String noDui) {
        this.noDui = noDui;
    }

    public String getNoNit() {
        return noNit;
    }

    public void setNoNit(String noNit) {
        this.noNit = noNit;
    }

    public String getNoIsss() {
        return noIsss;
    }

    public void setNoIsss(String noIsss) {
        this.noIsss = noIsss;
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
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

    public Integer getPerdepen() {
        return perdepen;
    }

    public void setPerdepen(Integer perdepen) {
        this.perdepen = perdepen;
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

    public String getTelCasa3() {
        return telCasa3;
    }

    public void setTelCasa3(String telCasa3) {
        this.telCasa3 = telCasa3;
    }

    public String getNumCel1() {
        return numCel1;
    }

    public void setNumCel1(String numCel1) {
        this.numCel1 = numCel1;
    }

    public String getNumCel2() {
        return numCel2;
    }

    public void setNumCel2(String numCel2) {
        this.numCel2 = numCel2;
    }

    public String getNumCel3() {
        return numCel3;
    }

    public void setNumCel3(String numCel3) {
        this.numCel3 = numCel3;
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

    public String getTelOfis3() {
        return telOfis3;
    }

    public void setTelOfis3(String telOfis3) {
        this.telOfis3 = telOfis3;
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

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public Integer getIdinstituciones() {
        return idinstituciones;
    }

    public void setIdinstituciones(Integer idinstituciones) {
        this.idinstituciones = idinstituciones;
    }

    public String getTrabLugar() {
        return trabLugar;
    }

    public void setTrabLugar(String trabLugar) {
        this.trabLugar = trabLugar;
    }

    public String getTrabDirec() {
        return trabDirec;
    }

    public void setTrabDirec(String trabDirec) {
        this.trabDirec = trabDirec;
    }

    public String getCorrepondencia() {
        return correpondencia;
    }

    public void setCorrepondencia(String correpondencia) {
        this.correpondencia = correpondencia;
    }

    public Integer getIdprofesiones() {
        return idprofesiones;
    }

    public void setIdprofesiones(Integer idprofesiones) {
        this.idprofesiones = idprofesiones;
    }

    public Integer getIdocupaciones() {
        return idocupaciones;
    }

    public void setIdocupaciones(Integer idocupaciones) {
        this.idocupaciones = idocupaciones;
    }

    public String getNombreJefe() {
        return nombreJefe;
    }

    public void setNombreJefe(String nombreJefe) {
        this.nombreJefe = nombreJefe;
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

    public BigDecimal getEgresos() {
        return egresos;
    }

    public void setEgresos(BigDecimal egresos) {
        this.egresos = egresos;
    }

    public String getEmpleAcofinges() {
        return empleAcofinges;
    }

    public void setEmpleAcofinges(String empleAcofinges) {
        this.empleAcofinges = empleAcofinges;
    }

    public String getDirectivo() {
        return directivo;
    }

    public void setDirectivo(String directivo) {
        this.directivo = directivo;
    }

    public Integer getIddirectivos() {
        return iddirectivos;
    }

    public void setIddirectivos(Integer iddirectivos) {
        this.iddirectivos = iddirectivos;
    }

    public Integer getNumact() {
        return numact;
    }

    public void setNumact(Integer numact) {
        this.numact = numact;
    }

    public Date getDateAprob() {
        return dateAprob;
    }

    public void setDateAprob(Date dateAprob) {
        this.dateAprob = dateAprob;
    }

    public String getAsocrefi1() {
        return asocrefi1;
    }

    public void setAsocrefi1(String asocrefi1) {
        this.asocrefi1 = asocrefi1;
    }

    public String getAsocrefi2() {
        return asocrefi2;
    }

    public void setAsocrefi2(String asocrefi2) {
        this.asocrefi2 = asocrefi2;
    }

    public String getTpcuota() {
        return tpcuota;
    }

    public void setTpcuota(String tpcuota) {
        this.tpcuota = tpcuota;
    }

    public Integer getExt() {
        return ext;
    }

    public void setExt(Integer ext) {
        this.ext = ext;
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
        hash += (idasocjuri != null ? idasocjuri.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asocjuri)) {
            return false;
        }
        Asocjuri other = (Asocjuri) object;
        if ((this.idasocjuri == null && other.idasocjuri != null) || (this.idasocjuri != null && !this.idasocjuri.equals(other.idasocjuri))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.Asocjuri[ idasocjuri=" + idasocjuri + " ]";
    }
    
}
