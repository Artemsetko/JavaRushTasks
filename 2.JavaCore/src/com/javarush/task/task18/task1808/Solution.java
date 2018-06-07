package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        try {
            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream1 = new FileOutputStream(fileName2);
            FileOutputStream outputStream2 = new FileOutputStream(fileName3);
            byte[] buffer;
            int size = inputStream.available();
            buffer = new byte[size / 2];


            while (inputStream.available() > 0) {
                int count = inputStream.read(buffer);
                if (inputStream.available() == size / 2 + 1) {
                    outputStream1.write(buffer, 0, count);
                    outputStream1.write(inputStream.read());
                } else if (inputStream.available() == size / 2) {
                    outputStream1.write(buffer, 0, count);
                }
                count = inputStream.read(buffer);
                outputStream2.write(buffer, 0, count);
            }
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
