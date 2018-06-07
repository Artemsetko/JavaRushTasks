package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.util.Date;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static void main(String[] args) {
        System.out.println(ExceptionFactory.getException(ExceptionApplicationMessage.SOCKET_IS_CLOSED).getMessage());

    }
}