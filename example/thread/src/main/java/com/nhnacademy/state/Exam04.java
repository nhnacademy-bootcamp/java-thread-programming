package com.nhnacademy.state;

public class Exam04 {
    public static void main(String[] args) throws InterruptedException {
        RunnableCounter counter = new RunnableCounter("counter", 10);

        WaitingCounter waitingCounter = new WaitingCounter(counter);

        counter.start();
        waitingCounter.start();

        Thread.State state = waitingCounter.getThread().getState();
        System.out.println(state);

        while (waitingCounter.isAlive()) {
            if (state != waitingCounter.getThread().getState()) {
                state = waitingCounter.getThread().getState();
                System.out.println(state);
            }
        }
    }
}
