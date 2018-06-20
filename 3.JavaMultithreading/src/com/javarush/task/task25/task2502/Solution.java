package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            String[] wheels = loadWheelNamesFromDB();
            if (wheels.length == 0 || wheels.length != 4) throw new Exception();
            List<Wheel> result = new ArrayList<>();
            for (String wheel : wheels) {
                Wheel carWheel = null;
                try {
                    carWheel = Wheel.valueOf(wheel);
                    result.add(carWheel);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(e);
                } catch (NullPointerException ex) {
                    throw new NullPointerException();
                }
            }
            this.wheels = result;
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
    }
}
