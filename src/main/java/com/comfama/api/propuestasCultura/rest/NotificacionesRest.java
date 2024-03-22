package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.notificaciones.NotificacionesBusiness;
import com.comfama.api.propuestasCultura.models.Notificaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1.0")
public class NotificacionesRest {
    @Autowired
    NotificacionesBusiness notificacionesBusiness;
    @GetMapping("/obtenerTodasNotificaciones")
    public ResponseEntity<List> obtenerTodasNotificaciones(){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(notificacionesBusiness.obtenerTodosNotificaciones());
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @GetMapping("/obtenerNotificacionesPorId/{idNotificacion}")
    public ResponseEntity<Notificaciones> buscarNotificacionesPorId(@PathVariable String idNotificacion){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(notificacionesBusiness.buscarNotificacionPorId(idNotificacion));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }

    @PostMapping("/agregarNotificacion")
    public ResponseEntity<Notificaciones> agregarEstado(@RequestBody Notificaciones datosNotificaciones){
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(notificacionesBusiness.agregarNotificacion(datosNotificaciones));
        }catch (Exception error){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}
