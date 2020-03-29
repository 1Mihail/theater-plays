package com.aop.tpma.controller;

import com.aop.tpma.domain.Actor;
import com.aop.tpma.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @RequestMapping(path = "/getActors", method = RequestMethod.GET)
    public List<Actor> getActors() {
        return actorService.getActors();
    }

    @RequestMapping(path = "/insertActor", method = RequestMethod.POST)
    public Actor saveActor(@RequestBody Actor actor) {
        return actorService.saveActor(actor);
    }
}