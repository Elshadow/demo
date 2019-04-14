package com.example.demo.designpatterns.builderpattern.items;

import com.example.demo.designpatterns.builderpattern.interfaces.impl.abstracts.Burger;

public class VegBurger extends Burger {
 
    @Override
    public float price() {
       return 25.0f;
    }
  
    @Override
    public String name() {
       return "Veg Burger";
    }

 }