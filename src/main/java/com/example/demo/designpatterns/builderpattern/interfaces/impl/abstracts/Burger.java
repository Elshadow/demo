package com.example.demo.designpatterns.builderpattern.interfaces.impl.abstracts;

import com.example.demo.designpatterns.builderpattern.interfaces.Item;
import com.example.demo.designpatterns.builderpattern.interfaces.Packing;
import com.example.demo.designpatterns.builderpattern.interfaces.impl.Wrapper;

public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}