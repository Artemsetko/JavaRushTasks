package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        String resultName = "";
        TreeSet<String> parts = new TreeSet<>();

        while (true) {
            fileName = reader.readLine();
            if (fileName.equals("end")) break;
            parts.add(fileName);
        }

        resultName = parts.first();
        resultName = resultName.replaceAll("\\.part1", "");

        File file = new File(resultName);

        //Если требуемого файла не существует.
        if (!file.exists()) {
            //Создаем его.
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file, true);
        byte[] buffer = new byte[1000];
        for (String part : parts) {
            FileInputStream fis = new FileInputStream(part);
            while (fis.available() > 0) {
                int count = fis.read(buffer);
                fos.write(buffer, 0, count);
            }
            fis.close();
        }
        fos.close();
    }
}
