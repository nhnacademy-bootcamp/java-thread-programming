package com.nhnacademy.synchronization.exam02;

public class SharedCounter extends Thread {
    SharedCount sharedCount;
    int count;
    int maxCount;

    public SharedCounter(String name, int maxCount, SharedCount sharedCount) {
        setName(name);
        this.sharedCount = sharedCount;
        this.maxCount = maxCount;
        count = 0;
    }

    @Override
    public void run() {
        while (count < maxCount) {
            count++;
            sharedCount.increment();
        }
    }
}
