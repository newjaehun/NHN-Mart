package com.nhnacademy.mart;

import java.util.ArrayList;

public class BuyList {

    public ArrayList<Item> getItems() {
        return items;
    }

    private final ArrayList<Item> items = new ArrayList<>();

    public void add(String name, int amount){
        items.add(new Item(name, amount));
    }



    public static class Item {
        private final String name;
        private final int amount;

        public Item(String name, int amount) {
            this.name = name;
            this.amount = amount;
        }

        public String getName() {
            return name;
        }

        public int getAmount() {
            return amount;
        }
    }
}
