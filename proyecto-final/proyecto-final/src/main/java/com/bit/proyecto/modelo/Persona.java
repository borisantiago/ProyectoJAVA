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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PER_CODIGO")
    private Integer perCodigo;
    @Basic(optional = false)
    @Column(name = "PER_IDENTIFICACION")
    private String perIdentificacion;
    @Basic(optional = false)
    @Column(name = "PER_NOMBRE")
    private String perNombre;
    @Basic(optional = false)
    @Column(name = "PER_APELLIDO")
    private String perApellido;
    @Column(name = "PER_DIRECCION")
    private String perDireccion;
    @Column(name = "PER_TALLA")
    private String perTalla;
    @Column(name = "PER_FECHA_NACIMIENTO")
    private String perFechaNacimiento;
    @Column(name = "PER_GENERO")
    private String perGenero;
    @Column(name = "PER_EMAIL")
    private String perEmail;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PER_CODIGO", referencedColumnName = "PER_CODIGO")
    private List<Pedido> pedido= new ArrayList<>();

    /*Pedido */
    public List<Pedido> getPedido() {
        return pedido;
    }

    public void setPedido(List<Pedido> pedido) {
        this.pedido = pedido;
    }

    public Persona() {
    }

    public Persona(Integer perCodigo, String perIdentificacion, String perNombre, String perApellido, String perDireccion, 
            String perTalla, String perFechaNacimiento, String perGenero, String perEmail) {
        this.perCodigo = perCodigo;
        this.perIdentificacion = perIdentificacion;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perDireccion = perDireccion;
        this.perTalla = perTalla;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perGenero = perGenero;
        this.perEmail = perEmail;
    }

    public Integer getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(Integer perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerIdentificacion() {
        return perIdentificacion;
    }

    public void setPerIdentificacion(String perIdentificacion) {
        this.perIdentificacion = perIdentificacion;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerDireccion() {
        return perDireccion;
    }

    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    public String getPerTalla() {
        return perTalla;
    }

    public void setPerTalla(String perTalla) {
        this.perTalla = perTalla;
    }

    public String getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(String perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerGenero() {
        return perGenero;
    }

    public void setPerGenero(String perGenero) {
        this.perGenero = perGenero;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    
    
}
