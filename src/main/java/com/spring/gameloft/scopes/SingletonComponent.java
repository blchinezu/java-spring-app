package com.spring.gameloft.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SingletonComponent {
    private String name = "John";
    @Override
    public String toString() {
        return "SingletonComponent {" + "name='" + name + "'}";
    }
}
