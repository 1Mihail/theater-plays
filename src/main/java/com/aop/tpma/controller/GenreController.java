package com.aop.tpma.controller;

import com.aop.tpma.domain.Genre;
import com.aop.tpma.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @RequestMapping(path = "/getGenres", method = RequestMethod.GET)
    public List<Genre> getGenres() {
        return genreService.getGenres();
    }

    @RequestMapping(path = "/insertGenre", method = RequestMethod.POST)
    public Genre saveGenre(@RequestBody Genre genre) {
        return genreService.saveGenre(genre);
    }
}