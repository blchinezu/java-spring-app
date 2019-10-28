package com.spring.gameloft.service;

import com.spring.gameloft.domain.Album;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums(Long singerId);

    Album getAlbum(Long singerId, Integer id);

    Album create(Long singerId, Album album);

    Album update(Long singerId, Integer id, Album album);

    List<Album> getAlbumsByTitle(Long singerId, String title);

    void delete(Long singerId, Integer id);
}
