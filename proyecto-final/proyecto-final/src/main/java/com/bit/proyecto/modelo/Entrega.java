package com.bit.proyecto.modelo;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "ENTREGA")
@NamedQueries({
    @NamedQuery(name = "Entrega.findAll", query = "SELECT e FROM Entrega e")})
public class Entrega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ENT_CODIGO")
    private Integer entCodigo;
    @Column(name = "ENT_DESCRIPCION")
    private String entDescripcion;
    @Column(name = "ENT_RECIBE")
    private String entRecibe;
    @Column(name = "ENT_OBSERVACION")
    private String entObservacion;
    @Column(name = "ENT_FECHA_ENVIO")
    private Date entFechaEnvio;
    @Column(name = "ENT_FECHA_RECIBE")
    private Date entFechaRecibe;
    @Basic(optional = false)
    @Column(name = "ENT_ESTADO")
    private String entEstado;
    
    @Column(name = "PED_CODIGO")
    private Integer pedCodigo;

    public Entrega() {
    }

    public Entrega(Integer entCodigo, String entDescripcion, String entRecibe, String entObservacion, String entEstado, Integer pedCodigo) {
        this.entCodigo = entCodigo;
        this.entDescripcion = entDescripcion;
        this.entRecibe = entRecibe;
        this.entObservacion = entObservacion;
        this.entEstado = entEstado;
        //this.entFechaEnvio = entFechaEnvio;
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

    public Date getEntFechaEnvio() {
        return entFechaEnvio;
    }

    public void setEntFechaEnvio(Date entFechaEnvio) {
        this.entFechaEnvio = entFechaEnvio;
    }

    public Date getEntFechaRecibe() {
        return entFechaRecibe;
    }

    public void setEntFechaRecibe(Date entFechaRecibe) {
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
