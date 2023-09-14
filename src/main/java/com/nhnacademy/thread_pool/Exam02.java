package com.nhnacademy.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam02 {

    public static void main(String[] args) {
        String[] urls = { "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.JMwL9-kHTKKJ6YhS-Xykpg",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.CH51Oh3xTaSSmHwhVhYrgQ",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.6xuIQS1YSESJmigo2ECzQw",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.xzEwVuqrTVm23HKK_vCm0Q",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.X_otcNhCRKWruinRW2gyFA",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.WXsaSz-ARo2DryGsEK0S_w"

        };
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Runnable worker = new DownloadWorker(url);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("모든 다운로드가 완료되었습니다.");
    }
}
