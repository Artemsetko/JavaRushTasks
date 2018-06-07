package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/

import java.util.Stack;

public class Solution {
   static int t = 0;
    public static void main(String[] args) {
        int count = 3;
        moveRing('A', 'B', 'C', count);
    }

    public static void moveRing(char a, char b, char c, int count) {
        //напишите тут ваш код
        System.out.println("t = " + ++t);
        if (count == 1) {
            System.out.println("//from a to b --> a = " + a + " b = " + b + " c = " + c + " count = " + count);
            System.out.println(String.format("from %s to %s", a, b));
        } else {
            System.out.println("//было до замены b на с а с на b 1 --> a = " + a + " b = " + b + " c = " + c + " count = " + count);
            moveRing(a, c, b, count - 1);
            System.out.println("//стало после замены b на с а с на b 1 --> a = " + a + " b = " + b + " c = " + c + " count = " + count);
            System.out.println(String.format("from %s to %s", a, b) +" count "+count);
            System.out.println("//было до замены a , b, c на с, b, a 2 --> a = " + a + " b = " + b + " c = " + c + " count = " + count);
            moveRing(c, b, a, count - 1);
            System.out.println("//стало после замены a , b, c на с, b, a --> a = " + a + " b = " + b + " c = " + c + " count = " + count);
        }
    }
}
