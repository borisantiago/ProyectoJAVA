package com.bit.proyecto.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "DETALLE_PEDIDO")
@NamedQueries({
    @NamedQuery(name = "DetallePedido.findAll", query = "SELECT d FROM DetallePedido d")})
public class DetallePedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DEP_CODIGO")
    private Integer depCodigo;
    @Basic(optional = false)
    @Column(name = "DEP_CANTIDAD")
    private int depCantidad;
    @Basic(optional = false)
    @Column(name = "DEP_PRECIO")
    private double depPrecio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DEP_DESCUENTO")
    private Double depDescuento;
    @Column(name = "DEP_IVA")
    private Double depIva;
    @Column(name = "DEP_SUBTOTAL")
    private Double depSubtotal;
    @Column(name = "DEP_OBSERVACION")
    private String depObservacion;
    @JoinColumn(name = "PED_CODIGO", referencedColumnName = "PED_CODIGO")
    @ManyToOne(optional = false)
    private Pedido pedCodigo;
    @JoinColumn(name = "ZAP_CODIGO", referencedColumnName = "ZAP_CODIGO")
    @ManyToOne(optional = false)
    private Zapato zapCodigo;

    public DetallePedido() {
    }

    public DetallePedido(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public DetallePedido(Integer depCodigo, int depCantidad, double depPrecio) {
        this.depCodigo = depCodigo;
        this.depCantidad = depCantidad;
        this.depPrecio = depPrecio;
    }

    public Integer getDepCodigo() {
        return depCodigo;
    }

    public void setDepCodigo(Integer depCodigo) {
        this.depCodigo = depCodigo;
    }

    public int getDepCantidad() {
        return depCantidad;
    }

    public void setDepCantidad(int depCantidad) {
        this.depCantidad = depCantidad;
    }

    public double getDepPrecio() {
        return depPrecio;
    }

    public void setDepPrecio(double depPrecio) {
        this.depPrecio = depPrecio;
    }

    public Double getDepDescuento() {
        return depDescuento;
    }

    public void setDepDescuento(Double depDescuento) {
        this.depDescuento = depDescuento;
    }

    public Double getDepIva() {
        return depIva;
    }

    public void setDepIva(Double depIva) {
        this.depIva = depIva;
    }

    public Double getDepSubtotal() {
        return depSubtotal;
    }

    public void setDepSubtotal(Double depSubtotal) {
        this.depSubtotal = depSubtotal;
    }

    public String getDepObservacion() {
        return depObservacion;
    }

    public void setDepObservacion(String depObservacion) {
        this.depObservacion = depObservacion;
    }

    public Pedido getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(Pedido pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public Zapato getZapCodigo() {
        return zapCodigo;
    }

    public void setZapCodigo(Zapato zapCodigo) {
        this.zapCodigo = zapCodigo;
    }

    
    
}
