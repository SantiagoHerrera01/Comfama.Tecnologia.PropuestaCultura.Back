package com.comfama.api.propuestasCultura.mapper;

import com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO.FormatoAutorizacionTratamientoDatosDTO;
import com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO.FormatosRegimenInhabilidadesDTO;
import com.comfama.api.propuestasCultura.models.FormatosAdjuntosSolicitante;
import com.comfama.api.propuestasCultura.models.Propuesta;
import org.springframework.stereotype.Component;

@Component
public class FormatosAdjuntosSolicitanteMapper {

    public FormatosAdjuntosSolicitante toFormatosRegimenInhabilidades(FormatosRegimenInhabilidadesDTO dto) {
        Propuesta propuesta = Propuesta.builder().idPropuesta(dto.getIdPropuesta()).build();
        return FormatosAdjuntosSolicitante
                .builder()
                .propuesta(propuesta)
                .rutaFormatoInhabilidades(dto.getRutaFormatoInhabilidades())
                .webUrlFormatoInhabilidades(dto.getWebUrlFormatoInhabilidades())
                .fechaCreacionFormatoInhabilidades(dto.getFechaCreacionFormatoInhabilidades())
                .build();
    }

    public FormatosAdjuntosSolicitante toFormatoAutorizacionTratamientoDatos(FormatoAutorizacionTratamientoDatosDTO dto){
        Propuesta propuesta = Propuesta.builder().idPropuesta(dto.getIdPropuesta()).build();
        return FormatosAdjuntosSolicitante
                .builder()
                .propuesta(propuesta)
                .rutaFormatoTratamientoDatos(dto.getRutaFormatoTratamientoDatos())
                .webUrlFormatoTratamientoDatos(dto.getWebUrlFormatoTratamientoDatos())
                .fechaCreacionFormatoTratamientoDatos(dto.getFechaCreacionFormatoTratamientoDatos())
                .build();
    }

}
