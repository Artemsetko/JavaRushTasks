package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public Properties prop = new Properties();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileProperties = bufferedReader.readLine();
        bufferedReader.close();
        FileInputStream fileInputStream = new FileInputStream(fileProperties);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.clear();
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            prop.put(entry.getKey(), entry.getValue());
        }
        prop.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        prop.load(inputStream);
        for (Map.Entry<Object, Object> entry : prop.entrySet()) {
            properties.put((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
