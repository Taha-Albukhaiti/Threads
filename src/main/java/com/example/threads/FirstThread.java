package com.example.threads;

import java.util.concurrent.TimeUnit;

public class FirstThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new DataCommand());
        t1.start();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("Ich liebe Java");
                }
            }
        });
        t.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        //  Thread t2 = new Thread(new CounterCommand());
        //t2.start();

        //Thread dt = new DateThread();
        //dt.start();

        new DateThread();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        Thread tname = new Thread(new Moin(), "Moin thread");
        System.out.println("Name des Threads : " + tname.getName());
        tname.setName("Hello lo");
        System.out.println("Name des Threads : " + tname.getName());

    }

    static class Moin implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Moin moin!");
            }
        }
    }
}
