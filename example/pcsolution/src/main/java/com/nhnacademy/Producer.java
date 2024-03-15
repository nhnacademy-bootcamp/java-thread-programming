package com.nhnacademy;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Producer implements Runnable {
    Logger logger = LogManager.getLogger();

    String name;
    Market market;
    List<String> items;
    long waitingTime = 1000;

    public Producer(String name, String[] items, Market market) {
        this.name = name;
        this.market = market;
        this.items = Arrays.asList(items);
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        logger.info("판매자({})가 입장했습니다.", getName());

        for (String item : items) {
            if (market.sell(item, 0)) {
                logger.info("판매자({})가 {}을 납품 하였습니다.", getName(), item);
                market.report();
            } else {
                logger.warn("판매자({})가 {}의 재고 과다로 대기합니다.", getName(), item);

                if (market.sell(item, waitingTime)) {
                    logger.info("판매자({})가 {}을 납품 하였습니다.", getName(), item);
                    market.report();
                } else {
                    logger.error("판매자({})가 {} 판매 부진으로 납품하지 못하였습니다.", getName(), item);
                }
            }
        }

        logger.info("판매자({})가 퇴장합니다.", getName());
    }
}
