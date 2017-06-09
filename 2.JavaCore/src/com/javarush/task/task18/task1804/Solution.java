package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        Map<Integer,Integer> mapBytes = new HashMap<Integer,Integer>();
        List<Integer> listBytes = new ArrayList<Integer>();
        FileInputStream inputStream = new FileInputStream(fileName);


        while (inputStream.available() > 0)
        {
            listBytes.add(inputStream.read());
        }

        for (int i = 0;i<listBytes.size();i++)
        {
            boolean putYes = mapBytes.size()==0?true:false;

            for (Map.Entry<Integer, Integer> entry : mapBytes.entrySet())
            {
                if(listBytes.get(i).equals(entry.getKey()))
                {
                    entry.setValue(entry.getValue() + 1);
                    putYes = false;
                    break;
                }
                else{putYes = true;}
            }
            if(putYes)
            {
                mapBytes.put(listBytes.get(i), 1);
            }

        }






        String stroke = "";
        int tmp = 0;


        for (Map.Entry<Integer,Integer> entry: mapBytes.entrySet())
        {
            if (entry.getValue()>tmp) {
                tmp = entry.getValue();
            }
        }

        int min = tmp;
        for (Map.Entry<Integer,Integer> entry: mapBytes.entrySet())
        {
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
        }



        for (Map.Entry<Integer,Integer> entry: mapBytes.entrySet())
        {

            if (entry.getValue()== min) {
                stroke += (entry.getKey()+ " ");
            }

        }
        System.out.println(stroke.trim());
        reader.close();
        inputStream.close();
    }
}
