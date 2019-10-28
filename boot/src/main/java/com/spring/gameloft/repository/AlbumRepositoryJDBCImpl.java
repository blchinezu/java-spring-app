package com.spring.gameloft.repository;

import com.spring.gameloft.domain.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Comparator;
import java.util.List;

@Repository
public class AlbumRepositoryJDBCImpl implements AlbumRepositoryJDBC {
    private String getAlbumsSql = "SELECT * FROM album where singer_id = ?";

    private String getAlbumSql = "SELECT * FROM album WHERE id = ? and singer_id = ?";

    private String deleteAlbumSql = "DELETE FROM album WHERE id = ? and singer_id = ?";

    private String insertAlbumSql = "INSERT INTO album VALUES (null, ?, ?, ?)";

    private String updateAlbumSql = "UPDATE album set singer_id = ?, title = ?, release_date= ? where id = ? and singer_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Album> getAllAlbums(Long singerId) {
        return jdbcTemplate.query(getAlbumsSql, buildAlbumRowMapper(), singerId);
    }

    @Override
    public Album getAlbum(Long singerId, Integer id) {
        return jdbcTemplate.queryForObject(getAlbumSql, buildAlbumRowMapper(), id, singerId);
    }

    @Override
    public Album create(Long singerId, Album album) {
        jdbcTemplate.update(insertAlbumSql,
                album.getSingerId(),
                album.getTitle(),
                album.getReleaseDate()
        );
        return getAllAlbums(singerId).stream().max(Comparator.comparing(Album::getId)).get();
    }

    @Override
    public Album update(Long singerId, Integer id, Album album) {
        jdbcTemplate.update(updateAlbumSql,
                album.getSingerId(),
                album.getTitle(),
                album.getReleaseDate(),
                id,
                singerId
        );
        return getAlbum(singerId, id);
    }

    @Override
    public List<Album> getAlbumsByTitle(Long singerId, String title) {
        if (title != null) {
            getAlbumsSql += " and TITLE = ?";
            return jdbcTemplate.query(getAlbumsSql, buildAlbumRowMapper(), singerId, title);
        }
        return getAllAlbums(singerId);
    }

    @Override
    public void delete(Long singerId, Integer id) {
        jdbcTemplate.update(deleteAlbumSql, id, singerId);
    }

    private RowMapper<Album> buildAlbumRowMapper() {
        return (ResultSet rs, int rowNum) -> {
            Album album = new Album();
            album.setId(rs.getInt("ID"));
            album.setSingerId(rs.getLong("SINGER_ID"));
            album.setTitle(rs.getString("Title"));
            album.setReleaseDate(rs.getDate("RELEASE_DATE").toLocalDate());
            return album;
        };
    }
}
