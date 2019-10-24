package com.spring.gameloft.configuration.impl;

import com.spring.gameloft.configuration.MessageProvider;
import com.spring.gameloft.configuration.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("messageRenderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    @Autowired //(required = true)
    @Qualifier("messageProvider")
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
