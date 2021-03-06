package com.javarush.task.task22.task2207;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
         Set<String> wordReverseSet = new HashSet<>();
         List<String> wordAllSet = new ArrayList<>();

        BufferedReader readWord = new BufferedReader(new FileReader(fileName));
        String stringFromFile;

        while((stringFromFile=readWord.readLine())!=null)
        {
            for(String str: stringFromFile.split(" "))
            {
              wordAllSet.add(str);
            }
        }
         readWord.close();

        Iterator<String> itr = wordAllSet.iterator();
         while(itr.hasNext())
         {
             String real = new StringBuilder(itr.next()).toString();
             String reverse = new StringBuilder(real).reverse().toString();


             itr.remove();

             if (wordAllSet.contains(reverse) && !wordReverseSet.contains(real))
             {
                 Pair pair = new Pair();
                 pair.first = real;
                 pair.second = reverse;
                 result.add(pair);
                 wordReverseSet.add(real);
             }
             else {
                 if (wordAllSet.contains(reverse) && wordReverseSet.contains(real)) {

                     wordReverseSet.remove(real);
                 }

             }
         }


    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
