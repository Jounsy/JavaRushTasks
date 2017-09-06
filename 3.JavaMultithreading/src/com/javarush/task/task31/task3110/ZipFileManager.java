package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.exception.PathIsNotFoundException;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Work-TESTER on 16.08.2017.
 */
public class ZipFileManager {
    private Path zipFile;

    public ZipFileManager(Path zipFile){
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path path = Paths.get(zipFile.getParent().toString());

        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) { //Файл архива

            if(Files.isRegularFile(source)){
            addNewZipEntry(zipOutputStream,source.getParent(),source.getFileName());
            }
            else if(Files.isDirectory(source)){

                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList();
                for(Path list : fileNames){
                    addNewZipEntry(zipOutputStream,source,list);
                }
                //5.3N
            }
            else{
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception{

        try(InputStream inputStream = Files.newInputStream(filePath.resolve(fileName))) {
            ZipEntry entry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(entry);
            copyData(inputStream,zipOutputStream);
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception{
        int n;
        while ((n = in.read()) != -1){
            out.write(n);
        }
    }


}
