package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personInfo = fileScanner.nextLine();
            String[] parts = personInfo.split(" ");
            String firstName = parts[1];
            String midleName = parts[2];
            String lastName = parts[0];
            String month = parts[4];
            String day = parts[3];
            String year = parts[5];
            Date birthDate = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            String dateInString = day + " " + month + " " + year;
            try {
                birthDate = dateFormat.parse(dateInString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return new Person(firstName, midleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
