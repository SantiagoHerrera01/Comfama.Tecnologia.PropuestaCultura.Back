package com.comfama.api.propuestasCultura.business.solicitantesBusiness;

import com.comfama.api.propuestasCultura.domain.solicitante.SolicitanteGuardarDTO;
import org.springframework.http.ResponseEntity;

public interface ISolicitantesBusiness {
    ResponseEntity<?> obtenerTodosLosSolicitantes();
    ResponseEntity<?> obtenerSolicitantePorId(Integer idSolicitante);

    ResponseEntity<?> agregarSolicitante(SolicitanteGuardarDTO dto);
}
