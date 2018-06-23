package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    Object content; //видео
    String name; //имя/название
    long initialAmount; //начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    int hits; //количество оплаченных показов
    int duration; //продолжительность в секундах
    long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits != 0) amountPerOneDisplaying = initialAmount/hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    // после покаа вызываем чтобы уменьшить кол-во проплаченных показов
    public void revalidate(){
        if (hits <= 0){
            throw new UnsupportedOperationException();
        }
        hits--;
    }

    public int getHits() {
        return hits;
    }
}
