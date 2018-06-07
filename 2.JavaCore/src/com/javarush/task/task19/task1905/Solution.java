package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        String phoneNumber = "+38(050)123-45-67";
        System.out.println(phoneNumber);
        String result = phoneNumber.replaceAll("[^0-9+]","");
        System.out.println(result);
        result = "callto://" + result;
        System.out.println(result);
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryCode;
            for (String key : countries.keySet()) {
                if (countries.get(key).equals(customer.getCountryName())) {
                    countryCode = key;
                    return countryCode;
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();
            String[] partsName = fullName.split(" ");
            return partsName[1];
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();
            String[] partsName = fullName.split(" ");
            return partsName[0].substring(0, partsName[0].length() - 1);
        }

        @Override
        public String getDialString() {
            String phoneNumber = contact.getPhoneNumber();
            String dialString = phoneNumber.replaceAll("[^0-9+]","");
            dialString = "callto://" + dialString;
            return dialString;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}