package com.comfama.api.propuestasCultura.domain.respuestaPropuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaPropuestaGuardarDTO {
    private String idPropuesta;
    private LocalDateTime fechaRecepcion;
    private Boolean consultaListasPublicas;
    private Integer idAreaEncargada;
    private String negocio;
    private String observaciones;
    private Double montoAprobadoPorCultura;
    private String encargadoRespuesta;
    private Integer idEstado;
    private LocalDateTime fechaCreacion;
    private Integer idUsuario;
}
