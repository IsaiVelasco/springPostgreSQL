package com.grupo.pruebainfotec.dto;

import jakarta.persistence.Column;

public class PasatiempoDTO {
    private int id;
    private String nombre;
    private int pasatiempo;
    private int idPersona;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPasatiempo() {
        return pasatiempo;
    }

    public void setPasatiempo(int pasatiempo) {
        this.pasatiempo = pasatiempo;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }
}
