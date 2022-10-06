package com.example.threads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = () -> {
            System.out.println("A1 " + Thread.currentThread());
            System.out.println("A2 " + Thread.currentThread());
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("B1 " + Thread.currentThread());
                System.out.println("B2 " + Thread.currentThread());
            }
        };

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(r1);
        executorService.execute(r2);

        Thread.sleep(500);

        executorService.execute(r1);
        executorService.execute(r2);

        //executorService.shutdown();
        List<Runnable> runnableList = executorService.shutdownNow();
        runnableList.forEach(System.out::println);
    }
}

