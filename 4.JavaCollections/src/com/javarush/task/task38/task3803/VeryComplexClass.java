package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object a = "Aa";
        Integer d;
        d = (Integer) a;
    }

    public void methodThrowsNullPointerException() {
        String a = null;
        a.length();
    }

    public static void main(String[] args) {

    }
}
