package com.spring.gameloft.configuration.java;

import com.spring.gameloft.configuration.MessageProvider;
import com.spring.gameloft.configuration.MessageRenderer;
import com.spring.gameloft.configuration.impl.HelloGameloftMessageProvider;
import com.spring.gameloft.configuration.impl.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloGameloftConfig {

    @Bean(name="messageProvider") // <bean id="messageProvider" class="com.spring.gameloft.configuration.impl.HelloGameloftMessageProvider"/>
//    @Qualifier("messageProvider")
    public MessageProvider messageProvider() { // default bean has name of the method
        return new HelloGameloftMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        return new StandardOutMessageRenderer(messageProvider());
    }
}
