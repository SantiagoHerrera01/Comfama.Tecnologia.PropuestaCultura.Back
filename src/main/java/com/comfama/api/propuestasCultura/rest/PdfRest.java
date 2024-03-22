package com.comfama.api.propuestasCultura.rest;

import com.comfama.api.propuestasCultura.business.pdf.IPdfBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1.0")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PdfRest {
    @Autowired
    IPdfBusiness pdfBusiness;
    @PostMapping(value = "/convertToBinary", consumes = "multipart/form-data")
    public byte[] convertToBinary(@RequestParam("file") MultipartFile file) {
        try {
            byte[] binaryData = pdfBusiness.convertPdfToBinary(file);
            return binaryData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
