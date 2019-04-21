package com.example.demo.threads;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("callable thread running");
        return "runnable";
    }

}