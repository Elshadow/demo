package com.example.demo.designpatterns.builderpattern.items;

import com.example.demo.designpatterns.builderpattern.interfaces.impl.abstracts.Burger;

public class ChickenBurger extends Burger {
 
    @Override
    public float price() {
       return 50.5f;
    }
  
    @Override
    public String name() {
       return "Chicken Burger";
    }

 }