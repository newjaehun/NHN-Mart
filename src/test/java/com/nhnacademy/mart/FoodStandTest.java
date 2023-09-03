package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FoodStandTest {
    @Test
    @DisplayName("FoodStand.add 테스트")
    void addTest(){
        FoodStand foodStand = new FoodStand();
        Food food = new Food("사과", 1000);
        foodStand.add(food);

        Assertions.assertEquals(1, foodStand.getFoods().size());
    }

    @Test
    @DisplayName("FoodStand.delete 테스트")
    void deleteTest(){
        FoodStand foodStand = new FoodStand();
        Food food = new Food("사과", 1000);
        foodStand.add(food);
        foodStand.delete(food);

        Assertions.assertEquals(0, foodStand.getFoods().size());

    }
}