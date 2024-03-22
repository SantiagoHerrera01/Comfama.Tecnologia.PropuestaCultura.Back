package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.formatosAdjuntosSolicitante.IFormatosAdjuntosSolicitanteBusiness;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1.0")
@Slf4j
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name = "FormatosADJUNTOS", description = "Servicio para la gestion de Formatos Adjuntos")
@RequiredArgsConstructor
public class FormatosAdjuntosSolicitanteRest {

    private final IFormatosAdjuntosSolicitanteBusiness iFormatosAdjuntosSolicitanteBusiness;

    @GetMapping(value = "/obtenerFormatosAdjuntos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerFormatosAdjuntos() {
        return iFormatosAdjuntosSolicitanteBusiness.obtenerFormatosAdjuntos();
    }

    @PutMapping(value = "/insertarArchivoFormatoAutorizacionTratamientoDatos/{idPropuesta}", consumes = "multipart/form-data")
    public ResponseEntity<?> insertarArchivoFormatoAutorizacionTratamientoDatos(@RequestParam("file") MultipartFile file, @PathVariable("idPropuesta") String idPropuesta) {
        return iFormatosAdjuntosSolicitanteBusiness.insertarArchivoFormatoAutorizacionTratamientoDatos(file, idPropuesta);
    }

    @PutMapping(value = "/insertarArchivoFormatoRegimenInhabilidades/{idPropuesta}", consumes = "multipart/form-data")
    public ResponseEntity<?> insertarArchivoFormatoRegimenInhabilidades(@RequestBody MultipartFile file, @PathVariable("idPropuesta") String idPropuesta) {
        return iFormatosAdjuntosSolicitanteBusiness.insertarArchivoFormatoRegimenInhabilidades(file, idPropuesta);
    }
}
