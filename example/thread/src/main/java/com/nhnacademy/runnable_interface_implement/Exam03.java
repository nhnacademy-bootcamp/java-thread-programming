package com.nhnacademy.runnable_interface_implement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Exam03 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.execute(new RunnableCounter("counter1", 3));
        pool.execute(new RunnableCounter("counter2", 3));

        pool.shutdown();
        System.out.println("Shutdown called");
        while (!pool.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("Not yet finished");
        }
        System.out.println("All service finished");
    }
}
