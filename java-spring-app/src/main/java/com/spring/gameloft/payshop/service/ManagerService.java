package com.spring.gameloft.payshop.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ManagerService {
    public Item pop_first()
    {
        return Shop.items.remove(0);
    }
    public Item pop_last()
    {
        return Shop.items.remove(Shop.items.size() - 1);
    }
    public void clearShop()
    {
        Shop.items.clear();
    }
    public String listShop()
    {
        StringBuffer buff = new StringBuffer();
        buff.append("[");
        for(int i = 0; i < Shop.items.size(); i++) {
            buff.append(Shop.items.get(i).toString())
                    .append(",");
        }
        buff.setLength(buff.length() - 1);
        buff.append("]");

        return buff.toString();
    }
}
