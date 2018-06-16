package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        Charset windows1251 = Charset.forName("Windows-1251");

        String s = new String(Files.readAllBytes(Paths.get(args[0])), windows1251);
        Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(args[1]), "UTF-8"));
        try {
            out.write(s);
        } finally {
            out.close();
        }
    }
}
