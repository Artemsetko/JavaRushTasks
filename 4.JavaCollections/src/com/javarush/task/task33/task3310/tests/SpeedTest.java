package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SpeedTest {
    public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long startTime = new Date().getTime();
        for (String string : strings) {
            ids.add(shortener.getId(string));
        }

        return new Date().getTime() - startTime;
    }

    public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long startTime = new Date().getTime();
        for (Long id : ids) {
            strings.add(shortener.getString(id));
        }

        return new Date().getTime() - startTime;
    }

    @Test
    public void testHashMapStorage() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();

        Shortener shortener1 = new Shortener(hashMapStorageStrategy);
        Shortener shortener2 = new Shortener(hashBiMapStorageStrategy);

        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            origStrings.add(Helper.generateRandomString());
        }

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        long time1 = getTimeForGettingIds(shortener1, origStrings, ids1);
        long time2 = getTimeForGettingIds(shortener2, origStrings, ids2);
        Assert.assertTrue(time1 > time2);

        long time3 = getTimeForGettingStrings(shortener1, ids1, new HashSet<String>());
        long time4 = getTimeForGettingStrings(shortener2, ids2, new HashSet<String>());
        Assert.assertEquals(time3, time4, 30);

    }
}
