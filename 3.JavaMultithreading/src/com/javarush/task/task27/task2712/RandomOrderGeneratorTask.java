package com.javarush.task.task27.task2712;

import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {

    List<Tablet> tabletList;
    private int interval;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int interval) {
        this.tabletList = tabletList;
        this.interval = interval;
    }

    @Override
    public void run() {

        // генерим случайный заказ

        if (tabletList.size() > 0) {
            while (!Thread.currentThread().isInterrupted()) {
                Tablet randomTablet = tabletList.get( (int) (Math.random() * tabletList.size() - 1));
                randomTablet.createTestOrder();
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

    }
}
