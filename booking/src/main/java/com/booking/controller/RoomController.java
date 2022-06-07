package com.booking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/room")
public class RoomController {
    @GetMapping("/")
    List<String> getAll() {
        return List.of(
                "room1",
                "room2"
        );
    }

}
