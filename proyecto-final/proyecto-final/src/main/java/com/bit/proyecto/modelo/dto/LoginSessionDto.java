package com.bit.proyecto.modelo.dto;

public class LoginSessionDto {
    private String usuarioLogin;
    private String tokenSession;
    private String rolSession;
    private String coutryByIp;
    private Double duracionToken;

    public LoginSessionDto() {
    }

    public LoginSessionDto(String usuarioLogin, String tokenSession, String rolSession, String coutryByIp,
            Double duracionToken) {
        this.usuarioLogin = usuarioLogin;
        this.tokenSession = tokenSession;
        this.rolSession = rolSession;
        this.coutryByIp = coutryByIp;
        this.duracionToken = duracionToken;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession;
    }

    public String getRolSession() {
        return rolSession;
    }

    public void setRolSession(String rolSession) {
        this.rolSession = rolSession;
    }

    public String getCoutryByIp() {
        return coutryByIp;
    }

    public void setCoutryByIp(String coutryByIp) {
        this.coutryByIp = coutryByIp;
    }

    public Double getDuracionToken() {
        return duracionToken;
    }

    public void setDuracionToken(Double duracionToken) {
        this.duracionToken = duracionToken;
    }

}
