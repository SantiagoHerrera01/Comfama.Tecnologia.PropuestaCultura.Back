package com.comfama.api.propuestasCultura.domain.propuesta;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContraprestacionesDTO {
    String idPropuesta;

    String contraprestaciones;

    Double valorTotal;

    Double aporteComfamaMonetario;

    String aporteComfamaEspecie;

    Double porcentajeAporteComfama;

    String contributionType = "";
}
