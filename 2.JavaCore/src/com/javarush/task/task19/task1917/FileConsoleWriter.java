package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {

    private FileWriter fileWriter;


    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        String s = new String(cbuf);
        System.out.println(s.substring(off, off + len));
    }

    public void write(char[] chars) throws IOException {
        fileWriter.write(chars);
        System.out.println(chars);
    }


    public void write(int i) throws IOException {
        fileWriter.write(i);
        System.out.println(i);
    }


    public void write(String s, int i, int i1) throws IOException {
        fileWriter.write(s, i, i1);
        System.out.println(s.substring(i, i + i1));
    }

    public void write(String s) throws IOException {
        fileWriter.write(s);
        System.out.println(s);
    }

    public void close() throws IOException {
        fileWriter.close();
    }



    public static void main(String[] args) {

    }

}
