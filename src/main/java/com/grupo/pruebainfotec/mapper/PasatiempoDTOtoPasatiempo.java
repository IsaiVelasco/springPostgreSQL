package com.grupo.pruebainfotec.mapper;

import com.grupo.pruebainfotec.dto.PasatiempoDTO;
import com.grupo.pruebainfotec.entity.Pasatiempo;
import org.springframework.stereotype.Component;

@Component
public class PasatiempoDTOtoPasatiempo implements IMapper<PasatiempoDTO, Pasatiempo> {


    @Override
    public Pasatiempo map(PasatiempoDTO dto) {
        Pasatiempo pasatiempo = new Pasatiempo();
        pasatiempo.setId(dto.getId());
        pasatiempo.setNombre(dto.getNombre());
        pasatiempo.setPasatiempo(dto.getPasatiempo());
        pasatiempo.setIdPersona(pasatiempo.getIdPersona());
        return pasatiempo;
    }
}
