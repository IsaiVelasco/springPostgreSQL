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
    private int ciudad;
    private int estado;


}
