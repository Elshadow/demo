package com.example.demo.designpatterns.builderpattern;

import com.example.demo.designpatterns.builderpattern.items.ChickenBurger;
import com.example.demo.designpatterns.builderpattern.items.Coke;
import com.example.demo.designpatterns.builderpattern.items.Pepsi;
import com.example.demo.designpatterns.builderpattern.items.VegBurger;

public enum MealBuilder {

    INSTANCE;

    // private volatile static MealBuilder intance;

    // private MealBuilder() {};

    // public static MealBuilder getInstance() {

    //     if (intance == null) {
    //         synchronized (MealBuilder.class) {
    //             if (intance == null) {
    //                 intance = new MealBuilder();
    //             }
    //         }
    //     }

    //     return intance;

    // }


    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareChickenMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}