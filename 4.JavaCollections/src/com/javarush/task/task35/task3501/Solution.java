package com.javarush.task.task35.task3501;

import java.util.ArrayList;
import java.util.List;

/*
Вызов статического метода
*/
public class Solution {
   static ArrayList<? extends Number> ll = new ArrayList<>();

    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));
        ll = new ArrayList<Number>();
    }
}
