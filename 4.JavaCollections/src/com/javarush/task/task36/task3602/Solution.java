package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
*/
public class Solution<T> {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        for (Class aClass : Collections.class.getDeclaredClasses()) {
            if (Modifier.toString(aClass.getModifiers()).equals("private static")) {
                if (List.class.isAssignableFrom(aClass)) {
                    try {
                        Constructor constructor = aClass.getDeclaredConstructor();
                        constructor.setAccessible(true);
                        List list = (List) constructor.newInstance();
                        list.get(0);
                    } catch (IndexOutOfBoundsException e) {
                        return aClass;
                    } catch (NoSuchMethodException e) {

                    } catch (IllegalAccessException e) {

                    } catch (InstantiationException e) {

                    } catch (InvocationTargetException e) {

                    }
                }
            }
        }
        return null;
    }
}
