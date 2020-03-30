package com.aop.tpma.controller;

import com.aop.tpma.domain.Room;
import com.aop.tpma.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @RequestMapping(path = "/getTheaterRooms", method = RequestMethod.GET)
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @RequestMapping(path = "/insertTheaterRoom", method = RequestMethod.POST)
    public Room saveRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }
}
