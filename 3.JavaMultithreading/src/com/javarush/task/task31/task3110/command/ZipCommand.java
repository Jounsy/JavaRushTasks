package com.javarush.task.task31.task3110.command;

import com.javarush.task.task31.task3110.ConsoleHelper;
import com.javarush.task.task31.task3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Work-TESTER on 23.08.2017.
 */
public abstract class ZipCommand implements Command{

    public ZipFileManager getZipFileManager() throws Exception{

        ConsoleHelper.writeMessage("Введите полный путь до файла архива");
        String readPath = ConsoleHelper.readString();
        Path path = Paths.get(readPath);
        ZipFileManager zipFileManager = new ZipFileManager(path);
        return zipFileManager;
    }
}
