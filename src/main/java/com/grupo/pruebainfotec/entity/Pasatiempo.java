package com.grupo.pruebainfotec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Table;

@Entity
@Table(name = "pasatiempos", schema = "public")
public class Pasatiempo {
    private int id;
    private String nombre;
    private int pasatiempo;

    private int idPersona;
}
