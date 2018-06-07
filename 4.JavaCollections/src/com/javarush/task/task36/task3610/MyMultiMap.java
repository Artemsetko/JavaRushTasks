package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        int size = 0;
        for (Entry<K, List<V>> entry : map.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        V previous = null;
        if (map.containsKey(key) && map.get(key).size() < repeatCount) {
            previous = map.get(key).get(map.get(key).size() - 1);
            map.get(key).add(value);
        } else if (map.containsKey(key) && map.get(key).size() == repeatCount) {
            previous = map.get(key).get(map.get(key).size() - 1);
            map.get(key).remove(0);
            map.get(key).add(value);
        } else {
            map.put(key, new ArrayList<V>());
            map.get(key).add(value);
        }
        return previous;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        V removedElement = null;
        if (map.containsKey(key)) {
            if (map.get(key).size() > 0) {
                removedElement = map.get(key).remove(0);
                if (map.get(key).size() == 0) {
                    map.remove(key);
                }
            }
        }

        return removedElement;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        Set<K> keys = map.keySet();
        return keys;
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        ArrayList<V> values = new ArrayList<>();
        for (List<V> vList : map.values()) {
            for (V v : vList) {
                values.add(v);
            }
        }
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        boolean isPresent = false;
        for (List<V> vList : map.values()) {
            for (V v : vList) {
                if (v.equals((V) value)) {
                    isPresent = true;
                }
            }
        }
        return isPresent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}