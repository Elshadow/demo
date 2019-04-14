package com.example.demo.singleton;

/**
 * 静态内部类-单例模式
 */
public class SampleSingleton2 {

    private static class SingletonHolder {
        private static final SampleSingleton2 INSTANCE = new SampleSingleton2();
    }

    private SampleSingleton2 () {

    }

    public static SampleSingleton2 getInstance () {
        return SingletonHolder.INSTANCE;
    }

}