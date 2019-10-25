package com.spring.gameloft;

import com.spring.gameloft.domain.Singer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BootApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    private String url = "http://localhost:8000/singers";

    private Singer singer;

    @Test
    void testCreateSinger() {
        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Doe");
        singer.setBirthDate(LocalDate.of(1990, 1, 2));

        Singer actualSinger = testRestTemplate
                .withBasicAuth("admin", "admin")
                .postForObject(url, singer, Singer.class);

        assertThat(actualSinger.getId()).isNotNull();
        assertThat(actualSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(actualSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(actualSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
    }

}
