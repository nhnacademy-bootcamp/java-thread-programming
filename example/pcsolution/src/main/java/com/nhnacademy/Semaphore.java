package com.nhnacademy;

import java.util.concurrent.TimeUnit;

public class Semaphore {
    int permits;

    public Semaphore(int permits) {
        this.permits = permits;
    }

    public synchronized boolean tryAcquire(long timeout, TimeUnit timeUnit) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long timeoutMS = timeUnit.convert(timeout, TimeUnit.MILLISECONDS);

        while (permits <= 0) {
            wait(timeoutMS);
            if (startTime + timeoutMS <= System.currentTimeMillis()) {
                return false;
            }
        }

        --permits;

        return true;
    }

    public synchronized void release() {
        ++permits;
        notifyAll();
    }

    public int availablePermits() {
        return permits;
    }
}
