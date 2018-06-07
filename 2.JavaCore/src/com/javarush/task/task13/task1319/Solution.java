package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter outStream = new BufferedWriter(new FileWriter(fileName));

        String line = null;

        do {
            line = reader.readLine() + "\r\n";
            outStream.write(line);

        } while (!line.equals("exit"+ "\r\n"));

        outStream.close();
    }
}

