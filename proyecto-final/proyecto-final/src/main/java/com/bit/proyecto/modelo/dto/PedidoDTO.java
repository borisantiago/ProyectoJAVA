package com.bit.proyecto.modelo.dto;

import java.util.Date;
import java.util.List;

import com.bit.proyecto.modelo.DetallePedido;
import com.bit.proyecto.modelo.Entrega;

public class PedidoDTO {
    
    private Integer pedCodigo;
    private Date pedFecha;
    private String pedObservacion;
    private String pedEstado;
    private Double pedSubtotal;
    private String pedFactura;
    private Double pedIva;

    private Integer perCodigo;
    
    private List<Entrega> entrega;
    private List<DetallePedido> detallePedido;
    
    public PedidoDTO() {
    }

    public PedidoDTO(Integer pedCodigo, Date pedFecha, String pedObservacion, String pedEstado, Double pedSubtotal, String pedFactura,
            Double pedIva, Integer perCodigo) {
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

    public Date getPedFecha() {
        return pedFecha;
    }

    public void setPedFecha(Date pedFecha) {
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

    public List<Entrega> getEntrega(){
        return entrega;
    }

    public void setEntrega(List<Entrega> entrega){
        this.entrega = entrega;
    }

    public List<DetallePedido> getDetallePedido(){
        return detallePedido;
    }

    public void setDetallePedido(List<DetallePedido> detallePedido){
        this.detallePedido = detallePedido;
    }

}
