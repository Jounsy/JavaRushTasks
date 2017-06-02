package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        String fileNameInput = args[0];
        String fileNameOutput = args[1];
        FileInputStream inputStream = new FileInputStream(fileNameInput);
        FileOutputStream outputStream = new FileOutputStream(fileNameOutput);

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String s = new String(buffer, utf8);
        buffer = s.getBytes(windows1251);
        outputStream.write(buffer);
        inputStream.close();
        outputStream.close();
    }
}
