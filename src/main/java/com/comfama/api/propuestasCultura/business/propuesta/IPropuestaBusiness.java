package com.comfama.api.propuestasCultura.business.propuesta;

import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaActualizarDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.ContraprestacionesDTO;
import org.springframework.http.ResponseEntity;

public interface IPropuestaBusiness {
    ResponseEntity<?> obtenerPropuestas();
    ResponseEntity<?> insertarPropuesta(PropuestaGuardarDTO dto);
    ResponseEntity<?> obtenerPropuestaPorId(String idPropuesta);
    ResponseEntity<?> actualizarPropuesta (PropuestaActualizarDTO dto);
    ResponseEntity<?> insertarContraprestaciones (ContraprestacionesDTO dto);
    ResponseEntity<?> obtenerDatosSolicitantePorId(String idPropuesta);
}
