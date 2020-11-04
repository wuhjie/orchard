package com.wu.common.utils;

import java.io.*;

/**
 * @ClassName ImageUtil
 * @Description
 * @Author wuhjie
 * @Data 2020/11/4 9:52 am
 * @Version 1.0
 **/
public class ImageUtil {

    /**
     * read local image
     * @param infile
     * @return
     */
    public static FileInputStream getImageByte (String infile) {
        FileInputStream imageByte = null;

        File file = new File(infile);

        try {
            imageByte = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return imageByte;
    }

    public static void readBlob (InputStream inputStream, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


