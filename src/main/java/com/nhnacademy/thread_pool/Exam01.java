package com.nhnacademy.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam01 {
    public static void main(String[] args) {
        // ThreadPool 생성
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker" + i));
        }

        // 모든 작업이 완료될 때까지 대기
        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("모든 작업이 완료되었습니다.");
    }
}