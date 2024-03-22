package com.comfama.api.propuestasCultura.domain.propuesta;


import com.comfama.api.propuestasCultura.models.AreaEncargada;
import com.comfama.api.propuestasCultura.models.Estados;
import com.comfama.api.propuestasCultura.models.FormatosAdjuntosSolicitante;
import com.comfama.api.propuestasCultura.models.Solicitante;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropuestaObtenerDTO {
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
    private String contraprestaciones;
    private Double valorTotal;
    private Double aporteComfamaMonetario;
    private String aporteComfamaEspecie;
    private Double porcentajeAporteComfama;
    private Solicitante solicitante;
    private Estados estado;
    private AreaEncargada areaEncargada;
    private FormatosAdjuntosSolicitante formatosAdjuntosSolicitante;
}
