package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
      //  BufferedReader reader = new BufferedReader(new FileReader(fileName));
//        String jsonString = reader.readLine();
//        StringReader stringReader = new StringReader(jsonString);
        T value = mapper.readValue(new FileReader(new File(fileName)), clazz);
        return value;
    }

    public static void main(String[] args) {

    }
}
