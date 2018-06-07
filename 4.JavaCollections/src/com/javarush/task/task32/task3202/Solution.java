package com.javarush.task.task32.task3202;

import java.io.*;
import java.nio.Buffer;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("C:\\1.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) {
        StringWriter writer = new StringWriter();
        if (is == null) return new StringWriter();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        try {
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
        } catch (IOException e) {
            return writer;
        }
        return writer;
    }

}