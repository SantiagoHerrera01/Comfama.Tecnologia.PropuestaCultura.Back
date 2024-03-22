package com.comfama.api.propuestasCultura.domain.areaEncargada;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaEncargadaGuardarDTO {
    private String nombreArea;
    private String descripcionArea;
}
