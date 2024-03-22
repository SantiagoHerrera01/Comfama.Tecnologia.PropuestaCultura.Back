package com.comfama.api.propuestasCultura.business.solicitantesBusiness;

import com.comfama.api.propuestasCultura.domain.solicitante.SolicitanteGuardarDTO;
import com.comfama.api.propuestasCultura.mapper.SolicitantesMapper;
import com.comfama.api.propuestasCultura.repository.ISolicitanteRepository;
import com.comfama.api.propuestasCultura.repository.ITipoDocumentoRepository;
import com.comfama.api.propuestasCultura.util.Util;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class SolicitantesBusiness implements ISolicitantesBusiness {

    ISolicitanteRepository iSolicitanteRepository;
    SolicitantesMapper solicitantesMapper;
    ITipoDocumentoRepository iTipoDocumentoRepository;
    public ResponseEntity<?> obtenerTodosLosSolicitantes() {
        try {
            var solicitanteList = iSolicitanteRepository.findAll();
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Lista de solicitantes",
                            "Solicitantes obtenidos exitosamente",
                            solicitanteList,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception error) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener el solicitante",
                            "Error interno al obtener el solicitante",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @Override
    public ResponseEntity<?> obtenerSolicitantePorId(Integer idSolicitante) {
        try {
            //Aplicar Validaciones necesarias
            var solicitanteListId = iSolicitanteRepository.findById(idSolicitante);
            if (solicitanteListId.isPresent()) {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "Solicitante obtenido por id",
                                "Solicitante obtenido exitosamente",
                                solicitantesMapper.toSolicitanteDTO(solicitanteListId.get()),
                                HttpStatus.OK.value()
                        ),
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        Util.setResponse(
                                "No se encontro un solicitante con el ID proporcionado",
                                "No se encontro un solicitante con el ID proporcionado",
                                "",
                                HttpStatus.NOT_FOUND.value()
                        ),
                        HttpStatus.NOT_FOUND
                );
            }
        } catch (Exception error) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener el solicitante",
                            "Error interno al obtener el solicitante",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @Override
    public ResponseEntity<?> agregarSolicitante(SolicitanteGuardarDTO dto) {
        try {
            if (dto.getIdSolicitante() != null) {
                var solicitanteOptional = iSolicitanteRepository.findById(dto.getIdSolicitante());
                if (solicitanteOptional.isPresent()) {
                    var solicitanteExistente = solicitanteOptional.get();
                    solicitantesMapper.toSolicitanteActualizar(dto, solicitanteExistente);

                    var tipoDocumento = iTipoDocumentoRepository.findById(dto.getIdTipoDocumento()).orElse(null);

                    solicitanteExistente.setTipoDocumento(tipoDocumento);

                    solicitanteExistente = iSolicitanteRepository.save(solicitanteExistente);


                    return new ResponseEntity<>(
                            Util.setResponse(
                                    "Actualiza el solicitante",
                                    "Solicitante actualizado correctamente",
                                    dto,
                                    HttpStatus.OK.value()
                            ),
                            HttpStatus.OK
                    );
                }
            }
            var insertar = solicitantesMapper.toSolicitante(dto);

            var tipoDocumento =iTipoDocumentoRepository.findById(dto.getIdTipoDocumento()).orElse(null);
            insertar.setTipoDocumento(tipoDocumento);

            var insertarFinal = iSolicitanteRepository.save(insertar);

            var insertarDto =solicitantesMapper.toSolicitanteGuardar(insertarFinal,dto);

            return new ResponseEntity<>(
                    Util.setResponse(
                            "Agrega el solicitante",
                            "Solicitante agregado correctamente",
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
}
