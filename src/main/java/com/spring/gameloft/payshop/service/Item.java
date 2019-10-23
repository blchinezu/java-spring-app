package com.spring.gameloft.payshop.service;

import java.util.Comparator;

public class Item {
    private String itemName;
    private float itemPrice;

    public Item(String itemName, float itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString()
    {
        return "{" + itemName + ":" + itemPrice + "}";
    }
}
