package com.netflix.clone.com.netflix.clone.util;

import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandlerUtil {
    private FileHandlerUtil() {}

    public static String extractFileExtension(String orignalFilename){
        String fileExtension = "";
        if(orignalFilename != null && orignalFilename.contains(".")){
            fileExtension = orignalFilename.substring(orignalFilename.lastIndexOf("."));
        }
        return fileExtension;
    }

    public static Path findFileByUuid(Path directory,String uuid) throws Exception{
        return Files.list(directory).filter(path-> path.getFileName().toString().startsWith(uuid))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("File not found for UUID" +uuid));
    }
}
