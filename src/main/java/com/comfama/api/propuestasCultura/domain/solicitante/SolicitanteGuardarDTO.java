package com.comfama.api.propuestasCultura.domain.solicitante;

import com.comfama.api.propuestasCultura.models.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitanteGuardarDTO {
    private Integer idSolicitante;
    private String nombreProponente;
    private Integer idTipoDocumento;
    private String nombres;
    private String apellidos;
    private String numeroDocumento;
    private String telefonoFijo;
    private String telefonoCelular;
    private String correo;
}
