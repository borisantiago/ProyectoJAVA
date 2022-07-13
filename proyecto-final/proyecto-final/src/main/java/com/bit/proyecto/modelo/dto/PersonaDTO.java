package com.bit.proyecto.modelo.dto;

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
    
    public PersonaDTO() {
    }

    public PersonaDTO(Integer perCodigo, String perIdentificacion, String perNombre, String perApellido,
            String perDireccion, String perTalla, String perFechaNacimiento, String perGenero, String perEmail) {
        this.perCodigo = perCodigo;
        this.perIdentificacion = perIdentificacion;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perDireccion = perDireccion;
        this.perTalla = perTalla;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perGenero = perGenero;
        this.perEmail = perEmail;
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

    

    

    

    
}
