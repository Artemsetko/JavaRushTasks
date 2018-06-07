package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(address);
            objectOutput.writeInt(year);
            objectOutput.flush();
        }

        @Override
        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            address = (String) objectInput.readObject();
            year = objectInput.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment a = new Apartment("Lenina", 1968);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        a.writeExternal(oos);
        System.out.println(a);

        ByteArrayInputStream bis = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);

        Apartment a1 = new Apartment();

        a1.readExternal(ois);
        System.out.println(a1);
        System.out.println(a1 == a);
    }
}
