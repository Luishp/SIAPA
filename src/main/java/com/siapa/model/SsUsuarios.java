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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "ss_usuarios", catalog = "siacofinges", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsUsuarios.findAll", query = "SELECT s FROM SsUsuarios s")})
public class SsUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;
    @Size(max = 15)
    @Column(name = "CODIGO_USUARIO", length = 15)
    private String codigoUsuario;
    @Size(max = 100)
    @Column(name = "NOMBRE_USUARIO", length = 100)
    private String nombreUsuario;
    @Size(max = 20)
    @Column(length = 20)
    private String telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(length = 100)
    private String email;
    @Size(max = 100)
    @Column(length = 100)
    private String cargo;
    @Size(max = 150)
    @Column(length = 150)
    private String descripcion;
    @Size(max = 1)
    @Column(length = 1)
    private String bloqueado;
    @Size(max = 100)
    @Column(length = 100)
    private String clave;
    @Column(name = "INTENTOS_ACCESO_FALLIDOS")
    private Short intentosAccesoFallidos;
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
    @Column(name = "FECHA_ULTIMO_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoAcceso;
    @Size(max = 100)
    @Column(name = "DIRECCION_ACCESO", length = 100)
    private String direccionAcceso;
    @Size(max = 300)
    @Column(name = "DETALLE_ULTIMO_ACCESO", length = 300)
    private String detalleUltimoAcceso;
    @Column(name = "FECHA_CAMBIO_CLAVE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCambioClave;
    @Size(max = 2)
    @Column(name = "CODIGO_SUCURSAL", length = 2)
    private String codigoSucursal;
    @ManyToMany(mappedBy = "ssUsuariosList", fetch = FetchType.LAZY)
    private List<SsRoles> ssRolesList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<SsHistoricoClaves> ssHistoricoClavesList;

    public SsUsuarios() {
    }

    public SsUsuarios(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(String bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Short getIntentosAccesoFallidos() {
        return intentosAccesoFallidos;
    }

    public void setIntentosAccesoFallidos(Short intentosAccesoFallidos) {
        this.intentosAccesoFallidos = intentosAccesoFallidos;
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

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    public String getDireccionAcceso() {
        return direccionAcceso;
    }

    public void setDireccionAcceso(String direccionAcceso) {
        this.direccionAcceso = direccionAcceso;
    }

    public String getDetalleUltimoAcceso() {
        return detalleUltimoAcceso;
    }

    public void setDetalleUltimoAcceso(String detalleUltimoAcceso) {
        this.detalleUltimoAcceso = detalleUltimoAcceso;
    }

    public Date getFechaCambioClave() {
        return fechaCambioClave;
    }

    public void setFechaCambioClave(Date fechaCambioClave) {
        this.fechaCambioClave = fechaCambioClave;
    }

    public String getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(String codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
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
    public List<SsHistoricoClaves> getSsHistoricoClavesList() {
        return ssHistoricoClavesList;
    }

    public void setSsHistoricoClavesList(List<SsHistoricoClaves> ssHistoricoClavesList) {
        this.ssHistoricoClavesList = ssHistoricoClavesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsUsuarios)) {
            return false;
        }
        SsUsuarios other = (SsUsuarios) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siacofinges.model.SsUsuarios[ idUsuario=" + idUsuario + " ]";
    }

}
