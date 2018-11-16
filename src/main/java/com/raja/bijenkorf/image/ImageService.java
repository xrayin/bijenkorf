package com.raja.bijenkorf.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import javax.servlet.ServletContext;
import java.io.InputStream;

@Service
public class ImageService {

    @Autowired
    private ServletContext servletContext;

    /**
     * @param image A string containing image name with extension
     * @return Retrieved image file from the images folder with HTTP headers set to image meta data.
     * @throws Exception
     */
    public ResponseEntity<InputStreamResource> getImageAsResource(String image) throws Exception {

        InputStream file = ImageService.class.getResourceAsStream(this.getImageLocation(image));
        InputStreamResource resource = new InputStreamResource(file);
        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + image)
                // Content-Type
                .contentType(this.getMediaType(image))
                // Contet-Length
                .contentLength(file.available()) //
                .body(resource);
    }

    /**
     * @param image A string containing image name with extension
     * @return Image location based on image name that has been received
     */
    private String getImageLocation(String image) {

        return "/images/" + image;
    }

    /**
     * @param image
     * @return Mimetype based on image name that has been received
     */
    private MediaType getMediaType(String image) {

        String mimeType = servletContext.getMimeType(image);
        MediaType mediaType = MediaType.parseMediaType(mimeType);
        return mediaType;
    }
}
