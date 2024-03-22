package com.comfama.api.propuestasCultura.business.tipoDocumento;

import org.springframework.http.ResponseEntity;

public interface ITipoDocumentoBusiness {
    ResponseEntity<?> obtenerTodosLosTipoDocumento();
}
