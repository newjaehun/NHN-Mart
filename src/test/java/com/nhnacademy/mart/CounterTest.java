package com.nhnacademy.mart;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CounterTest {
    @Test
    @DisplayName("Counter.count 테스트")
    void countTest(){
        Counter counter = new Counter();

        for (int i = 0; i <5 ; i++) {
            counter.count(i);
        }
        Assertions.assertEquals(10, counter.getTotal());
    }

    @Test
    @DisplayName("Counter.returnMoney 테스트")
    void returnTest(){
        Counter counter = new Counter();
        for (int i = 0; i <5 ; i++) {
            counter.count(i);
        }
        counter.returnMoney(20);
        Assertions.assertEquals(10, counter.getRemain());
    }
    @Test
    @DisplayName("Counter.returnMoney 돈을 초과하는 경우 테스트")
    void returnOverTest(){
        Counter counter = new Counter();
        for (int i = 0; i <5 ; i++) {
            counter.count(i);
        }
        Assertions.assertThrows(IllegalArgumentException.class,() -> counter.returnMoney(9));
    }


}
