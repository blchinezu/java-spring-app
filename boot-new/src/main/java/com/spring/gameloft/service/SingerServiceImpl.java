package com.spring.gameloft.service;

import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.repository.SingerRepository;
import com.spring.gameloft.repository.SingerRepositoryJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import static javax.persistence.DiscriminatorType.INTEGER;

@Service
@Transactional(readOnly = true)
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepositoryJDBC singerRepositoryJDBC;
    @Autowired
    private SingerRepository singerRepository;

    @Override
    @Transactional
    public Singer create(Singer singer) {

        //return singerRepositoryJDBC.create(singer);
        return singerRepository.save(singer);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        // singerRepositoryJDBC.delete(id);
        singerRepository.deleteById(id);
    }

    @Override
    public List<Singer> getAllSingers() {

        //return singerRepositoryJDBC.getAllSingers();
        return singerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Singer getSinger(Long id) {
        //return singerRepositoryJDBC.getSinger(id);
        Singer oneSInger = singerRepository.getOne(id);
        oneSInger.setFirstName("Mister" + oneSInger.getFirstName());
        return oneSInger;
    }

    @Override
    public List<Singer> getSingersByName(String lastName) {

        //return singerRepositoryJDBC.getSingersByName(lastName);
        if (lastName == null) {
            return singerRepository.findAll();
        }
        return singerRepository.findAllByLastName(lastName);
    }

    @Override
    @Transactional
    public Singer update(Long id, Singer singer) {
        singer.setId(id);
        Singer savedSinger = singerRepository.save(singer);
        return savedSinger;
    }
}
