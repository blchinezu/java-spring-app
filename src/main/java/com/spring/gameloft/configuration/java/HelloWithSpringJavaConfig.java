package com.spring.gameloft.configuration.java;

import com.spring.gameloft.configuration.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HelloWithSpringJavaConfig {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloGameloftConfig.class);
        MessageRenderer renderer = (MessageRenderer) ctx.getBean("messageRenderer");
        renderer.render();
    }
}
