package com.comfama.api.propuestasCultura.business.formatosAdjuntosSolicitante;

import com.comfama.api.propuestasCultura.models.resProvider.ResTokenGraph;
import com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault.ResAzureKeyVault;
import com.comfama.api.propuestasCultura.models.resProvider.resUploadFilesSharepoint.ResUploadFilesSharepoint;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface IFormatosAdjuntosSolicitanteBusiness {
    ResponseEntity<?> obtenerFormatosAdjuntos();

    ResponseEntity<?> insertarArchivoFormatoAutorizacionTratamientoDatos(MultipartFile file, String idPropuesta);

    ResponseEntity<?> insertarArchivoFormatoRegimenInhabilidades(MultipartFile file, String idPropuesta);

    ResTokenGraph getTokenGraph();

    ResAzureKeyVault getAzureKeyVault();

    ResTokenGraph getFinalToken();

    ResUploadFilesSharepoint uploadFilesSharepoint(MultipartFile file, String name);
}
