package com.sola.alittledemo.controller.Upload;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Sola
 * @date 2018/10/25
 */
@RestController
public class UploadFileController {

    @PostMapping("file/upload")
    public Object uploadFile(@RequestParam(value = "file") MultipartFile file) {

        String uploadFilePath = "/test.file";
        File test = new File(uploadFilePath);
        try {
            file.transferTo(test);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
