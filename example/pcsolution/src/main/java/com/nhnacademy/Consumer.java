package com.nhnacademy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Consumer implements Runnable {

    Logger logger = LogManager.getLogger();
    String name;
    Market market;
    List<String> targetList;
    List<String> purchaseList = new LinkedList<>();
    long waitingTime = 5000;

    public Consumer(String name, String[] targets, Market market) {
        this.name = name;
        this.market = market;
        targetList = Arrays.asList(targets);
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        logger.info("구매자({})가 입장했습니다.", getName());

        for (String item : targetList) {
            if (market.buy(item, 0)) {
                purchaseList.add(item);
                logger.info("구매자({})가 {}을 구매하였습니다.", getName(), item);
                market.report();
            } else {
                logger.warn("구매자({})가 {}이 납품되길 기다랍니다.", getName(), item);
                if (market.buy(item, waitingTime)) {
                    purchaseList.add(item);
                    logger.info("구매자({})가 {}을 구매하였습니다.", getName(), item);
                    market.report();
                } else {
                    logger.error("구매자({})가 {}을 품절로 구매하지 못하였습니다.", getName(), item);
                }
            }
        }

        logger.info("구매자({})가 {}을 구매하고 퇴장합니다.", getName(), purchaseList.toArray());
    }
}
