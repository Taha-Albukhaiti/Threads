package com.example.threads;

import javafx.scene.chart.PieChart;

public class DataCommand implements Runnable{
    @Override public void run(){
        for (int i = 0; i < 20; i++){
            System.out.println(new java.util.Date());
        }
    }

}
