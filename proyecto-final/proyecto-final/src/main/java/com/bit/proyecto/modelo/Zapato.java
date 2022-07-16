package com.bit.proyecto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ZAPATO")

public class Zapato implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ZAP_CODIGO")
    private String zapCodigo;
    @Basic(optional = false)
    @Column(name = "ZAP_NOMBRE")
    private String zapNombre;
    @Basic(optional = false)
    @Column(name = "ZAP_MODELO")
    private String zapModelo;
    @Basic(optional = false)
    @Column(name = "ZAP_GENERO")
    private String zapGenero;
    @Basic(optional = false)
    @Column(name = "ZAP_COLOR")
    private String zapColor;
    @Basic(optional = false)
    @Column(name = "ZAP_TALLA")
    private String zapTalla;
    @Basic(optional = false)
    @Column(name = "ZAP_STOCK")
    private int zapStock;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ZAP_PRECIO")
    private Double zapPrecio;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ZAP_CODIGO", referencedColumnName = "ZAP_CODIGO")
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

    public Zapato() {
    }

    public Zapato(String zapCodigo, String zapNombre, String zapModelo, String zapGenero, String zapColor, 
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
