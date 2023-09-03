package com.nhnacademy.mart;

import java.util.ArrayList;
import java.util.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private static final Logger logger = LoggerFactory.getLogger(NhnMartShell.class);
    // 고객 구매 목록
    private final BuyList buyList;
    private int money = 20000;


    // 고객 장바구니
    private Basket basket;


    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니 챙기기
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        for(BuyList.Item item : buyList.getItems()){
            int amount = item.getAmount();
            for(int i = 0; i<item.getAmount(); i++){      // foodStand에서 찾기
                Food checkFood = null;

                for(Food food : foodStand.getFoods()){
                    if(item.getName().equals(food.getName())){
                       checkFood = food;
                       amount--;
                       break;
                    }
                }
                if(checkFood !=null){
                    basket.add(checkFood);
                    logger.info(checkFood.getName() + " basket에 추가 완료");
                    foodStand.delete(checkFood);
                    logger.info(checkFood.getName() + " foodStand에서 삭제 완료");
                }
                if(i==(item.getAmount()-1) ){
                    if (amount !=0){
                        logger.warn(item.getName() + "의 재고가 부족합니다.");
                        throw new IllegalArgumentException(item.getName() + "의 재고가 부족합니다.");
                    }
                    else if(amount == item.getAmount()){
                        logger.warn(item.getName() + "는 식품 매대에 없는 상품입니다.");
                        throw new IllegalArgumentException(item.getName() + "는 식품 매대에 없는 상품입니다.");
                    }
                }
            }
        }
    }
    public void payTox(Counter counter) {
        for(Food food : basket.getFoods()){
            counter.count(food.getPrice());
        }
        counter.returnMoney(money);
    }
}
