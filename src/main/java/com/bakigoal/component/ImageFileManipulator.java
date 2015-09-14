package com.bakigoal.component;

import com.bakigoal.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * Created by bakigoal on 13.09.15.
 */
@Component
public class ImageFileManipulator {

    @Autowired
    private ServletContext servletContext;

    public String saveImage(String filename, MultipartFile image)
            throws RuntimeException, IOException {
        try {
            String filePath = "/WEB-INF/resources/images/" + filename;
            File file = new File(servletContext.getRealPath("/") + filePath);

            FileUtils.writeByteArrayToFile(file, image.getBytes());
            System.out.println("Go to the location:  " + file.toString()
                    + " on your computer and verify that the image has been stored.");
            return filename;
        } catch (IOException e) {
            throw e;
        }
    }

    public void validateImage(MultipartFile image) {
        if (!image.getContentType().equals("image/jpeg")) {
            throw new RuntimeException("Only JPG images are accepted");
        }
    }

    public void deleteImage(String filename) {
        String filePath = "/WEB-INF/resources/images/" + filename;
        File file = new File(servletContext.getRealPath("/") + filePath);
        FileUtils.deleteFile(file);
    }
}
