package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        String content = new String(Files.readAllBytes(Paths.get(fileName)), StandardCharsets.UTF_8);
        String[] words = content.split("\\s+");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();

        if (words == null || words.length == 0) {
            return sb;
        }

        String[] copyWords = new String[words.length];
        System.arraycopy(words, 0, copyWords, 0, words.length);
        sb.append(copyWords[0]);
        copyWords[0] = "";

        if (copyWords.length == 1) {
            return sb;
        }

        char strFirstChar = Character.toUpperCase(sb.charAt(0));
        char strLastChar = Character.toUpperCase(sb.charAt(sb.length() - 1));

        while (true) {
            int addedCount = 0;
            for (int i = 0; i < copyWords.length; i++) {
                if (copyWords[i].length() > 0) {
                    if (firstChar(copyWords[i]) == strLastChar) {
                        sb.append(" " + copyWords[i]);
                        copyWords[i] = "";
                        strLastChar = Character.toUpperCase(sb.charAt(sb.length() - 1));
                        addedCount++;
                    } else if (lastChar(copyWords[i]) == strFirstChar) {
                        sb.insert(0, copyWords[i] + " ");
                        copyWords[i] = "";
                        strFirstChar = Character.toUpperCase(sb.charAt(0));
                        addedCount++;
                    }
                }
            }
            if (addedCount == 0) {
                break;
            }
        }
        for (String word : copyWords) {
            if (word.length() > 0) {
                sb.append(" " + word);
            }
        }
        return sb;
    }

    public static char firstChar(String str) {
        return str.substring(0, 1).toUpperCase().charAt(0);
    }

    public static char lastChar(String str) {
        return str.substring(str.length() - 1).toUpperCase().charAt(0);
    }
}
