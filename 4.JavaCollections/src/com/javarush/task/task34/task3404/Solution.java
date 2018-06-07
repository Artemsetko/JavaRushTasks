package com.javarush.task.task34.task3404;

import java.text.DecimalFormat;
import java.util.Locale;

/*
Рекурсия для мат. выражения
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recursion("sin(2*(-5+1.5*4)+28)", 0); //expected output 0.5 6
    }

    public void recursion(final String expression, int countOperation) {
        //implement
        Locale.setDefault(Locale.ENGLISH);
        String value = expression.replaceAll(" ","");
        DecimalFormat df = new DecimalFormat("#.##");

    }

    public Solution() {
        //don't delete
    }
}
