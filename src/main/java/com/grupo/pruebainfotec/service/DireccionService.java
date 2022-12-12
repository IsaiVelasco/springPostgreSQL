package com.grupo.pruebainfotec.service;

import com.grupo.pruebainfotec.dto.DireccionDTO;
import com.grupo.pruebainfotec.entity.Direccion;
import com.grupo.pruebainfotec.entity.Persona;
import com.grupo.pruebainfotec.repository.DireccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    public Direccion direccionPorId(Integer id){
        return this.direccionRepository.findById(id).get();
    }

    public Integer guardarDireccion(DireccionDTO direccionDTO){
        Direccion direccion = new Direccion();
        direccion.setCalle(direccionDTO.getCalle());
        direccion.setNumeroInterior(direccionDTO.getNumeroInterior());
        direccion.setNumeroExterior(direccionDTO.getNumeroExterior());
        direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
        direccion.setColonia(direccionDTO.getColonia());
        direccion.setIdCiudad(direccionDTO.getIdCiudad());
        direccion.setIdEstado(direccionDTO.getIdEstado());
        direccion = this.direccionRepository.save(direccion);
        return direccion.getId();
    }



}
