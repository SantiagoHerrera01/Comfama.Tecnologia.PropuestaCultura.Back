package com.comfama.api.propuestasCultura.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "graphApiClient", url = "https://graph.microsoft.com")
public interface IUploadFilesSharepoint {
    @PutMapping("/v1.0/sites/191fbe37-4e18-46bd-81d2-4c9ccb2f1419/drive/root:/General/DocumentosSolicitanteDev/{filename}:/content")
    ResponseEntity<String> uploadFile(
            @PathVariable String filename,
            @RequestBody byte[] fileContents,
            @RequestHeader HttpHeaders headers
    );
}
