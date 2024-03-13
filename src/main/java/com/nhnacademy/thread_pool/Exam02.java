package com.nhnacademy.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam02 {

    public static void main(String[] args) {
        String[] urls = {
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.go2pyBWXRZ6IXN3whxDFtg",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.YQloTWfJRz24Xhq2aVSGgw",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.DwdVMtMaTmOFS_mQebo56w",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.e2pbYnmHT_mRPWZZ3Z511Q",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.p0sB3Ke2Tt64uXFPa1sU5A",
                "https://nhnacademy.dooray.com/share/drive-files/ocfkrcbb5vui.gYevNY21TIOphjrtV1Bznw"

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
