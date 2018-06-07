package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

//Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//создаем адаптер к классу PrintStream
        PrintStream stream = new MyStream(new PrintStream(outputStream));
//Устанавливаем его как текущий System.out
        System.setOut(stream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        System.out.println(result);

    }

    public static class MyStream extends PrintStream {

        private PrintStream printStream;
        private String advertising = "\nJavaRush - курсы Java онлайн";
        int count = 0;

        public MyStream(OutputStream outputStream) {
            super(outputStream);
        }

        public MyStream(PrintStream printStream) {
            super(printStream);
            this.printStream = printStream;
        }

        @Override
        public void println(String s) {
            if (count == 1) {
                printStream.println(s + advertising);
                count = 0;
            } else {
                printStream.println(s);
                count++;
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
