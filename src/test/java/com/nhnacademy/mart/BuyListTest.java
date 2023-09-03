package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuyListTest {
    @Test
    @DisplayName("BuyList.item 객체 생성 테스트")
    void itemConstructorTest(){
        BuyList.Item item = new BuyList.Item("사과", 1);

        Assertions.assertEquals("사과", item.getName());
        Assertions.assertEquals(1, item.getAmount());
    }

    @Test
    @DisplayName("BuyList.add 테스트")
    void addTest(){
        BuyList buyList = new BuyList();
        buyList.add("사과", 1);

        Assertions.assertEquals("사과", buyList.getItems().get(0).getName());
        Assertions.assertEquals(1, buyList.getItems().get(0).getAmount());
    }

}