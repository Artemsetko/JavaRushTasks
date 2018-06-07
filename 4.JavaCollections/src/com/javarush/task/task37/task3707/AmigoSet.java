package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AmigoSet<E> extends AbstractSet implements Set, Serializable, Cloneable {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, Math.ceil(collection.size() / .75f));
        map = new HashMap<>(capacity);
        this.addAll(collection);
    }

    @Override
    public boolean add(Object o) {
        E e = (E) o;
        if (map.containsKey(e))
            return false;
        else {
            map.put(e, PRESENT);
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        Set<E> set = map.keySet();
        Iterator<E> iterator = set.iterator();
        return iterator;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        Object obj = map.remove(o);
        if (obj != null)
            return true;
        else return false;
    }

    @Override
    public Object clone() {
        AmigoSet<E> amigoSet = null;
        try {
            amigoSet = (AmigoSet<E>) super.clone();
            amigoSet.map = (HashMap<E, Object>) this.map.clone();
        } catch (Exception e) {
            throw new InternalError();
        }
        return amigoSet;
    }

    private void writeObject(ObjectOutputStream oos) {
        float loadFactor = HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        int buckets = HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        try {
            oos.defaultWriteObject();
            oos.writeInt(buckets);
            oos.writeFloat(loadFactor);
            oos.writeInt(map.keySet().size());
            for (E e : map.keySet()) {
                oos.writeObject(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream is) {
        try {
            is.defaultReadObject();
            int buckets = is.readInt();
            float loadFactor = is.readFloat();
            int size = is.readInt();
            map = new HashMap<E, Object>(buckets, loadFactor);
            for (int i = 0; i < size; i++) {
                map.put((E) is.readObject(), PRESENT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void forEach(Consumer consumer) {

    }

    @Override
    public boolean removeIf(Predicate predicate) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }

}
