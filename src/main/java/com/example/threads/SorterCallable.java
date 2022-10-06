package com.example.threads;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class SorterCallable implements Callable<byte[]> {

    private final byte[] b;
    SorterCallable(byte[] b){
        this.b = b;
    }


    @Override
    public byte[] call() throws Exception {
        Arrays.sort(b);
        return b;
    }
}
