package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.AreaEncargada.IAreaEncargadaBusiness;
import com.comfama.api.propuestasCultura.domain.areaEncargada.AreaEncargadaGuardarDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "Area Encargada", description = "Servicio para la gestion de las areas")
@RequiredArgsConstructor
public class AreaEncargadaRest {
    private final IAreaEncargadaBusiness iAreaEncargadaBusiness;

    @GetMapping(value ="/obtenerAreasEncargadas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerAreasEncargadas() {
        return iAreaEncargadaBusiness.obtenerAreas();
    }

    @PostMapping(value ="/insertarArea", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>insertarArea(@RequestBody AreaEncargadaGuardarDTO dto){
        return iAreaEncargadaBusiness.insertarArea(dto);
    }

    @GetMapping(value = "/obtenerAreaPorId/{idAreaEncargada}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPropuestaPorId(@PathVariable("idAreaEncargada") Integer idAreaEncargada) {
        return iAreaEncargadaBusiness.obtenerAreaPorId(idAreaEncargada);
    }

}
