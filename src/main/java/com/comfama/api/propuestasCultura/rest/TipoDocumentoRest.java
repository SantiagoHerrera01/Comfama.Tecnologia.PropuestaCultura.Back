package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.tipoDocumento.ITipoDocumentoBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class TipoDocumentoRest {
    @Autowired
    ITipoDocumentoBusiness iTipoDocumentoBusiness;

    @GetMapping("/obtenerTodosLosTipoDocumento")
    public ResponseEntity<?> obtenerTodosLosTiposDocumento() {
        try {
            return iTipoDocumentoBusiness.obtenerTodosLosTipoDocumento();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
