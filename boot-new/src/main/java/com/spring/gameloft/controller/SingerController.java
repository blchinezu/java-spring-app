package com.spring.gameloft.controller;

import com.spring.gameloft.ApplicationProperties;
import com.spring.gameloft.domain.Singer;
import com.spring.gameloft.service.SingerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.ValidationException;

@RestController
@RequestMapping("/singers")
public class SingerController {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Autowired
    private SingerService singerService;

//    @GetMapping
//    public List<Singer> getAllSingers() {
//        List<Singer> allSingers = singerService.getAllSingers();
//        System.out.println("Getting all singers" + allSingers);
//        return allSingers;
//    }

    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    //@Secured({"ROLE_ADMIN"})
    // @RolesAllowed(value = {"ADMIN", "USER"})
    @GetMapping("/{id}")
    public Singer getSinger(@PathVariable("id") Long id) {
        Singer singer = singerService.getSinger(id);
        System.out.println("Gameloft has " + applicationProperties.getEmployeesNumber() + " employees");
        System.out.println("Getting singer: " + singer);
        return singer;
    }

    @GetMapping
    public List<Singer> getSingerByLastName(@RequestParam(value = "lastName", required = false) String lastName) {
        List<Singer> singers = singerService.getSingersByName(lastName);
        System.out.println("Getting singer: " + singers);
        return singers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Singer create(@RequestBody @Valid Singer singer) {
        System.out.println("Creating singer " + singer);
        return singerService.create(singer);
    }

    @PutMapping("/{id}")
    public Singer update(@PathVariable("id") Long id, @RequestBody @Valid Singer singer) {
        System.out.println("Updating singer " + singer);
        return singerService.update(id, singer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestHeader("Accept") String accept,
                       @PathVariable("id") Long id) {
        System.out.println("==============" + accept);
        Singer singer = singerService.getSinger(id);
        System.out.println("Deleting singer: " + singer);
        singerService.delete(id);
    }

    @ExceptionHandler(value = ValidationException.class)
    public void badRequest(HttpServletResponse response) throws IOException {
        response.setStatus(HttpStatus.BAD_REQUEST.value());
    }
}


