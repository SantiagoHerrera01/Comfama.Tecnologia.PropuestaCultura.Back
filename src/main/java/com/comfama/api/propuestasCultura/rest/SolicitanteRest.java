package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.solicitantesBusiness.ISolicitantesBusiness;
import com.comfama.api.propuestasCultura.domain.solicitante.SolicitanteGuardarDTO;
import com.comfama.api.propuestasCultura.models.Solicitante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SolicitanteRest {
    @Autowired
    ISolicitantesBusiness iSolicitantesBusiness;

    @GetMapping("/obtenerTodosLosSolicitantes")
    public ResponseEntity<?> obtenerTodosLosSolicitantes() {
        try {
            return iSolicitantesBusiness.obtenerTodosLosSolicitantes();
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/obtenerSolicitantePorId/{idSolicitante}")
    public ResponseEntity<?> obtenerSolicitantePorId(@PathVariable Integer idSolicitante) {
        try {
            return iSolicitantesBusiness.obtenerSolicitantePorId(idSolicitante);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PostMapping(value = "/agregarSolicitante", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> agregarSolicitante(@RequestBody SolicitanteGuardarDTO dto) {
        return iSolicitantesBusiness.agregarSolicitante(dto);
    }
}
