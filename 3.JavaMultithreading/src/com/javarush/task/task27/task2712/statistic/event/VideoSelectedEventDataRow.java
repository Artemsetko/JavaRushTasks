package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Date;
import java.util.List;

public class VideoSelectedEventDataRow implements EventDataRow {

    private Date currentDate;
    private List<Advertisement> optimalVideoSet; //список видео-роликов, отобранных для показа
    private long amount; //сумма денег в копейках
    private int totalDuration; //общая продолжительность показа отобранных рекламных роликов

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount,
                                     int totalDuration) {
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;
        currentDate = new Date();
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public EventType getType() {
        return EventType.SELECTED_VIDEOS;
    }

    @Override
    public int getTime() {
        return totalDuration;
    }

    @Override
    public Date getDate() {
        return currentDate;
    }
}
