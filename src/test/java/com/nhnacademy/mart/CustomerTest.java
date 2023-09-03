package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    @DisplayName("Customer.pickFoods 테스트")
    void pickFoodsTest(){
        BuyList buyList = new BuyList();
        buyList.add("사과", 1);

        Basket basket = new Basket();

        FoodStand foodStand = new FoodStand();
        Food food = new Food("사과", 1000);
        foodStand.add(food);

        Customer customer = new Customer(buyList);
        customer.bring(basket);
        customer.pickFoods(foodStand);

        Assertions.assertEquals(0, foodStand.getFoods().size());
        Assertions.assertEquals(1, basket.getFoods().size());
        Assertions.assertEquals(buyList.getItems().get(0).getName(), basket.getFoods().get(0).getName());
    }

    @Test
    @DisplayName("Customer.pickFoods 재고가 부족할 경우 테스트")
    void pickFoodsLessTest(){
        BuyList buyList = new BuyList();
        buyList.add("사과", 2);

        Basket basket = new Basket();

        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("사과", 1000));

        Customer customer = new Customer(buyList);
        customer.bring(basket);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(foodStand));
    }

    @Test
    @DisplayName("Customer.pickFoods 식품이 없는 경우 테스트")
    void pickNoFoodsTest(){
        BuyList buyList = new BuyList();
        buyList.add("사과", 1);

        Basket basket = new Basket();

        FoodStand foodStand = new FoodStand();
        foodStand.add(new Food("양파", 1000));

        Customer customer = new Customer(buyList);
        customer.bring(basket);

        Assertions.assertThrows(IllegalArgumentException.class, () -> customer.pickFoods(foodStand));
    }

}