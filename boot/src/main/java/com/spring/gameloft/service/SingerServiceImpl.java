package com.spring.gameloft.service;

import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.repository.SingerRepository;
import com.spring.gameloft.repository.SingerRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepositoryJDBC singerRepositoryJDBC;

//    @PersistenceContext
//    private EntityManager entityManager;

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> getAllSingers() {
        return singerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Singer getSinger(Long id) {
        return singerRepository.getOne(id);
    }

    @Override
    public Singer create(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public Singer update(Long id, Singer singer) {
//        return singerRepositoryJDBC.update(id, singer);
        singer.setId(id);
        Singer savedSinger = singerRepository.save(singer);
        return savedSinger;
    }

    @Override
    public List<Singer> getSingersByName(String lastName) {
//        return singerRepositoryJDBC.getSingersByName(lastName);
        return singerRepository.findAllByLastName(lastName);
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);
    }
}
