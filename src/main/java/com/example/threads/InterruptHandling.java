package com.example.threads;

public class InterruptHandling extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("Es gibt Leben vor dem Tod");

                while (!isInterrupted()) {
                    System.out.println("Und er läuft weiter und weiter");

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        interrupt();
                        System.out.println("Unterbrechung in Sleep()");
                    }
                }
                System.out.println("Das Ende");
            }
        };
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
