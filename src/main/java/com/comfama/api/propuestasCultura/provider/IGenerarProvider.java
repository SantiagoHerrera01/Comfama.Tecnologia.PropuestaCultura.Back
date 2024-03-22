package com.comfama.api.propuestasCultura.provider;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "authenticationClient", url = "https://login.microsoftonline.com")
public interface IGenerarProvider {
    @PostMapping("/495d6c4a-8473-48c8-a619-03516fd96d8f/oauth2/v2.0/token")
    ResponseEntity<String> getToken(@RequestBody String body, @RequestHeader HttpHeaders headers);
}
