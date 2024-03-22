package com.comfama.api.propuestasCultura.business.tipoDocumento;

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
public class TipoDocumentoBusiness implements ITipoDocumentoBusiness{
    ITipoDocumentoRepository iTipoDocumentoRepository;
    @Override
    public ResponseEntity<?> obtenerTodosLosTipoDocumento() {
        try {
            var solicitanteList = iTipoDocumentoRepository.findAll();
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Lista de documentos",
                            "Documentos obtenidos exitosamente",
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
}
