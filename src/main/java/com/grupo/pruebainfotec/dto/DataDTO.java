package com.grupo.pruebainfotec.dto;

import com.grupo.pruebainfotec.entity.Persona;

public class DataDTO {
    private int id;
    private String nombre;
    private String apellidos;

    public DataDTO(){};
    public DataDTO(Persona persona){
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellidos = persona.getApellidos();
    }
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


}
