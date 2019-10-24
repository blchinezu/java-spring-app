package com.spring.gameloft.payshop.service;

import com.spring.gameloft.payshop.service.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.ArrayList;

public class Shop {
    static public List<Item> items = new ArrayList<>();

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ManagerService manager = (ManagerService) ctx.getBean("managerService");
        PlaceService place = (PlaceService) ctx.getBean("placeService");

        place.putItem(new Item("test1", 1.00f));
        place.putItem(new Item("test5", 3.50f));
        place.putItem(new Item("test2", 4.50f));
        place.putItem(new Item("test7", 2.50f));
        place.putItem(new Item("test4", 7.00f));

        System.out.println("current list: " + manager.listShop());
        place.sortByName();
        System.out.println("by name list: " + manager.listShop());
        place.sortByPrice();
        System.out.println("by price list: " + manager.listShop());

        System.out.println(manager.pop_first());

        System.out.println("list: " + manager.listShop());

        System.out.println(manager.pop_last());

        System.out.println("list: " + manager.listShop());
    }
}
