package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestOrder extends Order {
    public TestOrder(Tablet tablet) throws IOException {
        super(tablet);
    }

 /*   @Override
    protected void initDishes() throws IOException {

        int randomValuesDishesInTestOrder = (int) Math.round(Math.random() * 9 + 1);
        int valueVariantsOfDishes = Dish.values().length;
        ArrayList<Dish> arrayDishes = new ArrayList<>(Arrays.asList(Dish.values()));

        for (int i = 0; i < randomValuesDishesInTestOrder; i++) {
            dishes.add(arrayDishes.get((int) Math.round(Math.random() * (valueVariantsOfDishes - 1))));
        }

    }*/

    @Override
    protected void initDishes() throws IOException {
        int numberOfDishes = 1;
        dishes = new ArrayList<>();
        int maxDishes = (int) (Math.random() * Dish.values().length);
        numberOfDishes += (int)(Math.random() * (maxDishes*10-1));
        for (int i = 0; i < numberOfDishes ; i++) {
            int dish = (int)(Math.random()*Dish.values().length);
            dishes.add(Dish.values()[dish]);
        }

    }
}