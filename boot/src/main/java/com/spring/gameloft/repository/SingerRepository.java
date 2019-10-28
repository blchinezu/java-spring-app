package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SingerRepository extends JpaRepository<Singer, Long> {

//    Singer findFirstByLastName(String lastName);

    List<Singer> findAllByLastName(String lastName);
}
