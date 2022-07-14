package com.bit.proyecto.modelo.dto;

public class DetallePedidoDTO {
    
    private Integer depCodigo;
    private int depCantidad;
    private double depPrecio;
    private Double depDescuento;
    private Double depIva;
    private Double depSubtotal;
    private String depObservacion;
    private Integer pedCodigo;
    private String zapCodigo;
    
    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(Integer depCodigo, int depCantidad, double depPrecio, Double depDescuento, Double depIva,
            Double depSubtotal, String depObservacion, Integer pedCodigo, String zapCodigo) {
        this.depCodigo = depCodigo;
        this.depCantidad = depCantidad;
        this.depPrecio = depPrecio;
        this.depDescuento = depDescuento;
        this.depIva = depIva;
        this.depSubtotal = depSubtotal;
        this.depObservacion = depObservacion;
        this.pedCodigo = pedCodigo;
        this.zapCodigo = zapCodigo;
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

    public Integer getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(Integer pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public String getZapCodigo() {
        return zapCodigo;
    }

    public void setZapCodigo(String zapCodigo) {
        this.zapCodigo = zapCodigo;
    }

    

    

    

}
