package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {
        State state = null;

        while (true) {
            State stateNew = target.getState();
            if (stateNew != state) {
                state = stateNew;
                System.out.println(state);
            }

            if (state == State.TERMINATED) {
                break;
            }
        }
    }
}
