package com.spring.gameloft.payshop.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PlaceService {
    public void putItem(Item item) {
        Shop.items.add(item);
    }
    public void sortByName() {
        Shop.items.sort((item, t1) -> {
            return item.getItemName().compareTo(t1.getItemName());
        });
    }
    public void sortByPrice() {
        Shop.items.sort((item, t1) -> {
            if (item.getItemPrice() < t1.getItemPrice())
                return -1;
            else if (item.getItemPrice() > t1.getItemPrice())
                return 1;
            else return 0;
        });
    }
}
