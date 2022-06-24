package com.booking.services.impl;

import com.booking.converter.GalleryConverter;
import com.booking.entity.GalleryEntity;
import com.booking.payload.request.GalleryRequest;
import com.booking.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    public List<GalleryEntity> getAll(){
        return galleryRepository.findAll();
    }

    public GalleryEntity save(GalleryRequest galleryRequest){
        GalleryEntity entity = GalleryConverter.toEntity(galleryRequest);
        return galleryRepository.save(entity);
    }

    public void update(Long id,GalleryRequest galleryRequest){
        GalleryEntity entity= GalleryConverter.toEntity(galleryRequest);
        Optional<GalleryEntity> optional = galleryRepository.findById(id);
        if(optional.isPresent()) {
            entity.setId(id);
            galleryRepository.save(entity);
        }
    }
    public void delete(Long id){
        galleryRepository.deleteById(id);
    }
}
