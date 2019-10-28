package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;

import java.util.List;

public interface SingerRepositoryJDBC {

    List<Singer> getAllSingers();

    Singer getSinger(Long id);

    Singer create(Singer singer);

    Singer update(Long id, Singer singer);

    List<Singer> getSingersByName(String lastName);

    void delete(Long id);
}
