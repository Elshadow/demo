package com.example.demo.designpatterns.builderpattern.interfaces.impl;

import com.example.demo.designpatterns.builderpattern.interfaces.Packing;

public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }

}