package com.grupo.pruebainfotec.controller;

import com.grupo.pruebainfotec.dto.DireccionDTO;
import com.grupo.pruebainfotec.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DireccionController {
    @Autowired
    private DireccionService direccionService;
    @PostMapping("/guardarDireccion")
    public ResponseEntity<Integer> guardarDireccion(@RequestBody DireccionDTO data){
        Integer id = 0;
        try {
            id = direccionService.guardarDireccion(data);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(id==0){
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    @GetMapping("/obtenerDireccion/{id}")
    public ResponseEntity<DireccionDTO> obtenerDireccion(@PathVariable("id") Integer id){
        return new ResponseEntity<>(new DireccionDTO(direccionService.direccionPorId(id)), HttpStatus.OK);
    }
    @PutMapping("/actualizarDireccion/{id}")
    public ResponseEntity<Integer> actualizarDireccion(@PathVariable("id") Integer id){

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
