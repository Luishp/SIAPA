/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siapa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "ss_menus", catalog = "siapa", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsMenus.findAll", query = "SELECT s FROM SsMenus s")})
public class SsMenus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MENU", nullable = false)
    private Integer idMenu;
    @Size(max = 100)
    @Column(name = "NOMBRE_MENU", length = 100)
    private String nombreMenu;
    @Size(max = 15)
    @Column(name = "USUARIO_REGISTRO", length = 15)
    private String usuarioRegistro;
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @Size(max = 15)
    @Column(name = "USUARIO_ULTIMAMODIFICACION", length = 15)
    private String usuarioUltimamodificacion;
    @Column(name = "FECHA_ULTIMAMODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimamodificacion;
    @JoinTable(name = "ss_menus_opciones", joinColumns = {
        @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ID_OPCION", referencedColumnName = "ID_OPCION", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<SsOpciones> ssOpcionesList;
    @JoinTable(name = "ss_roles_menu", joinColumns = {
        @JoinColumn(name = "ID_MENU", referencedColumnName = "ID_MENU", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL", nullable = false)})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SsRoles> ssRolesList;
    @OneToMany(mappedBy = "ssIdMenu", fetch = FetchType.EAGER)
    private List<SsMenus> ssMenusList;
    @JoinColumn(name = "SS__ID_MENU", referencedColumnName = "ID_MENU")
    @ManyToOne(fetch = FetchType.EAGER)
    private SsMenus ssIdMenu;

    public SsMenus() {
    }

    public SsMenus(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getNombreMenu() {
        return nombreMenu;
    }

    public void setNombreMenu(String nombreMenu) {
        this.nombreMenu = nombreMenu;
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
    public List<SsOpciones> getSsOpcionesList() {
        return ssOpcionesList;
    }

    public void setSsOpcionesList(List<SsOpciones> ssOpcionesList) {
        this.ssOpcionesList = ssOpcionesList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SsRoles> getSsRolesList() {
        return ssRolesList;
    }

    public void setSsRolesList(List<SsRoles> ssRolesList) {
        this.ssRolesList = ssRolesList;
    }

    @XmlTransient
    @JsonIgnore
    public List<SsMenus> getSsMenusList() {
        return ssMenusList;
    }

    public void setSsMenusList(List<SsMenus> ssMenusList) {
        this.ssMenusList = ssMenusList;
    }

    public SsMenus getSsIdMenu() {
        return ssIdMenu;
    }

    public void setSsIdMenu(SsMenus ssIdMenu) {
        this.ssIdMenu = ssIdMenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMenu != null ? idMenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsMenus)) {
            return false;
        }
        SsMenus other = (SsMenus) object;
        if ((this.idMenu == null && other.idMenu != null) || (this.idMenu != null && !this.idMenu.equals(other.idMenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.SsMenus[ idMenu=" + idMenu + " ]";
    }
    
}
