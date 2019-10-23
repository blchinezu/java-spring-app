package com.spring.gameloft.scopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSingleton {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        SingletonComponent bean = ctx.getBean(SingletonComponent.class);
        SingletonComponent bean1 = (SingletonComponent) ctx.getBean("singletonComponent");

        System.out.println("Thease beans are equal: " + (bean == bean1));
        System.out.println(bean.hashCode());
        System.out.println(bean1.hashCode());

        System.out.println(bean);
        System.out.println(bean1);
    }
}
