package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> outputQueue = new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        File dir = new File(root);

        outputQueue.add(dir);
        while (outputQueue.peek() != null) {
            File file = outputQueue.remove();
            for (File file1 : file.listFiles()) {
                if(file1.isDirectory()){
                    outputQueue.add(file1);
                    continue;
                }
                list.add(file1.getAbsolutePath());
            }
        }

        return list;
    }

    public static void main(String[] args) throws IOException{
        //System.out.println(getFileTree("C:\\tree"));
    }
}
