package com.bit.proyecto.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CARRITO")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CAR_CODIGO")
    private Integer carCodigo;

    @Column(name = "PER_CODIGO")
    private Integer perCodigo;

    @Column(name = "ZAP_CODIGO")
    private String zapCodigo;

    public Carrito() {
    }

    public Carrito(Integer carCodigo, Integer perCodigo, String zapCodigo) {
        this.carCodigo = carCodigo;
        this.perCodigo = perCodigo;
        this.zapCodigo = zapCodigo;
    }

    public Integer getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(Integer carCodigo){
        this.carCodigo = carCodigo;
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getZapCodigo() {
        return zapCodigo;
    }

    public void setZapCodigo(String zapCodigo) {
        this.zapCodigo = zapCodigo;
    }

   
}
