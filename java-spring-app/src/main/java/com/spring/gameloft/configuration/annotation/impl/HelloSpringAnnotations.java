package com.spring.gameloft.configuration.annotation.impl;

import com.spring.gameloft.configuration.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class HelloSpringAnnotations {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        MessageRenderer renderer = ctx.getBean(MessageRenderer.class);
        renderer.render();
    }
}
