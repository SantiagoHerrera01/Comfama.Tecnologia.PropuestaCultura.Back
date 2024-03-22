package com.comfama.api.propuestasCultura.business.AreaEncargada;

import com.comfama.api.propuestasCultura.mapper.AreaEncargadaMapper;
import com.comfama.api.propuestasCultura.domain.areaEncargada.AreaEncargadaGuardarDTO;
import com.comfama.api.propuestasCultura.models.AreaEncargada;
import com.comfama.api.propuestasCultura.repository.IAreaEncargadaRepository;
import com.comfama.api.propuestasCultura.util.Util;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AreaEncargadaBusinessImpl implements IAreaEncargadaBusiness {
    IAreaEncargadaRepository areaEncargadaRepository;
    AreaEncargadaMapper areaEncargadaMapper;

    @Override
    public ResponseEntity<?> obtenerAreas() {
       try{
           var listaAreas  = areaEncargadaRepository.findAll();
           return new ResponseEntity<>(
                   Util.setResponse(
                           "Lista de las areas encargadas",
                           "Areas obtenidas exitosamente",
                           listaAreas,
                           HttpStatus.OK.value()
                   ),
                   HttpStatus.OK
           );
       }catch (Exception e){
           return new ResponseEntity<>(
                   Util.setResponse(
                           "Error interno al obtener las areas encargadas",
                           "Error interno al obtener las areas encargadas",
                           "",
                           HttpStatus.INTERNAL_SERVER_ERROR.value()
                   ),
                   HttpStatus.INTERNAL_SERVER_ERROR
           );
       }
    }

    @Override
    public ResponseEntity<?> insertarArea(AreaEncargadaGuardarDTO dto) {
        try {
            var insertarArea = areaEncargadaMapper.toArea(dto);
            insertarArea = areaEncargadaRepository.save(insertarArea);
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Agrega el area",
                            "Area insertada correctamente",
                            insertarArea,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        }catch (Exception exception) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al agregar la area",
                            "Error interno al agregar la area",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> obtenerAreaPorId(Integer idAreaEncargada) {
        try {
            var obtenerArea = areaEncargadaRepository.findById(idAreaEncargada);
            if (obtenerArea.isPresent()){
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Lista la area por id",
                                "area Obteneida Exitosamente",
                                areaEncargadaMapper.toAreaDTO(obtenerArea.get()),
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "No se encontro una area con el ID proporcionado",
                                "No se encontro una area con el ID proporcionado",
                                "",
                                HttpStatus.NOT_FOUND.value()
                        ),
                        HttpStatus.NOT_FOUND
                );
            }

        }catch (Exception exception) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener la propuesta por id",
                            "Error interno al obtener la propuesta por id",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> actualizarArea(AreaEncargada datosArea) {
        return null;
    }

    @Override
    public ResponseEntity<?> eliminarAreaPorId(Integer idAreaEncargada) {
        return null;
    }
}
