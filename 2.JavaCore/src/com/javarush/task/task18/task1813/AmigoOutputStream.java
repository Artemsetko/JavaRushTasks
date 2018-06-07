package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream original;

    public AmigoOutputStream(FileOutputStream original) throws FileNotFoundException {
        super(fileName);
        this.original = original;
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }


    @Override
    public void write(int i) throws IOException {
        original.write(i);
    }

    @Override
    public void write(byte[] bytes) throws IOException {
        original.write(bytes);
    }

    @Override
    public void write(byte[] bytes, int i, int i1) throws IOException {
        original.write(bytes, i, i1);
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void close() throws IOException {
        flush();
        original.write("JavaRush © All rights reserved.".getBytes());
        original.close();
    }

    @Override
    public FileChannel getChannel() {
        return original.getChannel();
    }
}
