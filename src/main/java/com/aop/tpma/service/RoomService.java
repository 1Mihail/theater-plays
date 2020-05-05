package com.aop.tpma.service;

import com.aop.tpma.dao.RoomRepository;
import com.aop.tpma.domain.Room;
import com.aop.tpma.exception.ItemNotPresentInDatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public Room saveRoom(Room room) {
        try {
            return roomRepository.save(room);
        } catch (InvalidDataAccessApiUsageException e) {
            throw new ItemNotPresentInDatabaseException("The collection has one or more items which are not present in the database.");
        }
    }
}