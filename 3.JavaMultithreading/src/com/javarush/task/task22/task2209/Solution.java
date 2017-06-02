package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
 private static String argumentString;
 static List<StringBuilder> mainList;
 public static void main(String[] args) {
        //...
        BufferedReader readFileName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = readFileName.readLine();
            readFileName.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder allWords = new StringBuilder();
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String oneString = null;
            while((oneString = fileReader.readLine())!=null)
            {
                for(String oneWord: oneString.split(" "))
                {
                    allWords.append(oneWord + " ");
                }
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder result = getLine((allWords.toString()).trim());
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        if(words == null || words.length==0)return new StringBuilder("");
        if (words[0].equals("")) return new StringBuilder(words[0]);

        argumentString = words[0];
        mainList = new ArrayList<>();
        mainList.add(new StringBuilder());

        Set<String> wordsMain = splitString(Solution.argumentString);
        Iterator<String> itrWordsMain = wordsMain.iterator();

            while (itrWordsMain.hasNext()) {
                String currentWord = itrWordsMain.next();

               mainList.add(addWordsToReturningList(currentWord));
                itrWordsMain.remove();
            }

         return findBiggestValueInMainList(mainList);
    }

    public static StringBuilder findBiggestValueInMainList(List mainList)
    {
        StringBuilder stringReturn = new StringBuilder();
        for(Object biggest: mainList)
        {
            if(biggest.toString().length()>stringReturn.toString().length())
            {
                stringReturn = (StringBuilder)biggest;
            }
        }
        return new StringBuilder(stringReturn);
    }

    public static String findBiggestStringInList(List<String> listWithWords)
    {
        String biggestString = "";
        for(String string: listWithWords)
        {
            if(string.length()>biggestString.length()) biggestString = string;
        }
        return biggestString;
    }

    public static StringBuilder addWordsToReturningList(String currentWord)
    {
        List<String> addCurrentWithEqualsWords = new ArrayList<>();
        addCurrentWithEqualsWords.add(currentWord);

        TreeSet<String> wordsSet;
        String localCurrentWord;
        int countRecords = addCurrentWithEqualsWords.size();
        for(int i = 0; i < countRecords;i++)
        {
            wordsSet =  splitString(Solution.argumentString);

            localCurrentWord = addCurrentWithEqualsWords.get(i);
            wordsSet = clearCurrentSet(localCurrentWord,wordsSet);
            Iterator<String> itrWordaSet = wordsSet.iterator();
            while(itrWordaSet.hasNext())
            {
                String nextWord = itrWordaSet.next();
                if (cutLastCharacter(localCurrentWord).equals(cutFirstCharacter(nextWord)))
                {
                    addCurrentWithEqualsWords.add(localCurrentWord + " " + nextWord);
                    countRecords++;
                    itrWordaSet.remove();
                }
            }

        }
        return new StringBuilder(findBiggestStringInList(addCurrentWithEqualsWords));
    }

    private static TreeSet clearCurrentSet(String localCurrentWord, TreeSet<String> wordsSet) {
     TreeSet<String> clearWords = splitString(localCurrentWord);
     for (String words: clearWords)
     {
         wordsSet.remove(words);
     }
     return wordsSet;
    }

    public static String cutLastCharacter(String word){
        String lastCharacter = word.substring(word.length()-1);
        return lastCharacter.toLowerCase();
    }
    public static String cutFirstCharacter(String word){
        String firstCharacter = word.substring(0,word.length()-(word.length()-1));
        return firstCharacter.toLowerCase();
    }
    public static TreeSet<String> splitString(String string)
    {
        TreeSet<String> wordsList = new TreeSet<>();

        for (String oneWord : string.split(" ")) {
            wordsList.add(oneWord);
        }
        return wordsList;
    }
}
