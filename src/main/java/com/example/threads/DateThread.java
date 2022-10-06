package com.example.threads;

public class DateThread extends Thread{
    @Override public void run(){
        for (int i = 0; i < 20; i++){
            System.out.println("Hello Welt: " + new java.util.Date());
        }
    }
    DateThread() {
        start();
    }
}
