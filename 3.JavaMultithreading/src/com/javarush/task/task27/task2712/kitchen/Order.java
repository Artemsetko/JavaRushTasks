package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

/**
 * В классе Order (заказ) должна быть информация, относящаяся к списку выбранных пользователем блюд.
 * Т.е. где-то должен быть список всех блюд, и должен быть список выбранных блюд в классе Order.
 * */
public class Order {
    protected List<Dish> dishes;
    private final Tablet tablet;

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTablet() {
        return tablet;
    }

    protected void initDishes() throws IOException {
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public int getTotalCookingTime() {
        int totalDuration = 0;
        for (Dish dish : dishes) {
            totalDuration += dish.getDuration();
        }
        return totalDuration;
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        if (dishes == null || dishes.isEmpty()) {
            return "";
        }
        return "Your order: " + dishes + " of " + tablet + ", cooking time " + getTotalCookingTime() + "min";
    }

}
