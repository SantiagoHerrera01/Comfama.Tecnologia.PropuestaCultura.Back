package com.comfama.api.propuestasCultura.interfaces.sp;

import java.time.LocalDate;

public interface IObtenerDatosSolicitantePropuestaPorIdPropuesta {
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

    String getNombres();

    String getApellidos();

    Integer getIdTipoDocumento();

    String getDescription();

    String getNumeroDocumento();

    String getTelefonoFijo();

    String getTelefonoCelular();

    String getCorreo();

    String getNombreProponente();

    LocalDate getFechaFinEvento();

    LocalDate getFechaInicioEvento();

    Integer getNumeroPersonas();

    String getTipoPoblacion();

    Double getValorTotal();

    Integer getIdAreaEncargada();

    String getAreaEncargada();

    Integer getIdAdjuntoSolicitante();

    String getWebUrlFormatoInhabilidades();

    String getWebUrlFormatoTratamientoDatos();
}
