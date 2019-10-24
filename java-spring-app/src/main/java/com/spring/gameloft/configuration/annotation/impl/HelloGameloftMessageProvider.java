package com.spring.gameloft.configuration.annotation.impl;

import com.spring.gameloft.configuration.MessageProvider;

public class HelloGameloftMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello Java programmers from Gameloft";
    }
}
