package com.spring.gameloft.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class ProgrammerPostConstructBean {
    private int age = Integer.MIN_VALUE;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @PostConstruct
    public void init() throws Exception {
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
        ctx.load("classpath:app-context-post-construct.xml");
        ctx.refresh();
        ProgrammerPostConstructBean bean  = (ProgrammerPostConstructBean) ctx.getBean("InitializingBean");
        ProgrammerPostConstructBean bean1 = (ProgrammerPostConstructBean) ctx.getBean("InitializingBean1");
        ProgrammerPostConstructBean bean2 = (ProgrammerPostConstructBean) ctx.getBean("InitializingBean2");
        ctx.close();
    }
}
