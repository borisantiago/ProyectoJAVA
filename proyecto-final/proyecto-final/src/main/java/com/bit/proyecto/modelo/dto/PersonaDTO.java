package com.bit.proyecto.modelo.dto;

import java.util.ArrayList;
import java.util.List;

import com.bit.proyecto.modelo.Pedido;

public class PersonaDTO {

    private Integer perCodigo;
    private String perIdentificacion;
    private String perNombre;
    private String perApellido;
    private String perDireccion;
    private String perTalla;
    private String perFechaNacimiento;
    private String perGenero;
    private String perEmail;
    private String perPassword;
    private String perRole;


    private List<Pedido> pedido = new ArrayList<>();

    public PersonaDTO() {
    }

    public PersonaDTO(Integer perCodigo, String perIdentificacion, String perNombre, String perApellido,
            String perDireccion, String perTalla, String perFechaNacimiento, String perGenero, String perEmail, String perPassword, String perRole) {
        this.perCodigo = perCodigo;
        this.perIdentificacion = perIdentificacion;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perDireccion = perDireccion;
        this.perTalla = perTalla;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perGenero = perGenero;
        this.perEmail = perEmail;
        this.perPassword = perPassword;
        this.perRole = perRole;
        
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTalla() {
        return perTalla;
    }

    public void setPerTalla(String perTalla) {
        this.perTalla = perTalla;
    }

    public String getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(String perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    
    public List<Pedido> getPedido(){
        return pedido;
    }

    public void setPedido(List<Pedido> pedido){
        this.pedido = pedido;
    }
    
    public String getPerPassword() {
        return perPassword;
    }

    public void setPerPassword(String perPassword) {
        this.perPassword = perPassword;
    }

    public String getPerRole() {
        return perRole;
    }

    public void setPerRole(String perRole) {
        this.perRole = perRole;
    }
    
}
