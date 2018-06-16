package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            ArrayList<String> wordsList = new ArrayList<>();
            String str;
            while ((str = fileReader.readLine()) != null) {
                for (String word : str.split("\\s+")) {
                    if (!word.isEmpty())
                        wordsList.add(word);
                }
            }

            int wordcount = wordsList.size();
            for (int i = 0; i < wordcount; i++) {
                String reverse = new StringBuilder(wordsList.get(i)).reverse().toString();
                for (int j = 0; j < wordcount; j++) {
                    if (j != i && wordsList.get(j).equals(reverse)) {
                        Pair pair1 = new Pair(wordsList.get(i), wordsList.get(j));
                        Pair pair2 = new Pair(wordsList.get(j), wordsList.get(i));
                        if (!result.contains(pair1) && !result.contains(pair2))
                            result.add(pair1);
                    }
                }
            }

            for (Pair pair : result) {
                System.out.println(pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
