package com.nhnacademy.stop;

public class ThreadUnlimitedCounter extends Thread {
    String name;
    int count;

    public ThreadUnlimitedCounter(String name) {
        this.name = name;
        count = 0;
    }

    @Override
    public void run() {
        while (Thread.interrupted()) {
            try {
                ++count;
                System.out.println(name + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }
}