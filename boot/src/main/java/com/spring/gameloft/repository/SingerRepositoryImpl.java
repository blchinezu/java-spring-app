package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.List;

@Repository
public class SingerRepositoryImpl implements SingerRepository {
    private String getSingersSql = "SELECT * FROM singer";

    private String getSingerSql = "SELECT * FROM singer WHERE id = ?";

    private String deleteSingerSql = "DELETE FROM singer WHERE id = ?";

    private String insertSingerSql = "INSERT INTO singer VALUES (null, ?, ?, ?)";

    private String updateSingerSql = "UPDATE singer set first_name = ?, last_name = ?, birth_date= ? where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Singer> getAllSingers() {
        return jdbcTemplate.query(getSingersSql, buildSingerRowMapper());
    }

    @Override
    public Singer getSinger(Long id) {
        return jdbcTemplate.queryForObject(getSingerSql, buildSingerRowMapper(), id);
    }

    @Override
    public Singer create(Singer singer) {
        jdbcTemplate.update(insertSingerSql,
                singer.getFirstName(),
                singer.getLastName(),
                singer.getBirthDate()
        );
        return getAllSingers().stream().max(Comparator.comparing(Singer::getId)).get();
    }

    @Override
    public Singer update(Long id, Singer singer) {
        jdbcTemplate.update(updateSingerSql,
                singer.getFirstName(),
                singer.getLastName(),
                singer.getBirthDate(),
                id
        );
        return getSinger(id);
    }

    @Override
    public List<Singer> getSingersByName(String lastName) {
        if (lastName != null) {
            getSingersSql += " WHERE LAST_NAME = ?";
            return jdbcTemplate.query(getSingersSql, buildSingerRowMapper(), lastName);
        }
        return getAllSingers();
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(deleteSingerSql, id);
    }

    private RowMapper<Singer> buildSingerRowMapper() {
        return (ResultSet rs, int rowNum) -> {
            Singer singer = new Singer();
            singer.setId(rs.getLong("ID"));
            singer.setFirstName(rs.getString("FIRST_NAME"));
            singer.setLastName(rs.getString("LAST_NAME"));
            singer.setBirthDate(rs.getDate("BIRTH_DATE").toLocalDate());
            return singer;
        };
    }
}
