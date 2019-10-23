package com.spring.gameloft.spring_aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanAwareOfItsName implements BeanNameAware {
    private String name;
    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        BeanAwareOfItsName bean = ctx.getBean(BeanAwareOfItsName.class);
        System.out.println(bean.getName());
    }
}
