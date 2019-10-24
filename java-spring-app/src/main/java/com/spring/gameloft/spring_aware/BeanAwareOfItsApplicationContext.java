package com.spring.gameloft.spring_aware;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanAwareOfItsApplicationContext implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext instanceof AnnotationConfigApplicationContext) {
            System.out.println("this context is of type " + applicationContext.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        BeanAwareOfItsApplicationContext bean = ctx.getBean(BeanAwareOfItsApplicationContext.class);
    }
}
