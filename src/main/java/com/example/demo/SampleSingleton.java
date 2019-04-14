package com.example.demo;

/**
 * 双重校验锁-单例模式
 */

public class SampleSingleton {

    private static volatile SampleSingleton instance;

    /** 构造函数用private声明 */
    private SampleSingleton() {

    }

    public static SampleSingleton getInstance() {

        if (instance == null) {
            synchronized (SampleSingleton.class) {
                if (instance == null) {
                    instance = new SampleSingleton();
                }
            }
        }

        return instance;

    }

 }