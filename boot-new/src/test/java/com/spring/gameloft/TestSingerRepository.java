package com.spring.gameloft;

import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.repository.SingerRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DirtiesContext
public class TestSingerRepository {

    @Autowired
    private SingerRepository singerRepository;

    @Test
    public void testGetByFirstName() {
        Singer singer = new Singer();
        singer.setFirstName("Duta");
        singer.setLastName("Laurentiu");
        singer.setBirthDate(LocalDate.of(1990, 1, 1));

        singerRepository.save(singer);

        List<Singer> singers = singerRepository.findAllByLastName("Laurentiu");
        assertThat(singers.size()).isEqualTo(1);

        Singer retrievedSinger = singers.get(0);
        assertThat(retrievedSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(retrievedSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(retrievedSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
        assertThat(retrievedSinger.getId()).isNotNull();
    }

    @Test
    public void testGetAllWithNativeQuery() {
        Singer singer = new Singer();
        singer.setFirstName("Duta");
        singer.setLastName("Laurentiu");
        singer.setBirthDate(LocalDate.of(1990, 1, 1));

        singerRepository.save(singer);

        List<Singer> singers = singerRepository.getSingersWithNativeQuery();
        assertThat(singers.size()).isEqualTo(1);

        Singer retrievedSinger = singers.get(0);
        assertThat(retrievedSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(retrievedSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(retrievedSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
        assertThat(retrievedSinger.getId()).isNotNull();
    }
}
