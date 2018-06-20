package com.javarush.task.task27.task2705;

/* 
Второй вариант deadlock
*/
public class Solution {
    private final Object lock = new Object();
/*если сначала сработает блокировка synchronized firstMethod на объекте , а потом synchronized(lock) во secondMethod. На этом все остановиться...*/
    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}