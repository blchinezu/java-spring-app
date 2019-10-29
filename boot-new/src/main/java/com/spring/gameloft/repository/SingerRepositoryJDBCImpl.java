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
public class SingerRepositoryJDBCImpl implements SingerRepositoryJDBC {

    String getSingersSql = "SELECT * FROM singer";
    String getSingerSql = "SELECT * FROM singer WHERE id = ?";
    String insertSingerSql = "insert into singer values (null, ?, ?, ?)";
    String updateSingerSql = "UPDATE singer SET first_name = ?, last_name = ?, birth_date =? WHERE id = ?";
    String deleteSingerSql = "DELETE FROM singer WHERE id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public void delete(Long id) {
        jdbcTemplate.update(deleteSingerSql, id);
    }

    @Override
    public List<Singer> getAllSingers() {
        //Singer mapRow(ResultSet rs, int rowNum)
        return jdbcTemplate.query(getSingersSql, buildSingerRowMapper());
    }

    @Override
    public Singer getSinger(Long id) {
        return jdbcTemplate.queryForObject(getSingerSql, buildSingerRowMapper(), id);
    }

    @Override
    public List<Singer> getSingersByName(String lastName) {
        if (lastName != null) {
            String getSingersSql = this.getSingersSql + " WHERE LAST_NAME = ?";
            return jdbcTemplate.query(getSingersSql, buildSingerRowMapper(), lastName);
        }
        return getAllSingers();
    }

    @Override
    public Singer update(Long id, Singer singer) {
        jdbcTemplate.update(updateSingerSql,
                singer.getFirstName(),
                singer.getLastName(),
                singer.getBirthDate(),
                id
        );

        return jdbcTemplate.queryForObject(getSingerSql, buildSingerRowMapper(), id);
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
