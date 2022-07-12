package com.bit.proyecto.modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "PEDIDO")
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PED_CODIGO")
    private Integer pedCodigo;
    @Basic(optional = false)
    @Column(name = "PED_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pedFecha;
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
    @JoinColumn(name = "PER_CODIGO", referencedColumnName = "PER_CODIGO")
    @ManyToOne(optional = false)
    private Persona perCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedCodigo")
    private Collection<Entrega> entregaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedCodigo")
    private Collection<DetallePedido> detallePedidoCollection;

    public Pedido() {
    }

    public Pedido(Integer pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public Pedido(Integer pedCodigo, Date pedFecha, String pedFactura) {
        this.pedCodigo = pedCodigo;
        this.pedFecha = pedFecha;
        this.pedFactura = pedFactura;
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

    public Persona getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Persona perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Collection<Entrega> getEntregaCollection() {
        return entregaCollection;
    }

    public void setEntregaCollection(Collection<Entrega> entregaCollection) {
        this.entregaCollection = entregaCollection;
    }

    public Collection<DetallePedido> getDetallePedidoCollection() {
        return detallePedidoCollection;
    }

    public void setDetallePedidoCollection(Collection<DetallePedido> detallePedidoCollection) {
        this.detallePedidoCollection = detallePedidoCollection;
    }

    
    
}
