package com.booking.services;

import com.booking.entity.GalleryEntity;
import com.booking.payload.request.GalleryRequest;

import java.util.List;

public interface IGalleryService {

     List<GalleryEntity> getAll();

     List<GalleryEntity> getAllByRoomId(Long id);

     GalleryEntity save(GalleryRequest galleryRequest, Long roomId);

     List<GalleryEntity> saveAllByRoom(List<GalleryRequest> requests,Long roomId);

     void update(Long id, GalleryRequest galleryRequest) ;

     void deleteById(Long id);
}
