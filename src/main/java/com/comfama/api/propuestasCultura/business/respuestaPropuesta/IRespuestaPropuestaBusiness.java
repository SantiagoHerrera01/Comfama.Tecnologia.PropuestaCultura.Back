package com.comfama.api.propuestasCultura.business.respuestaPropuesta;

import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaGuardarDTO;
import org.springframework.http.ResponseEntity;

public interface IRespuestaPropuestaBusiness {
    ResponseEntity<?> obtenerRespuestasPropuestas();

    ResponseEntity<?> insertarRespuestaPropuesta(RespuestaPropuestaGuardarDTO dto);

    ResponseEntity<?> obtenerRespuestasPropuestasPorIdPropuesta(String idPropuesta);
}
