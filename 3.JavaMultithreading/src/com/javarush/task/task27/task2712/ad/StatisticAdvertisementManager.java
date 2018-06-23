package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    static StatisticAdvertisementManager instance;

    private StatisticAdvertisementManager() {
    }
    public static StatisticAdvertisementManager getInstance() {
        if (instance == null) instance = new StatisticAdvertisementManager();
        return instance;
    }

    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
    List<Advertisement> allAds = advertisementStorage.list();

    public List<Advertisement> getActiveVideos() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : allAds) {
            if (ad.hits > 0) result.add(ad);
        }
        return result;
    }
    public List<Advertisement> getArchivedVideos() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement ad : allAds) {
            if (ad.hits == 0) result.add(ad);
        }
        return result;
    }


}