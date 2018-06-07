package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {

    static long totalFileCount;
    static long totalDirCount;
    static long totalSize;

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String pathName = conReader.readLine();
        Path path = Paths.get(pathName);

        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(path, new Visitor());

        System.out.println("Всего папок - " + (totalDirCount - 1));
        System.out.println("Всего файлов - " + totalFileCount);
        System.out.println("Общий размер - " + totalSize);


    }

    public static class Visitor extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            totalDirCount++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            totalSize += basicFileAttributes.size();
            totalFileCount++;
            return FileVisitResult.CONTINUE;
        }
    }
}
