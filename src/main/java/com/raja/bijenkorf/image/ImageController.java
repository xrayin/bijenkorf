package com.raja.bijenkorf.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    /**
     * @param image A string containing image name with extension
     * @return Retrieved image file from ImageService
     * @throws Exception
     */
    @GetMapping("/images/{image}")
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImage(@PathVariable String image) throws Exception {

        return imageService.getImageAsResource(image);
    }
}
