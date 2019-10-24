package com.spring.gameloft.configuration.xml;

import com.spring.gameloft.configuration.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWithSpring {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
        MessageRenderer renderer = (MessageRenderer) ctx.getBean("renderer");
        renderer.render();
    }
}
