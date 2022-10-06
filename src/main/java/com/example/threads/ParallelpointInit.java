package com.example.threads;

import javafx.scene.effect.Light;
import java.util.*;

public class ParallelpointInit {
    public static void main(String[] args) {
        final Light.Point p = new Light.Point();

        Runnable r = () -> {
            int x = (int) (Math.random() * 1000), y = x;
            int n = 0;
            while (10 > n){

                p.setX(x);  p.setY(y);
                int xc = (int) p.getX(), yc = (int) p.getY();
                if (xc != yc){
                    System.out.println("Aha: x= " + xc + ", y= " + yc);
                    n++;
                }
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }
}
