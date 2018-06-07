package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();


        BufferedReader file1reader = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2reader = new BufferedReader(new FileReader(fileName2));

        ArrayList<String> original = new ArrayList<>();
        ArrayList<String> modified = new ArrayList<>();

        while (file1reader.ready()) {
            original.add(file1reader.readLine());
        }
        file1reader.close();

        while (file2reader.ready()) {
            modified.add(file2reader.readLine());
        }

        file2reader.close();

        while (original.size() != 0 && modified.size() != 0) {
            if (original.get(0).equals(modified.get(0))) {
                lines.add(new LineItem(Type.SAME, original.remove(0)));
                modified.remove(0);
            } else if (original.size() != 1 && original.get(1).equals(modified.get(0))) {
                lines.add(new LineItem(Type.REMOVED, original.remove(0)));
            } else if (modified.size() != 1 && original.get(0).equals(modified.get(1))) {
                lines.add(new LineItem(Type.ADDED, modified.remove(0)));
            }
        }
        if (modified.size() != 0) {
            lines.add(new LineItem(Type.ADDED, modified.remove(0)));
        } else if (original.size() != 0) {
            lines.add(new LineItem(Type.REMOVED, original.remove(0)));
        }


        for (LineItem line : lines) {
            System.out.println(line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString() + " " + line;
        }
    }
}
