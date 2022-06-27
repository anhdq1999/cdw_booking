package com.booking.controller;

import com.booking.common.Response;
import com.booking.converter.GalleryConverter;
import com.booking.payload.response.GalleryResponse;
import com.booking.services.impl.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/galleries")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping()
    public ResponseEntity<?> getAll(){
        List<GalleryResponse> responses = galleryService.getAll()
                .stream().map(gallery-> GalleryConverter.toResponse(gallery))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all gallery successfully",responses));
    }
    @GetMapping("/getByRoomId/{id}")
    public ResponseEntity<?> getAllByRoomId(@PathVariable Long id){
        List<GalleryResponse> responses = galleryService.getAllByRoomId(id)
                .stream().map(gallery-> GalleryConverter.toResponse(gallery))
                .collect(Collectors.toList());
        return ResponseEntity.ok(Response.success("Get all gallery successfully",responses));
    }

}
