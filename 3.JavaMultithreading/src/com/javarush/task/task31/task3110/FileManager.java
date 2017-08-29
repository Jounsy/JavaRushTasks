package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Work-TESTER on 28.08.2017.
 */
public class FileManager{

    private Path rootPath = null;
    private List<Path> fileList = null;

    public FileManager(Path rootPath) throws IOException{
    this.rootPath = rootPath;
    fileList = new ArrayList<>(); //список относительных путей файлов
    collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

   private void collectFileList(Path path) throws IOException{

       // Добавляем только файлы
       if (Files.isRegularFile(path)) {
           Path relativePath = rootPath.relativize(path);
           fileList.add(relativePath);
       }

       // Добавляем содержимое директории
       if (Files.isDirectory(path)) {
           // Рекурсивно проходимся по всему содержмому директории
           // Чтобы не писать код по вызову close для DirectoryStream, обернем вызов newDirectoryStream в try-with-resources
           try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
               for (Path file : directoryStream) {
                   collectFileList(file);
               }
           }
       }
   }
}
