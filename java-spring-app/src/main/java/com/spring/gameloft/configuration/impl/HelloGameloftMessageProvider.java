package com.spring.gameloft.configuration.impl;

import com.spring.gameloft.configuration.MessageProvider;
import org.springframework.stereotype.Component;

@Component("messageProvider") // default name: helloGameloftMessageProvider
public class HelloGameloftMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Java programmers from Gameloft";
    }
}
