package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Work-TESTER on 28.07.2017.
 */
public class ConsoleHelper {

    static private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static public void writeMessage(String message){

        System.out.println(message);

    }

    static public String readString(){
        boolean isRead = true;

        String readingString;
        do {
            readingString = null;

            try {
                readingString = reader.readLine();
                isRead = true;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз");
                isRead = false;

            }
        } while (!isRead);

        return readingString;
    }


    static public int readInt(){
        boolean isReadInt = true;

        Integer readingInt;
        do {
            readingInt = null;

            try {
                readingInt = Integer.parseInt(readString());
                isReadInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка\n" +
                        "при попытке ввода числа. Попробуйте еще раз.");

                isReadInt = false;
            }
        } while (!isReadInt);
        return (int)readingInt;
    }

}
