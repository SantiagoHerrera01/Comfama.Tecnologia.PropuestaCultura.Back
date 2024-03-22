package com.comfama.api.propuestasCultura.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaPropuestaDTO {
    private String nombrePropuesta;
    private LocalDate fechaRecepcion;
    private Boolean consultaListasPublicas;
    private String areaReceptora;
    private String negocio;
    private String observaciones;
    private Boolean apoyo;
    private String descripcionApoyo;
    private String respuesta;
    private String encargadoRespuesta;
    private String medioNotificacion;
}
