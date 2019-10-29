package com.spring.gameloft;

import com.spring.gameloft.domain.Singer;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@Import(value = ClasaAnotataCu @TestConfiguration ce contine configurarea specifica de Test)
public class BootApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    private String singerResourceUrl = "http://localhost:8000/singers";

    @Test
    void testCreateSinger() {
        Singer singer = new Singer();
        singer.setFirstName("Elvis");
        singer.setLastName("Presley");
        singer.setBirthDate(LocalDate.of(1942, 10, 12));

        Singer actualSinger = testRestTemplate
                .withBasicAuth("admin", "admin")
                .postForObject(singerResourceUrl, singer, Singer.class);

        assertThat(actualSinger.getId()).isNotNull();
        assertThat(actualSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(actualSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(actualSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
    }

    @Test
    void testCreateSingerWithRequestEntity() throws URISyntaxException {
        Singer singer = new Singer();
        singer.setFirstName("Elton");
        singer.setLastName("John");
        singer.setBirthDate(LocalDate.of(1941, 10, 12));

        RequestEntity<Singer> singerRequestEntity = RequestEntity
                .post(new URI(singerResourceUrl))
                .accept(MediaType.APPLICATION_JSON)
                //.headers()  any headers you need to set
                .body(singer);

        ResponseEntity<Singer> singerResponseEntity = testRestTemplate
                .withBasicAuth("admin", "admin")
                .exchange(singerRequestEntity, Singer.class);

        Singer actualSinger = singerResponseEntity.getBody();
        assertThat(actualSinger.getId()).isNotNull();
        assertThat(actualSinger.getFirstName()).isEqualTo(singer.getFirstName());
        assertThat(actualSinger.getLastName()).isEqualTo(singer.getLastName());
        assertThat(actualSinger.getBirthDate()).isEqualTo(singer.getBirthDate());
    }
}
