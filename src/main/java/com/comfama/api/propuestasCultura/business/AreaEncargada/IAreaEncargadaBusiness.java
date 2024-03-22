package com.comfama.api.propuestasCultura.business.AreaEncargada;

import com.comfama.api.propuestasCultura.domain.areaEncargada.AreaEncargadaGuardarDTO;
import com.comfama.api.propuestasCultura.models.AreaEncargada;
import org.springframework.http.ResponseEntity;

public interface IAreaEncargadaBusiness {

    ResponseEntity<?> obtenerAreas();
    ResponseEntity<?> insertarArea(AreaEncargadaGuardarDTO dto);
    ResponseEntity<?> obtenerAreaPorId(Integer idAreaEncargada);
    ResponseEntity<?> actualizarArea (AreaEncargada datosArea);
    ResponseEntity<?> eliminarAreaPorId (Integer idAreaEncargada);
}
