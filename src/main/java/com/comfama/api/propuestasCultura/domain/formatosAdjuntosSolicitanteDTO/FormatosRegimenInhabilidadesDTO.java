package com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormatosRegimenInhabilidadesDTO {

    private String idPropuesta;

    private String rutaFormatoInhabilidades;

    private String webUrlFormatoInhabilidades;

    private String fechaCreacionFormatoInhabilidades;

}
