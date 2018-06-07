package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            int[] a = {1, 2, 4};
            a[4] = 5;
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            String s = "sss";
            int a = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            System.out.println(s.charAt(0));
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            String s = "ss";
            System.out.println(s.charAt(4));
        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object o = new Object();
            Integer a = (Integer) o;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            Object[] o = new String[3];
            o[0] = new Integer(2);
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            int a = -10;
            int[] b = new int[a];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }


        try {
            throw new IllegalAccessException("demo");
        } catch (IllegalAccessException e10) {
            exceptions.add(e10);
        }



    }
}
