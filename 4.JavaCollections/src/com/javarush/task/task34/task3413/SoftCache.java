package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
        if (softReference == null) return null;
        else return softReference.get();
        //напишите тут ваш код
    }

    public AnyObject put(Long key, AnyObject value) {
        AnyObject previous;
        if (cacheMap.get(key) == null) return null;
        else {
            previous = cacheMap.get(key).get();
        }
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
        softReference.clear();
        return previous;
        //напишите тут ваш код
    }

    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if (softReference == null) return null;
        else {
            AnyObject result = softReference.get();
            softReference.clear();
            return result;
        }
        //напишите тут ваш код
    }
}