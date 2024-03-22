package com.comfama.api.propuestasCultura.domain.propuesta;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropuestaActualizarDTO {
    private String idPropuesta;
    private String departamento;
    private String municipio;
    private String nombrePropuesta;
    private LocalDate fechaInicioEvento;
    private LocalDate fechaFinEvento;
    private String presentacionGeneral;
    private LocalDate fechaPresentacionPropuesta;
    private String descripcionActividades;
    private String tipoPoblacion;
    private Integer numeroPersonas;
    private String entidadesAliadas;
    private String trayectoria;
    private Integer idSolicitante;
    private Integer idEstado;
    private Integer idAreaEncargada;
}
