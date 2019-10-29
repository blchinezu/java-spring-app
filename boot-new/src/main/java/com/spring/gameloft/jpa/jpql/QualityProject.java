package com.spring.gameloft.jpa.jpql;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("QP")
public class QualityProject extends Project {
    @Column(name = "qa_rating")
    private int qa_rating; 
    
    public int getQaRating() { return qa_rating; }
    public void setQaRating(int rating) { this.qa_rating = rating; }    

    public String toString() {
        return super.toString() + ", rating: " + qa_rating;
    }

}
