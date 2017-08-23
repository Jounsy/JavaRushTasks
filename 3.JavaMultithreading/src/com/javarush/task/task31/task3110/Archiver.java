package com.javarush.task.task31.task3110;

import com.javarush.task.task31.task3110.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Work-TESTER on 16.08.2017.
 */
public class Archiver {
    public static void main(String[] args) {
        System.out.println("Enter full path to archive");
        BufferedReader readerArchive = new BufferedReader(new InputStreamReader(System.in));
        String fullArchivePath = null;
        try {
            fullArchivePath = readerArchive.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path absoluteArchivePath = Paths.get(fullArchivePath);
        ZipFileManager zipFileManager = new ZipFileManager(absoluteArchivePath);

        System.out.println("Enter full path to file");
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(System.in));
        String fullFilePath = null;
        try {
            fullArchivePath = readerFile.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path absoluteFilePath = Paths.get(fullArchivePath);
        try {
            zipFileManager.createZip(absoluteFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ExitCommand exitCommand = new ExitCommand();
        try {
            exitCommand.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
