package com.comfama.api.propuestasCultura.mapper;

import com.comfama.api.propuestasCultura.domain.areaEncargada.AreaEncaegadaObtenerDTO;
import com.comfama.api.propuestasCultura.domain.areaEncargada.AreaEncargadaGuardarDTO;
import com.comfama.api.propuestasCultura.models.AreaEncargada;
import org.springframework.stereotype.Component;

@Component
public class AreaEncargadaMapper {
    public AreaEncaegadaObtenerDTO toAreaDTO(AreaEncargada entity){
        return AreaEncaegadaObtenerDTO.builder()
                .idAreaEncargada(entity.getIdAreaEncargada())
                .nombreArea(entity.getNombreArea())
                .descripcionArea(entity.getDescripcionArea())
                .build();
    }


    public AreaEncargada toArea(AreaEncargadaGuardarDTO dto){
        return AreaEncargada.builder()
                .nombreArea(dto.getNombreArea())
                .descripcionArea(dto.getDescripcionArea())
                .build();
    }
}
