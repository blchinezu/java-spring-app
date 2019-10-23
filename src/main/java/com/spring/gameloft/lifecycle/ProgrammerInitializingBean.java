package com.spring.gameloft.lifecycle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ProgrammerInitializingBean implements InitializingBean {
    private int age = Integer.MIN_VALUE;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("init bean");
        if(age == Integer.MIN_VALUE) {
            throw new RuntimeException("you must set correct age of bean " + ProgrammerInitializingBean.class.getSimpleName());
        }
        if(name == null) {
            System.out.println("setting default name");
            this.name = "John Doe";
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context-initialization.xml");
        ctx.refresh();
        ProgrammerInitializingBean bean  = (ProgrammerInitializingBean) ctx.getBean("InitializingBean");
        ProgrammerInitializingBean bean1 = (ProgrammerInitializingBean) ctx.getBean("InitializingBean1");
        ProgrammerInitializingBean bean2 = (ProgrammerInitializingBean) ctx.getBean("InitializingBean2");
        ctx.close();
    }
}
