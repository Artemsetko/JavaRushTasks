package com.javarush.task.task18.task1812;

import java.io.*;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {

    private AmigoOutputStream container;

    public QuestionFileOutputStream(AmigoOutputStream container) {
        this.container = container;
    }

    @Override
    public void flush() throws IOException {
        container.flush();
    }

    @Override
    public void write(int b) throws IOException {
        container.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        container.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        container.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(input.equals("Д")){
            container.close();
        }
    }
}

