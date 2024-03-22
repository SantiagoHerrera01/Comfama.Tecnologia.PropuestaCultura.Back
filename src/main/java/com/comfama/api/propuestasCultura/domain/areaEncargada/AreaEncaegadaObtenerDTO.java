package com.comfama.api.propuestasCultura.domain.areaEncargada;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AreaEncaegadaObtenerDTO {
    private Integer idAreaEncargada;
    private String nombreArea;
    private String descripcionArea;
}
