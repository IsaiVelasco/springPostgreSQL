package com.grupo.pruebainfotec.service;

import com.grupo.pruebainfotec.dto.PasatiempoDTO;
import com.grupo.pruebainfotec.entity.Pasatiempo;
import com.grupo.pruebainfotec.mapper.PasatiempoDTOtoPasatiempo;
import com.grupo.pruebainfotec.repository.PasatiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PasatiempoService {
    @Autowired
    private PasatiempoRepository pasatiempoRepository;
    @Autowired
    private PasatiempoDTOtoPasatiempo mapper;


    public Integer guardarPasatiempo(PasatiempoDTO pasatiempoDTO){
        Pasatiempo pasatiempo = mapper.map(pasatiempoDTO);

        pasatiempo = this.pasatiempoRepository.save(pasatiempo);
        return  pasatiempo.getId();
    }

}
