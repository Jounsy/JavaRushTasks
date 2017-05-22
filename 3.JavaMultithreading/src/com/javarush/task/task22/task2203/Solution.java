package com.javarush.task.task22.task2203;

/*
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null)
            throw new TooShortStringException();
        int firstSpace = string.indexOf("\t");
        if (firstSpace == -1)
            throw new TooShortStringException();
        int lastSpace = string.indexOf("\t", firstSpace + 1);
        if (lastSpace == -1)
            throw new TooShortStringException();

        int startString = string.indexOf("\t");
        int endString = string.indexOf("\t",startString+1);
        String cutString = string.substring(startString+1,endString);

        return cutString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
