package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(reader.readLine(), true);
        FileInputStream file2 = new FileInputStream(reader.readLine());
        FileInputStream file3 = new FileInputStream(reader.readLine());

        while (file2.available() > 0) {
            int data = file2.read();
            file1.write(data);
        }
        while (file3.available() > 0) {
            int data = file3.read();
            file1.write(data);
        }
        file1.close();
        file2.close();
        file3.close();
    }
}
