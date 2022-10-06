package com.example.threads;

import javafx.scene.effect.Light;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParallelPointInitSync {
    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Light.Point p = new Light.Point();

        Runnable r = () -> {
            int x = (int) (Math.random() * 1000), y = x;

            while (true){
                lock.lock();

                p.setX(x);  p.setY(y);
                int xc = (int) p.getX(), yc = (int) p.getY();
                //System.out.println("x= " + xc + ", y= " + yc);

                lock.unlock();
                if (xc != yc){
                    System.out.println("Aha: x= " + xc + ", y= " + yc);
                }
            }
        };

        System.out.println(lock.isLocked());
        new Thread(r).start();
        System.out.println(lock.getHoldCount());
        new Thread(r).start();
    }
}
