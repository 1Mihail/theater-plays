package com.aop.tpma.service;

import com.aop.tpma.dao.PlayRepository;
import com.aop.tpma.domain.Play;
import com.aop.tpma.exception.ItemNotPresentInDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Services are beans so the component-scanning mechanism of spring can pick it up and pull it into the application context.
 */
@Service
public class PlayService {
    @Autowired
    private PlayRepository playRepository;

    public List<Play> getPlays() {
        return playRepository.findAll();
    }

    public Play savePlay(Play play) {
        try {
            return playRepository.save(play);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ItemNotPresentInDatabaseException("The collection has one or more items which are not present in the database.");
        }

    }
}
