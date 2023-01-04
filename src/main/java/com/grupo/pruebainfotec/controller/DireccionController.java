package com.grupo.pruebainfotec.controller;

import com.grupo.pruebainfotec.dto.DireccionDTO;
import com.grupo.pruebainfotec.entity.Direccion;
import com.grupo.pruebainfotec.service.DireccionService;
import com.grupo.pruebainfotec.utils.PersonaPDFExporter;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping("/direcciones")
    public List<Direccion> direcciones(){
        return this.direccionService.direcciones();
    }

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
    @DeleteMapping("eliminarDireccion/{id}")
    public ResponseEntity<Integer> eliminarDireccion(@PathVariable("id") Integer id){
        this.direccionService.eliminarPorId(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/direcciones/export/pdf")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        List<Direccion> listUsers = this.direccionService.direcciones();

        PersonaPDFExporter exporter = new PersonaPDFExporter(listUsers);
        exporter.export(response);

    }
}
