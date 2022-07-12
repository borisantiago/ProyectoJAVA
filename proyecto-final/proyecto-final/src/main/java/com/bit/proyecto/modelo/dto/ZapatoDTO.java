package com.bit.proyecto.modelo.dto;

public class ZapatoDTO {
    
    private String zapCodigo;
    private String zapNombre;
    private String zapModelo;
    private String zapGenero;
    private String zapColor;
    private String zapTalla;
    private int zapStock;
    private Double zapPrecio;
   
    public ZapatoDTO() {
    }

    public ZapatoDTO(String zapCodigo, String zapNombre, String zapModelo, String zapGenero, String zapColor,
            String zapTalla, int zapStock, Double zapPrecio) {
        this.zapCodigo = zapCodigo;
        this.zapNombre = zapNombre;
        this.zapModelo = zapModelo;
        this.zapGenero = zapGenero;
        this.zapColor = zapColor;
        this.zapTalla = zapTalla;
        this.zapStock = zapStock;
        this.zapPrecio = zapPrecio;
    }

    public String getZapCodigo() {
        return zapCodigo;
    }

    public void setZapCodigo(String zapCodigo) {
        this.zapCodigo = zapCodigo;
    }

    public String getZapNombre() {
        return zapNombre;
    }

    public void setZapNombre(String zapNombre) {
        this.zapNombre = zapNombre;
    }

    public String getZapModelo() {
        return zapModelo;
    }

    public void setZapModelo(String zapModelo) {
        this.zapModelo = zapModelo;
    }

    public String getZapGenero() {
        return zapGenero;
    }

    public void setZapGenero(String zapGenero) {
        this.zapGenero = zapGenero;
    }

    public String getZapColor() {
        return zapColor;
    }

    public void setZapColor(String zapColor) {
        this.zapColor = zapColor;
    }

    public String getZapTalla() {
        return zapTalla;
    }

    public void setZapTalla(String zapTalla) {
        this.zapTalla = zapTalla;
    }

    public int getZapStock() {
        return zapStock;
    }

    public void setZapStock(int zapStock) {
        this.zapStock = zapStock;
    }

    public Double getZapPrecio() {
        return zapPrecio;
    }

    public void setZapPrecio(Double zapPrecio) {
        this.zapPrecio = zapPrecio;
    }

    

    

    

}
