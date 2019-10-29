package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;

import java.util.List;

public interface SingerRepositoryJDBC {
    Singer create(Singer singer);

    void delete(Long id);

    List<Singer> getAllSingers();

    Singer getSinger(Long id);

    List<Singer> getSingersByName(String lastName);

    Singer update(Long id, Singer singer);
}
