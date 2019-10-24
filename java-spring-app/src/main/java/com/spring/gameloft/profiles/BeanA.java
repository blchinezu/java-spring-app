package com.spring.gameloft.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("debug")
public class BeanA implements BeanInterface {
    List<String> names = Arrays.asList("Ionut", "Nicu", "Gabi");

    @Override
    public void printNames() {
        System.out.println(names.toString());
    }
}
