package com.bit.proyecto.modelo.dto;
import java.util.Date;

public class SessionDto {

    private Long codigoSession;
    private String usuarioSession;
    private String passwordSession;
    private String tokenSession;
    private Date fechaOperacion;
    private Date fechaSolicitudToken;
    private String ipSession;
    private String navegadorSession;
    private String rolSession;

    public SessionDto() {
    }

    public SessionDto(Long codigoSession, String usuarioSession, String passwordSession, String tokenSession,
            Date fechaOperacion, Date fechaSolicitudToken, String ipSession, String navegadorSession,
            String rolSession) {
        this.codigoSession = codigoSession;
        this.usuarioSession = usuarioSession;
        this.passwordSession = passwordSession;
        this.tokenSession = tokenSession;
        this.fechaOperacion = fechaOperacion;
        this.fechaSolicitudToken = fechaSolicitudToken;
        this.ipSession = ipSession;
        this.navegadorSession = navegadorSession;
        this.rolSession = rolSession;
    }

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
