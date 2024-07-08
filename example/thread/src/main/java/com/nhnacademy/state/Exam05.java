package com.nhnacademy.state;

public class Exam05 {
    public static void main(String[] args) throws InterruptedException {
        TimeWaitingThread timedWaiting = new TimeWaitingThread();
        timedWaiting.start();

        Thread.sleep(1000);
        System.out.println(timedWaiting.getState());
    }
}

class TimeWaitingThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}