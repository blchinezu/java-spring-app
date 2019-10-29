package com.spring.gameloft.jpa.jpql;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DP")
public class DesignProject extends Project {
}
