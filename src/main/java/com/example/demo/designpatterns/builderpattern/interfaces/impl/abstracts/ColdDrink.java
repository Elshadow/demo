package com.example.demo.designpatterns.builderpattern.interfaces.impl.abstracts;

import com.example.demo.designpatterns.builderpattern.interfaces.Item;
import com.example.demo.designpatterns.builderpattern.interfaces.Packing;
import com.example.demo.designpatterns.builderpattern.interfaces.impl.Bottle;

public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}