package com.spring.gameloft.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("info")
public class BeanB implements BeanInterface {
    List<String> names = Arrays.asList("Andrei", "Cristi", "Adriana");

    @Override
    public void printNames() {
        System.out.println(names.toString());
    }
}
