package com.nhnacademy.mart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Counter {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);

    public int getTotal() {
        return total;
    }

    // TODO pay 메서드 구현 (카운터에서 계산 처리 메서드)
    private int total=0;

    public int getRemain() {
        return remain;
    }

    private int remain =0;
    public void count(int item_price){
        total += item_price;
    }

    public void returnMoney(int money) {
        System.out.println("총 가격은 " + total + "원 입니다.");
        remain =money-total;
            if((remain) < 0){
                logger.warn("돈을 초과하였습니다.");
                throw new IllegalArgumentException("돈을 초과하였습니다.");
            }
        System.out.print("고객님 결제 후 잔액 : " + remain);
    }
}
