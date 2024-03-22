package com.comfama.api.propuestasCultura.business.respuestaPropuesta;

import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.domain.respuestaPropuesta.RespuestaPropuestaObtenerDTO;
import com.comfama.api.propuestasCultura.mapper.RespuestaPropuestaMapper;
import com.comfama.api.propuestasCultura.repository.IPropuestaRepository;
import com.comfama.api.propuestasCultura.repository.IRespuestaPropuestaRepository;
import com.comfama.api.propuestasCultura.util.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
@RequiredArgsConstructor
public class RespuestaPropuestaBusinessImpl implements IRespuestaPropuestaBusiness {
    private final IRespuestaPropuestaRepository iRespuestaPropuestaRepository;
    private final RespuestaPropuestaMapper respuestaPropuestaMapper;

    @Override
    public ResponseEntity<?> obtenerRespuestasPropuestas() {
        try {
            var listasRespuestaPropuesta = iRespuestaPropuestaRepository.findAll();
            var listasRespuestaPropuestaDTO = respuestaPropuestaMapper.toRespuestaPropuestaObtenerListDTO(listasRespuestaPropuesta);
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Lista de RespuestaPropuesta",
                            "RespuestaPropuesta obtenidos exitosamente",
                            listasRespuestaPropuestaDTO,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener las RespuestaPropuesta",
                            "Error interno al obtener las RespuestaPropuesta",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> obtenerRespuestasPropuestasPorIdPropuesta(String idPropuesta) {
        try {
            var listasRespuestaPropuesta = iRespuestaPropuestaRepository.obtenerPorIdPropuesta(idPropuesta);
            if (listasRespuestaPropuesta.isEmpty()) {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Lista de RespuestaPropuesta",
                                "idPropuesta no encontrado",
                                "el idPropuesta " + idPropuesta + " no existe.",
                                HttpStatus.NOT_FOUND.value()
                        ),
                        HttpStatus.NOT_FOUND
                );
            } else {
                var listasRespuestaPropuestaDTO = respuestaPropuestaMapper.toRespuestaPropuestaObtenerListDTO(listasRespuestaPropuesta);
                listasRespuestaPropuestaDTO.sort(Comparator.comparing(RespuestaPropuestaObtenerDTO::getFechaCreacion).reversed());
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Lista de RespuestaPropuesta",
                                "RespuestaPropuesta obtenidos exitosamente",
                                listasRespuestaPropuestaDTO,
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK
                );
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener las RespuestaPropuesta",
                            "Error interno al obtener las RespuestaPropuesta",
                            null,
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> insertarRespuestaPropuesta(RespuestaPropuestaGuardarDTO dto) {
        try {
            var propuestaExistenteDTO = respuestaPropuestaMapper.toRespuestaPropuesta(dto);
            var propuestaExistente = iRespuestaPropuestaRepository.save(propuestaExistenteDTO);
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Agrega el solicitante",
                            "Solicitante agregado correctamente",
                            propuestaExistente,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al procesar la solicitud",
                            "Error interno al procesar la solicitud",
                            exception.getMessage(),
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}