package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.estados.EstadosServices;
import com.comfama.api.propuestasCultura.models.Estados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1.0")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EstadosRest {


    @Autowired
    EstadosServices estadosServices;

    @GetMapping("/obtenerTodosLosEstados")
    public ResponseEntity<List> obtenerTodosLosEstados(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(estadosServices.buscarTodosLosEstados());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/obtenerEstadoPorId/{idEstado}")
    public ResponseEntity<Estados> buscarEstadoPorId(@PathVariable Integer idEstado){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(estadosServices.buscarEstadoPorId(idEstado));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PostMapping("/agregarEstado")
    public ResponseEntity<Estados> agregarEstado(@RequestBody Estados datosEstado){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(estadosServices.agregarEstado(datosEstado));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
