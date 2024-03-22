package com.comfama.api.propuestasCultura.interfaces.sp;

import java.time.LocalDate;

public interface IObtenerTodasLasPropuestas {
    String getIdPropuesta();
    String getAporteComfamaEspecie();
    Double getAporteComfamaMonetario();
    String getContraprestaciones();
    String getDepartamento();
    String getDescripcionActividades();
    String getEntidadesAliadas();
    LocalDate getFechaPresentacionPropuesta();
    String getMunicipio();
    String getNombrePropuesta();
    Double getPorcentajeAporteComfama();
    String getPresentacionGeneral();
    String getTrayectoria();
    Integer getIdEstado();
    String getEstadoPropuesta();
    Integer getIdSolicitante();
    String getNombreSolicitante();
    LocalDate getFechaFinEvento();
    LocalDate getFechaInicioEvento();
    Integer getNumeroPersonas();
    String getTipoPoblacion();
    Double getValorTotal();
    Integer getIdAreaEncargada();
    String getAreaEncargada();
    String getWebUrlFormatoInhabilidades();
    String getWebUrlFormatoTratamientoDatos();
}
