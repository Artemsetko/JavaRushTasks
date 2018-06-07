package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        String inputURL = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputURL = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] parseURL = inputURL.split("\\?");
        String[] parametrs = parseURL[1].split("\\&");
        LinkedHashMap<String, String> paramters = new LinkedHashMap<String, String>();
        for (String parametr : parametrs) {
            if (parametr.contains("=")) {
                for (int i = 0; i < parametr.length(); i++) {
                    char s = parametr.charAt(i);
                    if (s == '=') {
                        /*keys.add(parametr.substring(0, i));
                        values.add(parametr.substring(i + 1, parametr.length()));*/
                        paramters.put(parametr.substring(0, i), parametr.substring(i + 1, parametr.length()));
                    }
                }
            } else {
                paramters.put(parametr, null);
            }
        }
        //key printing
        for (String key : paramters.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
        String objParameter = paramters.get("obj");
        if (objParameter == null) {
            return;
        }

        try {
            alert(Double.parseDouble(objParameter));
        } catch (NumberFormatException e) {
            alert(objParameter);
        }
    }
    

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
