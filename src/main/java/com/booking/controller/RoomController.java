package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.RoomConverter;
import com.booking.entity.RoomEntity;
import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.RoomResponse;
import com.booking.services.impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<RoomResponse> responses= roomService.getAll()
                .stream()
                .map(room-> RoomConverter.toResponse(room))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all room successfully",responses));
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody RoomRequest request){
        RoomEntity entity =roomService.save(request);
        RoomResponse response = RoomConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("Create a room successfully",response));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody RoomRequest request){
        RoomEntity entity = roomService.update(id, request);
        RoomResponse response = RoomConverter.toResponse(entity);
        return ResponseEntity.ok(Response.success("Update room with id:"+id+" successfully",response));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        roomService.delete(id);
        return ResponseEntity.ok(Response.success("Delete by id:"+id+" successfully",null));
    }
}
