package com.example.threads;

public class DaemonThread extends  Thread{
    DaemonThread(){
        setDaemon(true);
    }
    @Override public void run(){
        while (true){
            System.out.println("Lauf, Thread , lauf");
        }
    }

    public static void main(String[] args) {
        Thread t =  new DaemonThread();
        t.start();
        System.out.println(t.isDaemon());
    }
}
