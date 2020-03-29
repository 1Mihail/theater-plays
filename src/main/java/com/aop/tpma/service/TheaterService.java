package com.aop.tpma.service;

import com.aop.tpma.dao.TheaterRepository;
import com.aop.tpma.domain.Theater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Services are beans so the component-scanning mechanism of spring can pick it up and pull it into the application context.
 */
@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    public List<Theater> getTheaters() {
        return theaterRepository.findAll();
    }

    public Theater saveTheater(Theater theater) {
        return theaterRepository.save(theater);
    }
}
