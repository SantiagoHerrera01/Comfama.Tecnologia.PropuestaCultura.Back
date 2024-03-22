package com.comfama.api.propuestasCultura.business.pdf;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IPdfBusiness {
    byte[] convertPdfToBinary(MultipartFile file)throws IOException;
}
