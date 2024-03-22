package com.comfama.api.propuestasCultura.domain.respuestaPropuesta;

import com.comfama.api.propuestasCultura.helpers.EstadosPropuesta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaPropuestaObtenerDTO {
    private Integer idRespuestaPropuesta;
    private String idPropuesta;
    private LocalDateTime fechaRecepcion;
    private Boolean consultaListasPublicas;
    private String nombreArea;
    private String negocio;
    private String observaciones;
    private Double montoAprobadoPorCultura;
    private String encargadoRespuesta;
    private EstadosPropuesta estado;
    private LocalDateTime fechaCreacion;
    private String nombreUsuario;
}
