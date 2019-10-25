package com.spring.gameloft.service;

import com.spring.gameloft.domain.Album;
import com.spring.gameloft.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums(Long singerId) {
        return albumRepository.getAllAlbums(singerId);
    }

    @Override
    public Album getAlbum(Long singerId, Long id) {
        return albumRepository.getAlbum(singerId, id);
    }

    @Override
    public Album create(Long singerId, Album album) {
        return albumRepository.create(singerId, album);
    }

    @Override
    public Album update(Long singerId, Long id, Album album) {
        return albumRepository.update(singerId, id, album);
    }

    @Override
    public List<Album> getAlbumsByTitle(Long singerId, String title) {
        return albumRepository.getAlbumsByTitle(singerId, title);
    }

    @Override
    public void delete(Long singerId, Long id) {
        albumRepository.delete(singerId, id);
    }
}
