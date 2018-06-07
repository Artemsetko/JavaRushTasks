package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface extends Runnable {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {

        private String fullFileName;
        private ArrayList<String> content;

        public ReadFileThread() {
            this.fullFileName = null;
            this.content = new ArrayList<>();
        }

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;
        }

        @Override
        public String getFileContent() {

            StringBuilder sb = new StringBuilder();
            for (String s1 : content) {
                sb.append(s1).append(" ");
            }
            return sb.toString();
        }

        @Override
        public void run() {
            try {
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                while (fileReader.ready()) {
                    content.add(fileReader.readLine());
                }
                fileReader.close();
            } catch (IOException e) {
                System.out.println("File " + fullFileName + " can't read");
            }
        }
    }
}
