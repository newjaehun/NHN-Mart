package com.nhnacademy.mart;

import java.util.ArrayList;

public class FoodStand {

    public ArrayList<Food> getFoods() {
        return foods;
    }

    private final ArrayList<Food> foods = new ArrayList<>();

    public void add(Food food) {
        foods.add(food);
    }

    public void delete(Food food){
        foods.remove(food);


    }
}