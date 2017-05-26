package com.javarush.task.task18.task1801;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream readBytes = new FileInputStream(fileName);

        int biggerByte = 0;
        while (readBytes.available()!=0)
        {
            int bytesInFile = readBytes.read();
            if (biggerByte<bytesInFile)
            {
                biggerByte=bytesInFile;
            }

        }
        readBytes.close();
        System.out.println(biggerByte);
    }
}
