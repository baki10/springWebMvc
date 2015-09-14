package com.bakigoal.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by bakigoal on 13.09.15.
 */
public class FileUtils {

    public static void writeByteArrayToFile(File file, byte[] bytes) {

        FileInputStream fileInputStream=null;

        try {
            //convert array of bytes into file
            FileOutputStream fileOuputStream = new FileOutputStream(file);
            fileOuputStream.write(bytes);
            fileOuputStream.close();

            System.out.println("Done");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteFile(File file) {
        if(file.delete()){
            System.out.println(file.getName() + " is deleted!");
        }else{
            System.out.println("Delete operation is failed.");
        }
    }
}
