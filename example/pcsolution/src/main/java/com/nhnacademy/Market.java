package com.nhnacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Market extends Thread {
    ExecutorService consumers = Executors.newFixedThreadPool(5);
    ExecutorService producers = Executors.newFixedThreadPool(3);
    Map<String, Semaphore> things = new HashMap<>();
    Map<String, Semaphore> trays = new HashMap<>();
    Logger logger = LogManager.getLogger();

    public Market(Item[] items) {
        for (Item item : items) {
            trays.put(item.getName(), new Semaphore(item.getStock()));
            things.put(item.getName(), new Semaphore(0));
        }
    }

    public void enter(Consumer consumer) {
        consumers.execute(consumer);
    }

    public void enter(Producer producer) {
        producers.execute(producer);
    }

    public boolean buy(String item, long timeout) {
        if (!things.containsKey(item)) {
            return false;
        }

        try {
            if (!things.get(item).tryAcquire(timeout, TimeUnit.MILLISECONDS)) {
                return false;
            }

            trays.get(item).release();

            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public boolean sell(String item, long timeout) {
        if (!things.containsKey(item)) {
            return false;
        }

        try {
            if (!trays.get(item).tryAcquire(timeout, TimeUnit.MILLISECONDS)) {
                return false;
            }

            things.get(item).release();

            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    public synchronized void report() {
        StringBuilder string = new StringBuilder();
        for (Entry<String, Semaphore> entry : things.entrySet()) {
            if (!string.isEmpty()) {
                string.append(", ");
            }
            string.append(entry.getKey() + ":" + entry.getValue().availablePermits());
        }

        logger.info("재고는 {} 입니다.", string);
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void shutdown() {
        consumers.shutdown();
        producers.shutdown();

        this.interrupt();
    }
}
