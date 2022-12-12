package com.grupo.pruebainfotec.service;

import com.grupo.pruebainfotec.entity.Persona;
import com.grupo.pruebainfotec.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository; //Inyeccion de dependencias

    public Persona obtenerPorID(Integer id){

        return this.personaRepository.findById(id).get();
    }
    public Integer guardarPersona(String nombre, String apellidos){
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona = this.personaRepository.save(persona);
        return persona.getId();
    }
    public Integer actualizarPersona(String nombre, String apellidos){
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        return 0;
    }
}
