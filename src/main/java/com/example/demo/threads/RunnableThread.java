package com.example.demo.threads;

public class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("runnable thread running");
    }

}