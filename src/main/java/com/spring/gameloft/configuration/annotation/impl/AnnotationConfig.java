package com.spring.gameloft.configuration.annotation.impl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = {"com.spring.gameloft.configuration"})
//@ImportResource("app-context.xml") // for an xml config that already exists
public class AnnotationConfig {
}
