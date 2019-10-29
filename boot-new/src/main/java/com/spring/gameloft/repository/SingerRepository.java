package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SingerRepository extends JpaRepository<Singer, Long> {
    //this interface has to be named like: <EntityName>Repository

    List<Singer> findAllByLastName(String lastName);

    @Query("Select s from Singer s WHERE s.firstName = :firstName")
    Stream<Singer> findAllCustom(@Param("firstName") String firstName);

    @Query(nativeQuery = true, value = "select * from singer")
    List<Singer> getSingersWithNativeQuery();

    @Query("UPDATE Singer s SET s.firstName = s.firstName + 'updated' WHERE s.albums IS NOT NULL")
    @Modifying
    int updateSinger();
}