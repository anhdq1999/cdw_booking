package com.booking.services.impl;

import com.booking.converter.AddressConverter;
import com.booking.converter.RoomConverter;
import com.booking.entity.*;
import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.RoomResponse;
import com.booking.repository.AddressRepository;
import com.booking.repository.RoomRepository;
import com.booking.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements IRoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;

    @Override
    public List<RoomResponse> getAll() {
        return roomRepository.findAll()
                .stream().map(room -> RoomConverter.toResponse(room))
                .collect(Collectors.toList());
    }
    @Override
    public RoomResponse save(RoomRequest roomRequest) {
        RoomEntity rawEntity = RoomConverter.toEntity(roomRequest);

        Address addressRawEntity = AddressConverter.toEntity(roomRequest.getAddress());
        Address addressEntity = addressRepository.save(addressRawEntity);

        rawEntity.setAddress(addressEntity);

        RoomEntity entity = roomRepository.save(rawEntity);

        List<GalleryEntity> images = galleryService.saveAllByRoom(roomRequest.getImages(), entity.getId());
        List<ReviewEntity> reviews = reviewService.saveAllByRoom(roomRequest.getReviews(), entity.getId());

        entity.setImages(images);
        entity.setReviews(reviews);

        return RoomConverter.toResponse(entity);
    }
    @Override
    public RoomResponse update(Long id, RoomRequest roomRequest) {
        RoomEntity rawEntity = RoomConverter.toEntity(roomRequest);
        RoomEntity entity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found room with id:" + id));
        if (entity != null) {
            rawEntity.setId(id);
            roomRepository.save(rawEntity);
            return RoomConverter.toResponse(rawEntity);
        } else
            return null;
    }
    @Override
    public void delete(Long id) {
        RoomEntity entity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found room with id:" + id));
        if (entity != null) roomRepository.deleteById(id);
    }
    @Override
    public RoomResponse getById(Long id) {
        RoomEntity entity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("Not found room with id:" + id)));
        return RoomConverter.toResponse(entity);
    }
}
