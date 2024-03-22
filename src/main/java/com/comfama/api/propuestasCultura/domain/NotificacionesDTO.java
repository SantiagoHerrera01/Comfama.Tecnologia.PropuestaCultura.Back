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
public class NotificacionesDTO {
    private String nombrePropuesta;
    private LocalDate fechaNotificacion;
    private String mensajeNotificacion;
    private String observaciones;


}
