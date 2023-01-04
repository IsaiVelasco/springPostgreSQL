package com.grupo.pruebainfotec.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dirección", schema = "public")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String calle;
    @Column(name = "número_interior")
    private String numeroInterior;
    @Column(name = "número_exterior")
    private String numeroExterior;
    @Column(name = "código_postal")
    private int codigoPostal;
    private String colonia;

    @Column(name = "ciudad")
    private int idCiudad;
    @Column(name = "id_estado")
    private int idEstado;

    @OneToOne(mappedBy = "direccion")
    @PrimaryKeyJoinColumn
    private Persona persona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}
