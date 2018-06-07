package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = null;
        PrintStream outputStream = System.out;
        try {
            fileInputStream = new FileInputStream(reader.readLine());
            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                outputStream.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}