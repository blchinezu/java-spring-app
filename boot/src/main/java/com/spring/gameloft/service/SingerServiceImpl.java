package com.spring.gameloft.service;

import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.repository.SingerRepository;
import com.spring.gameloft.repository.SingerRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(propagation = Propagation.REQUIRED)
    public Singer getSinger(Long id) {
        Singer oneSinger = singerRepository.getOne(id);
        oneSinger.setFirstName("Mister");
        return oneSinger;
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
