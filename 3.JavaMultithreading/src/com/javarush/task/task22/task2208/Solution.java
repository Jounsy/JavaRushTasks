package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    Map<String,String> map = new HashMap<>();
    map.put("name",null);
    map.put("country",null);
    map.put("city","Kiev");
    map.put("age","sixteen");
        System.out.println(String.format(getQuery(map)));
    }
    public static String getQuery(Map<String, String> params)
    {
        StringBuilder stringQuery = new StringBuilder();
        int i = 0;
        for(Map.Entry<String,String> entry: params.entrySet())
        {
            if(entry.getValue()!=null)
            {
                stringQuery.append(entry.getKey()+" = "+"'"+entry.getValue()+"'");
                if(i >= 0 && i < params.size()-1)
                {
                    stringQuery.append(" and ");
                }
            }
          i++;
        }
        return stringQuery.toString();
    }
}
