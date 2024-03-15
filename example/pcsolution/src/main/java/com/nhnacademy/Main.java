package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Item[] items = new Item[] {
                new Item("사과", 3),
                new Item("배", 2),
                new Item("바나나", 5),
                new Item("키위", 3),
                new Item("수박", 2) };

        Market market = new Market(items);

        market.start();

        int consumerIndex = 0;
        int producerIndex = 0;
        int sequence = 0;
        while (!Thread.currentThread().isInterrupted()) {
            ++sequence;

            if (sequence % 3 == 0) {
                String[] targetItems = new String[1 + ThreadLocalRandom.current().nextInt(items.length)];
                for (int i = 0; i < targetItems.length; i++) {
                    targetItems[i] = items[ThreadLocalRandom.current().nextInt(items.length)].getName();
                }
                market.enter(new Consumer("고객" + (++consumerIndex), targetItems, market));
            }
            if (sequence % 2 == 0) {
                String[] productItems = new String[1 + ThreadLocalRandom.current().nextInt(items.length)];
                for (int i = 0; i < productItems.length; i++) {
                    productItems[i] = items[ThreadLocalRandom.current().nextInt(items.length)].getName();
                }
                market.enter(new Producer("농부" + (++producerIndex), productItems, market));
            }
            Thread.sleep(1000);
        }

        market.shutdown();

        market.join();
    }
}
