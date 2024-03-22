package com.comfama.api.propuestasCultura.business.propuesta;

import com.comfama.api.propuestasCultura.domain.propuesta.ContraprestacionesDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaActualizarDTO;
import com.comfama.api.propuestasCultura.domain.propuesta.PropuestaGuardarDTO;
import com.comfama.api.propuestasCultura.interfaces.sp.IObtenerDatosSolicitantePropuestaPorIdPropuesta;
import com.comfama.api.propuestasCultura.mapper.PropuestaMapper;
import com.comfama.api.propuestasCultura.models.Propuesta;
import com.comfama.api.propuestasCultura.repository.IAreaEncargadaRepository;
import com.comfama.api.propuestasCultura.repository.IEstadosRepository;
import com.comfama.api.propuestasCultura.repository.IPropuestaRepository;
import com.comfama.api.propuestasCultura.repository.ISolicitanteRepository;
import com.comfama.api.propuestasCultura.util.Util;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PropuestaBusinessImpl implements IPropuestaBusiness {
    IPropuestaRepository propuestaRepository;
    ISolicitanteRepository solicitanteRepository;
    IEstadosRepository estadosRepository;
    IAreaEncargadaRepository areaEncargadaRepository;
    PropuestaMapper propuestaMapper;


    @Override
    @Transactional
    public ResponseEntity<?> obtenerPropuestas() {
        try {
            var listaPropuesta = propuestaRepository.spObtenerTodasLasPropuesta();
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Lista de propuestas",
                            "Propuestas obtenidas exitosamente",
                            listaPropuesta,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener las propuestas",
                            "Error interno al obtener las propuestas",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    @Transactional
    public ResponseEntity<?> obtenerDatosSolicitantePorId(String idPropuesta) {
        try {
            var obtenerPropuesta = propuestaRepository.findById(idPropuesta);
            if (obtenerPropuesta.isPresent()) {
                List<IObtenerDatosSolicitantePropuestaPorIdPropuesta> listaPropuesta = propuestaRepository.spDatosSolicitantePropuestaPorIdpropuesta(idPropuesta);
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Datos completos propuesta",
                                "Datos obtenidos exitosamente",
                                listaPropuesta,
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "No se encontro una propuesta con el ID proporcionado",
                                "No se encontro una propuesta con el ID proporcionado",
                                null,
                                HttpStatus.NOT_FOUND.value()
                        ),
                        HttpStatus.NOT_FOUND
                );
            }
        } catch (DataAccessException e) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error al acceder a los datos",
                            "No se pueden obtener los datos de La propuesta debido a un error de acceso a datos: " + e.getMostSpecificCause().getMessage(),
                            null,
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        } catch (Exception e) {
            // Captura otros errores no anticipados
            String detailedMessage = e.getCause() != null ? e.getCause().getMessage() : e.getMessage();
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno",
                            "Se produjo un error interno al obtener los datos del solicitante: " + detailedMessage,
                            null,
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> insertarPropuesta(PropuestaGuardarDTO dto) {
        try {
            // Verificar si se proporciona un idPropuesta
            if (dto.getIdPropuesta() != null) {
                var propuestaOptional = propuestaRepository.findById(dto.getIdPropuesta());
                if (propuestaOptional.isPresent()) {
                    var propuestaExistente = propuestaOptional.get();
                    propuestaMapper.toActualizarPropuesta(dto, propuestaExistente);

                    //var solicitante = solicitanteRepository.findById(dto.getIdSolicitante()).orElse(null);
                    //var estado = estadosRepository.findById(dto.getIdEstado()).orElse(null);
                    var areaEncargada = areaEncargadaRepository.findById(dto.getIdAreaEncargada()).orElse(null);

                    //propuestaExistente.setSolicitante(solicitante);
                    //propuestaExistente.setEstado(estado);
                    propuestaExistente.setAreaEncargada(areaEncargada);

                    // Guardar la propuesta actualizada
                    propuestaExistente = propuestaRepository.save(propuestaExistente);

                    return new ResponseEntity<>(
                            Util.setResponse(
                                    "Actualiza la propuesta",
                                    "Propuesta actualizada correctamente",
                                    dto,
                                    HttpStatus.OK.value()
                            ),
                            HttpStatus.OK
                    );
                }
            }

            // Si no se encontró la propuesta o no se proporcionó un idPropuesta, insertar una nueva propuesta
            var insertar = propuestaMapper.toPropuesta(dto);
            var solicitante = solicitanteRepository.findById(dto.getIdSolicitante()).orElse(null);
            var estado = estadosRepository.findById(dto.getIdEstado()).orElse(null);
            var areaEncargada = areaEncargadaRepository.findById(dto.getIdAreaEncargada()).orElse(null);

            insertar.setSolicitante(solicitante);
            insertar.setEstado(estado);
            insertar.setAreaEncargada(areaEncargada);

            // Guardar la nueva propuesta
            var insertarFinal = propuestaRepository.save(insertar);

            var insertarDto = propuestaMapper.toPropuestaGuardarDTO(insertarFinal, dto);

            return new ResponseEntity<>(
                    Util.setResponse(
                            "Agrega la propuesta",
                            "Propuesta insertada correctamente",
                            insertarDto,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception exception) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al procesar la solicitud",
                            "Error interno al procesar la solicitud",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @Override
    public ResponseEntity<?> obtenerPropuestaPorId(String idPropuesta) {
        try {
            var obtenerPropuesta = propuestaRepository.findById(idPropuesta);
            if (obtenerPropuesta.isPresent()) {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Lista la propuesta por id",
                                "Propuesta Obteneida Exitosamente",
                                propuestaMapper.toPropuestaDTO(obtenerPropuesta.get()),
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "No se encontro una propuesta con el ID proporcionado",
                                "No se encontro una propuesta con el ID proporcionado",
                                "",
                                HttpStatus.NOT_FOUND.value()
                        ),
                        HttpStatus.NOT_FOUND
                );
            }
        } catch (Exception exception) {
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
    public ResponseEntity<?> insertarContraprestaciones(ContraprestacionesDTO dto) {
        try {
            Propuesta contraprestaciones = this.propuestaRepository.findById(dto.getIdPropuesta()).get();
            propuestaMapper.actualizarPropuestaDesdeContraprestacionesDTO(contraprestaciones, dto);
            Propuesta propuestaContraprestaciones = propuestaRepository.save(contraprestaciones);

            return new ResponseEntity<>(
                    Util.setResponse(
                            "Se agrego las contraprestaciones",
                            "Se agrego las contraprestaciones",
                            dto,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );

        } catch (Exception exception) {
            return new ResponseEntity<>(
                    "Error interno",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Override
    public ResponseEntity<?> actualizarPropuesta(PropuestaActualizarDTO dto) {
        return null;
    }

}
