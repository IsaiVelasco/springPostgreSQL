package com.grupo.pruebainfotec.dto;

import com.grupo.pruebainfotec.entity.Direccion;
import jakarta.persistence.Column;

public class DireccionDTO {

    private String calle;
    private String numeroInterior;
    private String numeroExterior;
    private int codigoPostal;
    private String colonia;
    private int idCiudad;
    private int idEstado;

    public DireccionDTO(){}
    public DireccionDTO(Direccion direccion){

        this.calle = direccion.getCalle();
        this.numeroInterior = direccion.getNumeroInterior();
        this.numeroExterior = direccion.getNumeroExterior();
        this.codigoPostal = direccion.getCodigoPostal();
        this.colonia = direccion.getColonia();
        this.idCiudad = direccion.getIdCiudad();
        this.idEstado = direccion.getIdEstado();
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
