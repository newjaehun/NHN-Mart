package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasketTest {
    @Test
    @DisplayName("Basket.add 테스트")
    void addTest(){
        Basket basket = new Basket();
        Food food = new Food("사과", 1000);
        basket.add(food);
        Assertions.assertEquals(1, basket.getFoods().size());
    }

}