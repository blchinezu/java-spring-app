package com.spring.gameloft.configuration.annotation.impl;

import com.spring.gameloft.configuration.MessageProvider;
import com.spring.gameloft.configuration.MessageRenderer;

public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if(messageProvider == null) {
            throw new RuntimeException("You should set dependency messageProvider for type " + getClass().getSimpleName());
        }
        System.out.println(messageProvider.getMessage());
    }

    public StandardOutMessageRenderer(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }
//    public void setMessageProvider(MessageProvider messageProvider) {
//        this.messageProvider = messageProvider;
//    }
}
