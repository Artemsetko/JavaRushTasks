/*
package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable {

    private String name;
    private boolean busy;

    public boolean isBusy() {return busy;}

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Cook(String name) {this.name = name;}

    @Override
    public String toString() {return name;}

    public void startCookingOrder (Order order) {
        //Order order = (Order)arg;
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()+", cooking time "+order.getTotalCookingTime()+"min");
        setChanged();
        notifyObservers(order);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), this.name, order.getTotalCookingTime(),order.getDishes()));
        try {
            Thread.sleep(10*order.getTotalCookingTime());
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        busy = false;

    }
}*/
package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;

public class Cook extends Observable implements Runnable{
    private String name;
    private boolean busy;
    private boolean stopped = false;
    private boolean caught = false;

    private LinkedBlockingQueue<Order> queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public boolean isBusy() {
        return busy;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }


    public void startCookingOrder (Order order) {
        //Order order = (Order)arg;
        busy = true;
        ConsoleHelper.writeMessage("Start cooking - " + order.toString()+", cooking time "+order.getTotalCookingTime()+"min");
        setChanged();
        notifyObservers(order);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(), this.name, order.getTotalCookingTime(),order.getDishes()));
        try {
            Thread.sleep(10*order.getTotalCookingTime());
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage(e.getMessage());
        }
        busy = false;

    }

    @Override
    public void run() {
        while (!stopped){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (queue.peek()!=null){

                if (!this.isBusy()) {
                    try{
                        //final Cook cookFinal = cook;
                        Order order = queue.take();
                        if (order!=null){
                            //Thread tr = new Thread(()->
                            startCookingOrder(order);
                            //tr.start();
                        }
                    }
                    catch (InterruptedException e){caught = true;}
                }
            }
            if (caught&&queue.isEmpty()) stopped=true;
        }
    }
}
