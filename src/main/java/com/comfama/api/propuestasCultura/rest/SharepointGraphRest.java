package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.formatosAdjuntosSolicitante.IFormatosAdjuntosSolicitanteBusiness;
import com.comfama.api.propuestasCultura.models.resProvider.ResTokenGraph;
import com.comfama.api.propuestasCultura.models.resProvider.resUploadFilesSharepoint.ResUploadFilesSharepoint;
import com.comfama.api.propuestasCultura.models.resProvider.resAzureKeyVault.ResAzureKeyVault;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1.0")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SharepointGraphRest {

    private final IFormatosAdjuntosSolicitanteBusiness formatosAdjuntosSolicitanteBusiness;

    @PostMapping(value = "/getTokenGraph")
    public ResTokenGraph getTokenGraph() {
        return formatosAdjuntosSolicitanteBusiness.getTokenGraph();
    }

    @GetMapping(value = "/getTokenAzure")
    public ResAzureKeyVault getAzureKeyVault() {
        return formatosAdjuntosSolicitanteBusiness.getAzureKeyVault();
    }

    @PostMapping(value = "/getFinalToken")
    public ResTokenGraph getFinalToken() {
        return formatosAdjuntosSolicitanteBusiness.getFinalToken();
    }

    @PutMapping(value = "/upload", consumes = "multipart/form-data")
    public ResUploadFilesSharepoint uploadFilesSharepoint(@RequestBody MultipartFile file, @RequestParam String name) {
        return formatosAdjuntosSolicitanteBusiness.uploadFilesSharepoint(file, name);
    }

}

