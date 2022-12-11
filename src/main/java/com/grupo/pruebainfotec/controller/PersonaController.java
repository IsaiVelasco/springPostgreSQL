package com.grupo.pruebainfotec.controller;

import com.grupo.pruebainfotec.dto.DataDTO;
import com.grupo.pruebainfotec.entity.Persona;
import com.grupo.pruebainfotec.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Esta clase recibe las peticiones del cliente
@RestController
public class PersonaController {
    @Autowired
    public PersonaService personaService;
    @PutMapping("/guardar")
    public ResponseEntity<Integer> guardarPersona(@RequestParam("nombre")String nombre, @RequestParam("apellidos") String apellidos){
        Integer id = 0;
        try{
            id = this.personaService.guardarPersona(nombre, apellidos);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(id==0){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @PutMapping("/guardarDTO")
    public ResponseEntity<Integer> guardarPersona(@RequestBody DataDTO data){
        Integer id = 0;
        try{
            id = this.personaService.guardarPersona(data.getNombre(), data.getApellidos());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(id==0){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping("/obtenerPersona/{id}")
    public ResponseEntity <DataDTO> obtenerPersona(@PathVariable("id")Integer id){
        return new ResponseEntity<>(new DataDTO(this.personaService.obtenerPorID(id)), HttpStatus.OK);
    }
}
