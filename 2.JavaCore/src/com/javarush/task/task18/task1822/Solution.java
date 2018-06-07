package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        sc.close();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (reader.ready()) {
            String found = reader.readLine();
            String id = found.split(" ")[0];
            if (id.equals(args[0])) {
                System.out.println(found);
                reader.close();
                break;
            }
        }
    }
}
