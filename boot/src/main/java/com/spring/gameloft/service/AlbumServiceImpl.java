package com.spring.gameloft.service;

import com.spring.gameloft.domain.Album;
import com.spring.gameloft.repository.AlbumRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepositoryJDBC albumRepositoryJDBC;

    @Override
    public List<Album> getAllAlbums(Long singerId) {
        return albumRepositoryJDBC.getAllAlbums(singerId);
    }

    @Override
    public Album getAlbum(Long singerId, Integer id) {
        return albumRepositoryJDBC.getAlbum(singerId, id);
    }

    @Override
    public Album create(Long singerId, Album album) {
        return albumRepositoryJDBC.create(singerId, album);
    }

    @Override
    public Album update(Long singerId, Integer id, Album album) {
        return albumRepositoryJDBC.update(singerId, id, album);
    }

    @Override
    public List<Album> getAlbumsByTitle(Long singerId, String title) {
        return albumRepositoryJDBC.getAlbumsByTitle(singerId, title);
    }

    @Override
    public void delete(Long singerId, Integer id) {
        albumRepositoryJDBC.delete(singerId, id);
    }
}
