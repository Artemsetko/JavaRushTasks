package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        params.forEach((k, v) -> {
            if (k != null && v != null) result.append(k).append(" = '").append(v).append("' and ");
        });
        if (result.length() == 0) return "";
        return result.delete(result.lastIndexOf(" and"), result.length()).toString();
    }
}
