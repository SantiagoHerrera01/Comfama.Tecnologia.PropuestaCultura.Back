package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.business.propuesta.IPropuestaBusiness;
import com.comfama.api.propuestasCultura.domain.propuesta.ContraprestacionesDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "Propuesta", description = "Servicio para la gestion de propuestas")
@RequiredArgsConstructor
public class PropuestaRest {
    private final IPropuestaBusiness iPropuestaBusiness;

    @GetMapping(value ="/obtenerPropuestas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPropuestas() {
        return iPropuestaBusiness.obtenerPropuestas();
    }

    @PostMapping(value ="/insertarPropuesta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>insertarPropuesta(@RequestBody PropuestaGuardarDTO dto){
        return iPropuestaBusiness.insertarPropuesta(dto);
    }

    @GetMapping(value = "/obtenerPropuestaPorId/{idPropuesta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPropuestaPorId(@PathVariable("idPropuesta") String idPropuesta) {
        return iPropuestaBusiness.obtenerPropuestaPorId(idPropuesta);
    }

    @GetMapping(value = "/ObtenerDatosSolicitantePropuestaPorIdPropuesta/{idPropuesta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ObtenerDatosSolicitantePropuestaPorIdPropuesta(@PathVariable("idPropuesta") String idPropuesta){
        return iPropuestaBusiness.obtenerDatosSolicitantePorId(idPropuesta);
    }

    @PutMapping("/insertarContraprestaciones")
    public ResponseEntity<?> insertarContraprestaciones(@RequestBody ContraprestacionesDTO contraprestaciones) {
        try {
            return iPropuestaBusiness.insertarContraprestaciones(contraprestaciones);
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

    }

}
