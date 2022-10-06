package com.example.threads;

import java.util.concurrent.TimeUnit;

public class SleepThread {


    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("Zeit ist um.");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println("Zeit ist um Withe TimeUnit.");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }).start();

        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(-4, 313144);
                    System.out.println("Zeit ist um Withe TimeUnit.");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.MINUTES.sleep(1);
                    System.out.println("Zeit ist um Withe TimeUnit With Minutes.");
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }.start();

    }
}
