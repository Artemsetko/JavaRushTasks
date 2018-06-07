package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();
        reader.close();

        ArrayList<Integer> list = new ArrayList<>();

        FileInputStream fis2 = new FileInputStream(new File(name2));
        while (fis2.available() > 0) {
            int data = fis2.read();
            list.add(data);
        }
        fis2.close();

        FileInputStream fis1 = new FileInputStream(new File(name1));
        while (fis1.available() > 0) {
            int data = fis1.read();
            list.add(data);
        }
        fis1.close();

        FileOutputStream fos = new FileOutputStream(new File(name1));
        for (int integer : list) {
            fos.write(integer);
        }
        fos.close();

    }
}
