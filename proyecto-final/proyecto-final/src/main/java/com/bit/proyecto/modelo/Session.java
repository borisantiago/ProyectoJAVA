package com.bit.proyecto.modelo;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "session")
public class Session implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long codigoSession;

    @Basic(optional = false)
    private String usuarioSession;

    @Basic(optional = false)
    private String passwordSession;

    private String tokenSession;

    @Basic(optional = false)
    private Date fechaOperacion;

    private Date fechaSolicitudToken;

    private String ipSession;

    private String navegadorSession;

    @Basic(optional = false)
    private String rolSession;

    public Long getCodigoSession() {
        return codigoSession;
    }

    public void setCodigoSession(Long codigoSession) {
        this.codigoSession = codigoSession;
    }

    public String getUsuarioSession() {
        return usuarioSession;
    }

    public void setUsuarioSession(String usuarioSession) {
        this.usuarioSession = usuarioSession;
    }

    public String getPasswordSession() {
        return passwordSession;
    }

    public void setPasswordSession(String passwordSession) {
        this.passwordSession = passwordSession;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public Date getFechaSolicitudToken() {
        return fechaSolicitudToken;
    }

    public void setFechaSolicitudToken(Date fechaSolicitudToken) {
        this.fechaSolicitudToken = fechaSolicitudToken;
    }

    public String getIpSession() {
        return ipSession;
    }

    public void setIpSession(String ipSession) {
        this.ipSession = ipSession;
    }

    public String getNavegadorSession() {
        return navegadorSession;
    }

    public void setNavegadorSession(String navegadorSession) {
        this.navegadorSession = navegadorSession;
    }

    public String getRolSession() {
        return rolSession;
    }

    public void setRolSession(String rolSession) {
        this.rolSession = rolSession;
    }

}
