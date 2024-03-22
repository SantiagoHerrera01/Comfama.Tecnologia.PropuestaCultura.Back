package com.comfama.api.propuestasCultura.business.formatosAdjuntosSolicitante;

import com.comfama.api.propuestasCultura.business.pdf.IPdfBusiness;
import com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO.FormatoAutorizacionTratamientoDatosDTO;
import com.comfama.api.propuestasCultura.domain.formatosAdjuntosSolicitanteDTO.FormatosRegimenInhabilidadesDTO;
import com.comfama.api.propuestasCultura.models.Propuesta;
import com.comfama.api.propuestasCultura.models.resProvider.resUploadFilesSharepoint.ResUploadFilesSharepoint;
import com.comfama.api.propuestasCultura.provider.IUploadFilesSharepoint;
import com.comfama.api.propuestasCultura.mapper.FormatosAdjuntosSolicitanteMapper;
import com.comfama.api.propuestasCultura.models.FormatosAdjuntosSolicitante;
import com.comfama.api.propuestasCultura.models.resProvider.ResTokenGraph;
import com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault.ResAzureKeyVault;
import com.comfama.api.propuestasCultura.provider.IAzureKeyVault;
import com.comfama.api.propuestasCultura.provider.IGenerarProvider;
import com.comfama.api.propuestasCultura.repository.IFormatosAdjuntosSolicitanteRepository;
import com.comfama.api.propuestasCultura.repository.IPropuestaRepository;
import com.comfama.api.propuestasCultura.util.Util;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FormatosAdjuntosSolicitanteBusinessImpl implements IFormatosAdjuntosSolicitanteBusiness {
    @Autowired
    IFormatosAdjuntosSolicitanteRepository formatosAdjuntosSolicitanteRepository;
    @Autowired
    FormatosAdjuntosSolicitanteMapper formatosAdjuntosSolicitanteMapper;
    @Autowired
    IPropuestaRepository iPropuestaRepository;
    @Autowired
    private IGenerarProvider generarProvider;
    @Autowired
    private IAzureKeyVault azureKeyVault;
    @Autowired
    private IPdfBusiness iPdfBusiness;
    @Autowired
    private IUploadFilesSharepoint iUploadFilesSharepoint;


    @Override
    public ResponseEntity<?> obtenerFormatosAdjuntos() {
        try {
            var listaFormatosAdjuntos = formatosAdjuntosSolicitanteRepository.findAll();
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Lista de propuestas",
                            "Fomatos obtenidos exitosamente",
                            listaFormatosAdjuntos,
                            HttpStatus.OK.value()
                    ),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    Util.setResponse(
                            "Error interno al obtener todos los formatos adjuntos",
                            "Error interno al obtener todos los formatos adjuntos",
                            "",
                            HttpStatus.INTERNAL_SERVER_ERROR.value()
                    ),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    @Override
    public ResTokenGraph getTokenGraph() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            headers.set("Cookie", "fpc=Ai7DMIbOWlpFtK7JzeX6xAWLGFq3AQAAAGL0Zt0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd");
            String body = "grant_type=client_credentials&client_id=" + "9cc6bfad-d5c6-4cf7-b2d7-3b7585fafac1" + "&client_secret=" + "vDO8Q~zHJ-5Kx3RXmkA59wCPtMBOWt91XtldFakz" + "&scope=" + "https://vault.azure.net/.default";

            ResponseEntity<String> responseEntity = generarProvider.getToken(body, headers);
            String jsonResponse = responseEntity.getBody();
            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, ResTokenGraph.class);

        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public ResAzureKeyVault getAzureKeyVault() {
        try {
            ResTokenGraph tokenGraph = getTokenGraph();

            String responseAccessToken = tokenGraph.getAccessToken();
            String responTokenType = tokenGraph.getTokenType();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", responTokenType + " " + responseAccessToken);
            headers.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            headers.set("Cookie", "fpc=Ai7DMIbOWlpFtK7JzeX6xAWLGFq3AQAAAGL0Zt0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd");

            ResponseEntity<String> azureKeyVaultResponse = azureKeyVault.getAzureKeyVault(headers);

            String jsonResponse = azureKeyVaultResponse.getBody();

            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, ResAzureKeyVault.class);

        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public ResTokenGraph getFinalToken() {
        try {
            ResAzureKeyVault azureKeyVault = getAzureKeyVault();
            String user = azureKeyVault.getTags().getUsuario();
            String password = azureKeyVault.getValue();

            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
            headers.set("Cookie", "fpc=Ai7DMIbOWlpFtK7JzeX6xAWLGFq3AQAAAGL0Zt0OAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd");

            String body = "grant_type=password&client_id=9cc6bfad-d5c6-4cf7-b2d7-3b7585fafac1" +
                    "&client_secret=vDO8Q~zHJ-5Kx3RXmkA59wCPtMBOWt91XtldFakz" +
                    "&scope=https://graph.microsoft.com/.default" +
                    "&userName=" + user +
                    "&password=" + password;
            ResponseEntity<String> responseEntity = generarProvider.getToken(body, headers);
            String jsonResponse = responseEntity.getBody();

            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, ResTokenGraph.class);

        } catch (Exception exception) {
            return null;
        }
    }

    @Override
    public ResUploadFilesSharepoint uploadFilesSharepoint(MultipartFile file, String name) {
        try {
            byte[] pdfBytes = iPdfBusiness.convertPdfToBinary(file);

            ResTokenGraph tokenGraph = getFinalToken();

            String responseAccessToken = tokenGraph.getAccessToken();
            String responTokenType = tokenGraph.getTokenType();

            String authorizationHeader = responTokenType + " " + responseAccessToken;

            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", authorizationHeader);
            headers.set("Content-Type", MediaType.APPLICATION_OCTET_STREAM_VALUE);

            ResponseEntity<String> responseEntity = iUploadFilesSharepoint.uploadFile(
                    name,
                    pdfBytes,
                    headers
            );

            String jsonResponse = responseEntity.getBody();

            Gson gson = new Gson();
            return gson.fromJson(jsonResponse, ResUploadFilesSharepoint.class);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public ResponseEntity<?> insertarArchivoFormatoAutorizacionTratamientoDatos(MultipartFile file, String idPropuesta) {
        try {
            FormatosAdjuntosSolicitante registroExistente = formatosAdjuntosSolicitanteRepository.obtenerPorIdPropuesta(idPropuesta);
            String name = idPropuesta + "_FATD.pdf";
            ResUploadFilesSharepoint archivoSubido = uploadFilesSharepoint(file, name);
            Propuesta propuesta = Propuesta.builder().idPropuesta(idPropuesta).build();

            if (registroExistente == null) {
                registroExistente = new FormatosAdjuntosSolicitante();
                registroExistente.setPropuesta(propuesta);
                registroExistente.setWebUrlFormatoTratamientoDatos(archivoSubido.getWebUrl());
                registroExistente.setFechaCreacionFormatoTratamientoDatos(archivoSubido.getCreatedDateTime());
                registroExistente.setRutaFormatoTratamientoDatos(archivoSubido.getPath().getPath());
            }

            registroExistente.setFechaCreacionFormatoTratamientoDatos(archivoSubido.getCreatedDateTime());
            registroExistente.setRutaFormatoTratamientoDatos(archivoSubido.getPath().getPath());
            registroExistente.setWebUrlFormatoTratamientoDatos(archivoSubido.getWebUrl());

            var guardado = formatosAdjuntosSolicitanteRepository.save(registroExistente);

            return new ResponseEntity<>(
                    Util.setResponse(
                            "Operación exitosa",
                            "Formato adjunto actualizado",
                            guardado,
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
    public ResponseEntity<?> insertarArchivoFormatoRegimenInhabilidades(MultipartFile file, String idPropuesta) {
        try {
            FormatosAdjuntosSolicitante registroExistente = formatosAdjuntosSolicitanteRepository.obtenerPorIdPropuesta(idPropuesta);
            String name = idPropuesta + "_FRI.pdf";
            ResUploadFilesSharepoint archivoSubido = uploadFilesSharepoint(file, name);
            Propuesta propuesta = Propuesta.builder().idPropuesta(idPropuesta).build();

            if (registroExistente == null) {
                registroExistente = new FormatosAdjuntosSolicitante();
                registroExistente.setPropuesta(propuesta);
                registroExistente.setWebUrlFormatoInhabilidades(archivoSubido.getWebUrl());
                registroExistente.setFechaCreacionFormatoInhabilidades(archivoSubido.getCreatedDateTime());
                registroExistente.setRutaFormatoInhabilidades(archivoSubido.getPath().getPath());
            }

            registroExistente.setWebUrlFormatoInhabilidades(archivoSubido.getWebUrl());
            registroExistente.setFechaCreacionFormatoInhabilidades(archivoSubido.getCreatedDateTime());
            registroExistente.setRutaFormatoInhabilidades(archivoSubido.getPath().getPath());

            var guardado = formatosAdjuntosSolicitanteRepository.save(registroExistente);

            return new ResponseEntity<>(
                    Util.setResponse(
                            "Operación exitosa",
                            "Formato adjunto actualizado",
                            guardado,
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


}
