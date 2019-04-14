package com.example.demo.designpatterns.builderpattern.interfaces.impl;

import com.example.demo.designpatterns.builderpattern.interfaces.Packing;

public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }

}