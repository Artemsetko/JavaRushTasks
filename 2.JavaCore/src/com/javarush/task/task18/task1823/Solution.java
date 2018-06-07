package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            s = reader.readLine();
            if (s.equals("exit")) break;
            else
                list.add(s);
        }
        for (String s1 : list) {
            ReadThread thread = new ReadThread(s1);
            thread.start();
            thread.join();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        FileInputStream fileReader;

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            this.fileName = fileName;
            fileReader = new FileInputStream(fileName);
        }

        int max = 0;
        int mostFrequencyByte;

        @Override
        public void run() {
            try {
                byte[] bytes = new byte[fileReader.available()];
                fileReader.read(bytes);
                fileReader.close();
                Arrays.sort(bytes);
                for (int i = 0; i < bytes.length; i++) {
                    int count = 0;
                    for (int j = 0; j < bytes.length; j++) {
                        if (bytes[i] == bytes[j]) {
                            count++;
                        } else {
                            if (count > max) {
                                max = count;
                                mostFrequencyByte = bytes[i];
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            resultMap.put(fileName, mostFrequencyByte);
          //  System.out.println(fileName + " ---> " + (char) mostFrequencyByte);
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
