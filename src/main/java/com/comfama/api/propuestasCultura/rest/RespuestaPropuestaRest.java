package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.respuestaPropuesta.IRespuestaPropuestaBusiness;
import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaGuardarDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "RespuestaPropuesta", description = "Servicio para la gestion de la respuesta propuesta")
@RequiredArgsConstructor
public class RespuestaPropuestaRest {
    private final IRespuestaPropuestaBusiness iRespuestaPropuestaBusiness;

    @GetMapping(value = "/obtenerRespuestasPropuestas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerRespuestasPropuestas() {
        return iRespuestaPropuestaBusiness.obtenerRespuestasPropuestas();
    }

    @GetMapping(value = "/obtenerRespuestasPropuestasPorIdPropuesta/{idPropuesta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerRespuestasPropuestasPorIdPropuesta(@PathVariable String idPropuesta) {
        return iRespuestaPropuestaBusiness.obtenerRespuestasPropuestasPorIdPropuesta(idPropuesta);
    }

    @PostMapping(value = "/insertarRespuestaPropuesta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insertarPropuesta(@RequestBody RespuestaPropuestaGuardarDTO dto) {
        return iRespuestaPropuestaBusiness.insertarRespuestaPropuesta(dto);
    }
}
