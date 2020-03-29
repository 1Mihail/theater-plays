package com.aop.tpma.controller;

import com.aop.tpma.domain.Play;
import com.aop.tpma.service.PlayService;
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
@RequestMapping(path = "/api/play")
public class PlayController {
    @Autowired
    private PlayService playService;

    @RequestMapping(path = "/getPlays", method = RequestMethod.GET)
    public List<Play> getPlays() {
        return playService.getPlays();
    }

    @RequestMapping(path = "/savePlay", method = RequestMethod.POST)
    public Play savePlay(@RequestBody Play play) {
        return playService.savePlay(play);
    }
}
