package com.example.threads;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CallableGetDemo {
    //private List<Future> list = new ArrayList<>();
    private static final Collection<Callable<byte[]>> callableList = new ArrayList<>();
    public static void main(String[] args) {
        byte[] b = new byte[40];
        new Random().nextBytes(b);

        byte[] bb = new byte[]{2, 1, 9, 11, 8,6};
        Callable<byte[]> c = new SorterCallable(b);
        Callable<byte[]> cc = new SorterCallable(bb);
        ExecutorService service = Executors.newCachedThreadPool();
        callableList.add(cc);
        callableList.add( c);
        System.out.println(callableList.size());
        try {
             List<Future<byte[]>> list = service.invokeAll(callableList);
             list.stream()
                     .map(m -> {
                         try {
                             return m.get();
                         } catch (InterruptedException | ExecutionException e) {
                             throw new RuntimeException(e);
                         }
                     }).toList().stream().map(m -> m.length).forEach(System.out::println);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        /*

        ExecutorService service = Executors.newCachedThreadPool();
        Future<byte[]> result = service.submit(c);

        //byte[] m = new byte[0];
        byte[] m = new byte[0];
        try {
             m = result.get();
            //m = result.get(1, MILLISECONDS);
        } catch (InterruptedException | ExecutionException  e) {
            //System.out.println(e.getMessage());;
            e.printStackTrace();
        }

        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i]);
        }

         */
        service.shutdown();


    }
}
