package com.booking.services.impl;

import com.booking.converter.GalleryConverter;
import com.booking.entity.GalleryEntity;
import com.booking.entity.RoomEntity;
import com.booking.payload.request.GalleryRequest;
import com.booking.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    public List<GalleryEntity> getAll() {
        return galleryRepository.findAll();
    }

    public List<GalleryEntity> getAllByRoomId(Long id){
        return galleryRepository.findAllByRoomId(id);
    }

    public GalleryEntity save(GalleryRequest galleryRequest, RoomEntity room) {
        GalleryEntity entity = GalleryConverter.toEntity(galleryRequest);
        entity.setRoom(room);
        return galleryRepository.save(entity);
    }

    public List<GalleryEntity> saveAll(List<GalleryRequest> requests,RoomEntity room) {
        List<GalleryEntity> entities = requests.stream().map(request -> {
           GalleryEntity entity= GalleryConverter.toEntity(request);
           entity.setRoom(room);
           return entity;
        }).collect(Collectors.toList());
        return galleryRepository.saveAll(entities);
    }

    public void update(Long id, GalleryRequest galleryRequest) {
        GalleryEntity entity = GalleryConverter.toEntity(galleryRequest);
        Optional<GalleryEntity> optional = galleryRepository.findById(id);
        if (optional.isPresent()) {
            entity.setId(id);
            galleryRepository.save(entity);
        }
    }

    public void delete(Long id) {
        galleryRepository.deleteById(id);
    }
}
