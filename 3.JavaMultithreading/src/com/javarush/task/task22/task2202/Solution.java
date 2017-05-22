package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/*
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис "));
    }

    public static String getPartOfString(String string) {

        if (string == null)
            throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if (firstSpace == -1)
            throw new TooShortStringException();
        int lastSpace = string.indexOf(" ", firstSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ", lastSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();
        List<String> cuttedWords = new ArrayList<>();
        for(String str: string.split(" "))
        {
            cuttedWords.add(str);
        }
        if(cuttedWords.size()<5){throw new TooShortStringException();}
        StringBuilder mergeString = new StringBuilder(cuttedWords.get(1)+ " " + cuttedWords.get(2)+ " " + cuttedWords.get(3)+ " " + cuttedWords.get(4));

        return mergeString.toString();
    }

    public static class TooShortStringException extends RuntimeException {

    }
}
