package com.nhnacademy.mart;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main 클래스입니다.
 */
public class NhnMartShell {
    /**
     * main 메서드입니다.
     *
     * @param args input 인자
     * */
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();
        mart.prepareMart();

        BuyList buyList = inputBuyListFromShell();

        Customer jaehun = new Customer(buyList);

        // 장바구니를 챙긴다.
        jaehun.bring(mart.provideBasket());

        // 식품을 담는다.
        jaehun.pickFoods(mart.getFoodStand());

        // 카운터에서 계산한다.
        jaehun.payTox(mart.getCounter());
    }
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);
    private static BuyList inputBuyListFromShell() {
        System.out.print("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요. " + "\n\n> ");
        Scanner scanner = new Scanner(System.in);
        BuyList buyList = new BuyList();
        String[] str = scanner.nextLine().split(" ");
        for (int i = 0; i < str.length; i += 2) {
            buyList.add(str[i], Integer.parseInt(str[i + 1]));
        }
        logger.info("buyList 입력완료.");
        return buyList;
    }
}
