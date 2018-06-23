package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    // какую сумму заработали на рекламе, сгруппировать по дням
    public void printAdvertisementProfit() {
        Map<Date, Double> advProfit = StatisticManager.getInstance().calculateProfit();

        double sum = 0.00;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (Map.Entry<Date, Double> d : advProfit.entrySet()) {
            System.out.println(simpleDateFormat.format(d.getKey()) + " - " + String.format(Locale.ENGLISH, "%(.2f", d.getValue()));
            sum += d.getValue();
        }
        ConsoleHelper.writeMessage("Total - " + String.format(Locale.ENGLISH, "%(.2f", sum));
    }

    // загрузка (рабочее время) повара, сгруппировать по дням
    public void printCookWorkloading() {
        Map<Date, TreeMap<String, Integer>> timeOfWorks = StatisticManager.getInstance().calculateTimeOfWork();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        boolean firstLine = true;

        for (Map.Entry<Date, TreeMap<String, Integer>> e : timeOfWorks.entrySet()) {
            ConsoleHelper.writeMessage((firstLine ? "" : "\n") + simpleDateFormat.format(e.getKey()));

            for (Map.Entry<String, Integer> m : e.getValue().entrySet()) {
                ConsoleHelper.writeMessage(m.getKey() + " - " + (int) Math.ceil(m.getValue() / 60.0d) + " min");
            }
            firstLine = false;
        }

    }

    StatisticAdvertisementManager statisticAdvertisementManager = StatisticAdvertisementManager.getInstance();

    // список активных роликов и оставшееся количество показов по каждому
    public void printActiveVideoSet() {
        List<Advertisement> activeVideos = statisticAdvertisementManager.getActiveVideos();

        Comparator<Advertisement> comparator = (Advertisement a, Advertisement b) -> {
            return a.getName().compareToIgnoreCase(b.getName());
        };
        Collections.sort(activeVideos, comparator);

        for (Advertisement ad : activeVideos) {
            System.out.println(ad.getName() + " - " + ad.getHits());
        }

    }

    // список неактивных роликов (с оставшемся количеством показов равным нулю)
    public void printArchivedVideoSet() {
        List<Advertisement> archivedVideos = statisticAdvertisementManager.getArchivedVideos();

        Comparator<Advertisement> comparator = (Advertisement a, Advertisement b) -> {
            return a.getName().compareToIgnoreCase(b.getName());
        };
        Collections.sort(archivedVideos, comparator);

        for (Advertisement ad : archivedVideos) {
            System.out.println(ad.getName());
        }
    }
}






























