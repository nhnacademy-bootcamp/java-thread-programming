package com.nhnacademy.daemon;

public class Worker extends RunnableCounter {
    RunnableCounter runnableCounter;

    public Worker(String name, int maxCount) {
        super(name, maxCount);
        runnableCounter = new RunnableCounter("internal workder", maxCount);
        runnableCounter.setDaemon(true);
    }

    @Override
    public void run() {
        runnableCounter.start();

        super.run();
    }
}
