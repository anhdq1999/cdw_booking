package com.booking.services.impl;

import com.booking.converter.AddressConverter;
import com.booking.converter.GalleryConverter;
import com.booking.converter.ReviewConverter;
import com.booking.converter.RoomConverter;
import com.booking.entity.*;
import com.booking.payload.request.GalleryRequest;
import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.GalleryResponse;
import com.booking.payload.response.RoomResponse;
import com.booking.payload.response.roomRespsonse.RoomGalleryResponse;
import com.booking.payload.response.roomRespsonse.RoomReviewResponse;
import com.booking.repository.AddressRepository;
import com.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private GalleryService galleryService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ReviewService reviewService;

    public List<RoomResponse> getAll() {
        return roomRepository.findAll()
                .stream().map(room -> {
//                    List<RoomGalleryResponse> images =room.getImages()
//                            .stream().map(image->GalleryConverter.toRoomResponse(image))
//                            .collect(Collectors.toList());
//                    List<RoomReviewResponse> reviews =room.getReviews()
//                            .stream().map(review->ReviewConverter.toRoomResponse(review))
//                            .collect(Collectors.toList());
                    RoomResponse response = RoomConverter.toResponse(room);
//                    response.setReviews(reviews);
//                    response.setImages(images);
                    return response;
                })
                .collect(Collectors.toList());
    }

    public RoomResponse save(RoomRequest roomRequest) {
        RoomEntity rawEntity = RoomConverter.toEntity(roomRequest);

        Address addressRawEntity = AddressConverter.toEntity(roomRequest.getAddress());
        Address addressEntity = addressRepository.save(addressRawEntity);

        CategoryEntity category = categoryService.getById(roomRequest.getCategoryId());

        UserEntity user = userService.getById(roomRequest.getUserId());

        rawEntity.setAddress(addressEntity);
        rawEntity.setCategory(category);
        rawEntity.setUser(user);

        RoomEntity entity = roomRepository.save(rawEntity);

        List<GalleryEntity> images = galleryService.saveAll(roomRequest.getImages(), entity);
        List<ReviewEntity> reviews = reviewService.saveAll(roomRequest.getReviews(), entity);

        entity.setImages(images);
        entity.setReviews(reviews);

        RoomResponse response = RoomConverter.toResponse(entity);
        return response;
    }

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

    public void delete(Long id) {
        RoomEntity entity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found room with id:" + id));
        if (entity != null) roomRepository.deleteById(id);
    }

    public RoomResponse getById(Long id) {
        RoomEntity entity = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(("Not found room with id:" + id)));
        return RoomConverter.toResponse(entity);
    }
}
