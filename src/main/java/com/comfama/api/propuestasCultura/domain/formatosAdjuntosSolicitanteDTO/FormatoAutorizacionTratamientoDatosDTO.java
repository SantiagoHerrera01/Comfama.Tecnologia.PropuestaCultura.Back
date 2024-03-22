package com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormatoAutorizacionTratamientoDatosDTO {
    private String idPropuesta;

    private String rutaFormatoTratamientoDatos;

    private String webUrlFormatoTratamientoDatos;

    private String fechaCreacionFormatoTratamientoDatos;
}
