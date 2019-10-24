package com.spring.gameloft.controller;

import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/singers")
public class SingerController {

    @Autowired
    private SingerService singerService;

//    @GetMapping
//    public List<Singer> getAllSingers() {
//        List<Singer> allSingers = singerService.getAllSingers();
//        System.out.println("Getting all singers: " + allSingers);
//        return allSingers;
//    }

    @GetMapping("/{id}")
    public Singer getSinger(@PathVariable Long id) {
        Singer singer = singerService.getSinger(id);
        System.out.println("Getting singer: " + id);
        return singer;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSinger(@PathVariable Long id) {
        Singer singer = singerService.getSinger(id);
        System.out.println("Deleting singer: " + singer);
        singerService.delete(id);
    }

    @GetMapping
    public List<Singer> getSingerByLastName(@PathVariable(value = "lastName", required = false) String lastName) {
        List<Singer> singers = singerService.getSingersByName(lastName);
        System.out.println("Getting singer: " + lastName);
        return singers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Singer create(@RequestBody Singer singer) {
        System.out.println("Creating singer: " + singer);
        return singerService.create(singer);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Singer update(@PathVariable("id") Long id, @RequestBody Singer singer) {
        System.out.println("Creating singer: " + singer);
        return singerService.update(id, singer);
    }
}
