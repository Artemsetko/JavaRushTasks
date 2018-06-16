package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());

        Horse horse1 = new Horse("Артём", 3, 0);
        Horse horse2 = new Horse("Ирина", 3, 0);
        Horse horse3 = new Horse("Вита", 3, 0);

        game.horses.add(horse1);
        game.horses.add(horse2);
        game.horses.add(horse3);

        game.run();
        game.printWinner();
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        double distance = 0;
        Horse winner = null;
        for (Horse horse : horses) {
            if (horse.getDistance() > distance) {
                distance = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.printf(" Winner is %s!", getWinner().getName());
    }
}
