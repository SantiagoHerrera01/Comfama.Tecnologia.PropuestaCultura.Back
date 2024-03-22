package com.comfama.api.propuestasCultura.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "azureKey", url = "https://tecnologia.vault.azure.net")
public interface IAzureKeyVault {

    @GetMapping("/secrets/KV-UsrPropuestaCultura/5f5fe87043be4a938f01ba41a4afc621?api-version=7.4")
    ResponseEntity<String> getAzureKeyVault(@RequestHeader HttpHeaders headers);
}


