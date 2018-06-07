package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    List<File> listFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        String path = args[0];
        String resultFileAbsolutePath = args[1];

        File allFilesContent = new File(resultFileAbsolutePath);
        File newFileContent = new File(allFilesContent.getParentFile() + "/allFilesContent.txt");
        if (FileUtils.isExist(allFilesContent))
            FileUtils.renameFile(allFilesContent, newFileContent);

        s.searchSmallFiles(path);
        s.recordToFile(newFileContent);

    }

    public void searchSmallFiles(String path) {
        File file = new File(path);
        File[] fileNames = file.listFiles();
        for (File fileName : fileNames) {
            if (fileName.isDirectory()) {
                searchSmallFiles(fileName.getAbsolutePath());
            }
            if (fileName.length() <= 50 && fileName.isFile()) {
                listFiles.add(fileName);
            }
        }
        Collections.sort(listFiles);
    }

    public void recordToFile(File newFileContent) throws IOException{
        FileWriter writer = new FileWriter(newFileContent);

        for (File file : listFiles) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
            writer.write("\n");
            writer.flush();
            reader.close();
        }
        writer.flush();
        writer.close();
    }
}
