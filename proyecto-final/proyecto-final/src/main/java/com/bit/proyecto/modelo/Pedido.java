package com.bit.proyecto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "PEDIDO")
public class Pedido {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PED_CODIGO")
    private Integer pedCodigo;
    @Basic(optional = false)
    @Column(name = "PED_FECHA")
    private String pedFecha;
    @Column(name = "PED_OBSERVACION")
    private String pedObservacion;
    @Column(name = "PED_ESTADO")
    private String pedEstado;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PED_SUBTOTAL")
    private Double pedSubtotal;
    @Basic(optional = false)
    @Column(name = "PED_FACTURA")
    private String pedFactura;
    @Column(name = "PED_IVA")
    private Double pedIva;
    
    @Column(name = "PER_CODIGO")
    private Integer perCodigo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PED_CODIGO", referencedColumnName = "PED_CODIGO")
    private List<Entrega> entrega = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PED_CODIGO", referencedColumnName = "PED_CODIGO")
    private List<DetallePedido> detallePedido = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Integer pedCodigo, String pedFecha, String pedObservacion, String pedEstado, Double pedSubtotal, String pedFactura, Double pedIva, Integer perCodigo) {
        this.pedCodigo = pedCodigo;
        this.pedFecha = pedFecha;
        this.pedObservacion = pedObservacion;
        this.pedEstado = pedEstado;
        this.pedSubtotal = pedSubtotal;
        this.pedFactura = pedFactura;
        this.pedIva = pedIva;
        this.perCodigo = perCodigo;
    }

    public Integer getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(Integer pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public String getPedFecha() {
        return pedFecha;
    }

    public void setPedFecha(String pedFecha) {
        this.pedFecha = pedFecha;
    }

    public String getPedObservacion() {
        return pedObservacion;
    }

    public void setPedObservacion(String pedObservacion) {
        this.pedObservacion = pedObservacion;
    }

    public String getPedEstado() {
        return pedEstado;
    }

    public void setPedEstado(String pedEstado) {
        this.pedEstado = pedEstado;
    }

    public Double getPedSubtotal() {
        return pedSubtotal;
    }

    public void setPedSubtotal(Double pedSubtotal) {
        this.pedSubtotal = pedSubtotal;
    }

    public String getPedFactura() {
        return pedFactura;
    }

    public void setPedFactura(String pedFactura) {
        this.pedFactura = pedFactura;
    }

    public Double getPedIva() {
        return pedIva;
    }

    public void setPedIva(Double pedIva) {
        this.pedIva = pedIva;
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public List<Entrega> getEntrega() {
        return entrega;
    }

    public void setEntrega(List<Entrega> entrega) {
        this.entrega = entrega;
    }

    public List<DetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }
    
}
