package com.spring.gameloft.controller;

import com.spring.gameloft.ApplicationProperties;
import com.spring.gameloft.domain.Album;
import com.spring.gameloft.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/singers/{singerId}/albums")
public class AlbumController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/{id}")
    public Album getAlbum(@PathVariable Long singerId, @PathVariable Integer id) {
        Album album = albumService.getAlbum(singerId, id);
        System.out.println("Getting album: " + id);
        return album;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable Long singerId, @PathVariable Integer id) {
        Album album = albumService.getAlbum(singerId, id);
        System.out.println("Deleting album: " + album);
        albumService.delete(singerId, id);
    }

    @GetMapping
    public List<Album> getAlbumByTitle(@PathVariable Long singerId, @PathVariable(value = "title", required = false) String title) {
        List<Album> albums = albumService.getAlbumsByTitle(singerId, title);
        System.out.println("Getting albums by: " + title);
        System.out.println("Gameloft has " + applicationProperties.getEmpoyeesNumber());
        System.out.println("Gameloft id is " + applicationProperties.getCompanyId());
        return albums;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Album create(@PathVariable Long singerId, @RequestBody Album album) {
        System.out.println("Creating album: " + album);
        return albumService.create(singerId, album);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Album update(@PathVariable Long singerId, @PathVariable Integer id, @RequestBody Album album) {
        System.out.println("Creating album: " + album);
        return albumService.update(singerId, id, album);
    }

//    @ExceptionHandler(value = RuntimeException.class)
//    public void notFound(HttpServletResponse response) {
//        response.setStatus(HttpStatus.NOT_FOUND.value());
//    }
}
