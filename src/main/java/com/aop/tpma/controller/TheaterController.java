package com.aop.tpma.controller;

import com.aop.tpma.domain.Theater;
import com.aop.tpma.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Spring RestController annotation is used to create RESTful web services.
 * Spring RestController takes care of mapping request data to the defined request handler method.
 */
@RestController
@RequestMapping(path = "/api/theater")
public class TheaterController {
    @Autowired
    private TheaterService theaterService;

    @RequestMapping(path = "/getTheaters", method = RequestMethod.GET)
    public List<Theater> getTheaters() {
        return theaterService.getTheaters();
    }

    @RequestMapping(path = "/saveTheater", method = RequestMethod.POST)
    public Theater saveTheater(@RequestBody Theater theater) {
        return theaterService.saveTheater(theater);
    }
}
