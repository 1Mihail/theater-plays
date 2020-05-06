package com.aop.tpma.service;

import com.aop.tpma.dao.ActorRepository;
import com.aop.tpma.domain.Actor;
import com.aop.tpma.exception.ItemAlreadyExistsException;
import com.aop.tpma.exception.ItemNotPresentInDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
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
        try {
            return actorRepository.save(actor);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ItemNotPresentInDatabaseException("The collection has one or more items which are not present in the database.");
        } catch (DataIntegrityViolationException e) {
            throw new ItemAlreadyExistsException("Item already exists!");
        }
    }
}
