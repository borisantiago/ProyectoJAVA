package com.bit.proyecto.modelo.request;

import javax.persistence.Column;

public class PersonaLoginRequestModel {
    
    private String perEmail;
    private String perPassword;

    public String getPerEmail() {
        return perEmail;
    }
    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }
    public String getPerPassword() {
        return perPassword;
    }
    public void setPerPassword(String perPassword) {
        this.perPassword = perPassword;
    }

    

}
