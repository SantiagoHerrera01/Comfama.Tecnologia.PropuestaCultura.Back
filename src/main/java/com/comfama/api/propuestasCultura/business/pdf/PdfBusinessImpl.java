package com.comfama.api.propuestasCultura.business.pdf;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PdfBusinessImpl implements IPdfBusiness {

    @Override
    public byte[] convertPdfToBinary(MultipartFile file) throws IOException {
        try (InputStream pdfInputStream = file.getInputStream();
             PDDocument document = PDDocument.load(pdfInputStream);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            document.save(baos);
            return baos.toByteArray();
        }
    }

}
