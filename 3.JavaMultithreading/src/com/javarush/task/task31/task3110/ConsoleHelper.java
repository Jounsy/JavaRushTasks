package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Work-TESTER on 23.08.2017.
 */
public class ConsoleHelper {

    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = null;
        try {
            readLine =reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;
    }
    public static int readInt(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer readLine = null;
        try {
            readLine = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLine;

    }
}
