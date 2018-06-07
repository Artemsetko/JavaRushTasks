package com.javarush.task.task34.task3412;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Properties;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        logger.debug("Debug message, initialize value1=" + value1 + " value2=" + value2 + " value3=" + value3);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution(11, "value 22", new Date());
        solution.setValue1(1);
        solution.setValue2("value 2");
        solution.setValue3(new Date());
        solution.calculateAndSetValue3(143);
        solution.printString();
        solution.printDateAsLong();
        solution.divide(6, 0);

    }

    public void calculateAndSetValue3(long value) {
        logger.trace("Trace message: in method calculateAndSetValue3");
        value -= 133;
        if (value > Integer.MAX_VALUE) {
            value1 = (int) (value / Integer.MAX_VALUE);
            logger.debug("Debug message: change value1 = " + value1 + " in method");
        } else {
            value1 = (int) value;
            logger.debug("Debug message: change value1 = " + value1 + " in method");
        }
    }

    public void printString() {
        logger.trace("Trace message: in method printString");
        if (value2 != null) {
            System.out.println(value2.length());
        }
    }

    public void printDateAsLong() {
        logger.trace("Trace message: in method printDateAsLong");
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
    }

    public void divide(int number1, int number2) {
        logger.trace("Trace message: in method divide");
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
            logger.error("Error message: Это сообщение об Ошибке number1 " + number1 + " divide number2 " + number2);
        }
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("Debug message: set value1 = " + value1 + " in method");
    }

    public void setValue2(String value2) {
        this.value2 = value2;
        logger.debug("Debug message: set value2 = " + value2 + " in method");
    }

    public void setValue3(Date value3) {
        this.value3 = value3;
        logger.debug("Debug message: set value3 = " + value3 + " in method");
    }
}
