package com.spring.gameloft;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="com.gameloft")
@Data
public class ApplicationProperties {

    private int employeesNumber;
    private String companyId;
}
