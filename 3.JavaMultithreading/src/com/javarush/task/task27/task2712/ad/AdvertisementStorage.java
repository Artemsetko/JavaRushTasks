package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {
    private static AdvertisementStorage instance;

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage() {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video",
                5000, 1, 3 * 60));// 3 min
        add(new Advertisement(someContent, "Second Video",
                100, 2, 15 * 60));//15 min
        add(new Advertisement(someContent, "Third Video",
                400, 1, 10 * 60));//10 min
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) instance = new AdvertisementStorage();
        return instance;
    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }


}
