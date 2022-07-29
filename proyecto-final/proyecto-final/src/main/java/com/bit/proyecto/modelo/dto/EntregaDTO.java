package com.bit.proyecto.modelo.dto;

public class EntregaDTO {
    
    private Integer entCodigo;
    private String entDescripcion;
    private String entRecibe;
    private String entObservacion;
    private String entFechaEnvio;
    private String entFechaRecibe;

    

    private String entEstado;
    private Integer pedCodigo;
    
    public EntregaDTO() {
    }

    public EntregaDTO(Integer entCodigo, String entDescripcion, String entRecibe, String entObservacion,
             String entEstado, Integer pedCodigo) {
        this.entCodigo = entCodigo;
        this.entDescripcion = entDescripcion;
        this.entRecibe = entRecibe;
        this.entObservacion = entObservacion;
        //this.entFechaEnvio = entFechaEnvio;
        this.entEstado = entEstado;
        this.pedCodigo = pedCodigo;
    }

    public Integer getEntCodigo() {
        return entCodigo;
    }

    public void setEntCodigo(Integer entCodigo) {
        this.entCodigo = entCodigo;
    }

    public String getEntDescripcion() {
        return entDescripcion;
    }

    public void setEntDescripcion(String entDescripcion) {
        this.entDescripcion = entDescripcion;
    }

    public String getEntRecibe() {
        return entRecibe;
    }

    public void setEntRecibe(String entRecibe) {
        this.entRecibe = entRecibe;
    }

    public String getEntObservacion() {
        return entObservacion;
    }

    public void setEntObservacion(String entObservacion) {
        this.entObservacion = entObservacion;
    }

    public String getEntFechaEnvio() {
        return entFechaEnvio;
    }

    public void setEntFechaEnvio(String entFechaEnvio) {
        this.entFechaEnvio = entFechaEnvio;
    }

    public String getEntFechaRecibe() {
        return entFechaRecibe;
    }

    public void setEntFechaRecibe(String entFechaRecibe) {
        this.entFechaRecibe = entFechaRecibe;
    }

    public String getEntEstado() {
        return entEstado;
    }

    public void setEntEstado(String entEstado) {
        this.entEstado = entEstado;
    }

    public Integer getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(Integer pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    

    

    



}
