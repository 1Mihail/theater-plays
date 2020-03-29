package com.aop.tpma.service;

import com.aop.tpma.dao.ActorRepository;
import com.aop.tpma.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getActors() {
        return actorRepository.findAll();
    }

    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }
}
