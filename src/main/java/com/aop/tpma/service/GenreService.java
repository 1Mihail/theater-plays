package com.aop.tpma.service;

import com.aop.tpma.dao.GenreRepository;
import com.aop.tpma.domain.Genre;
import com.aop.tpma.exception.ItemNotPresentInDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public Genre saveGenre(Genre genre) {
        try {
            return genreRepository.save(genre);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ItemNotPresentInDatabaseException("The collection has one or more items which are not present in the database.");
        }
    }
}
