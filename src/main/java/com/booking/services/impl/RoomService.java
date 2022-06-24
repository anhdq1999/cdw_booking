package com.booking.services.impl;

import com.booking.converter.RoomConverter;
import com.booking.entity.RoomEntity;
import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.RoomResponse;
import com.booking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomEntity> getAll(){
        return roomRepository.findAll();
    }
    public RoomEntity save(RoomRequest roomRequest){
        RoomEntity entity=RoomConverter.toEntity(roomRequest);
        return roomRepository.save(entity);
    }
    public RoomEntity update(Long id,RoomRequest roomRequest){
        RoomEntity entity=RoomConverter.toEntity(roomRequest);
        Optional<RoomEntity> optionalRoom= roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            entity.setId(optionalRoom.get().getId());
            return roomRepository.save(entity);
        }else{
            return null;
        }
    }
    public void delete(Long id){
        roomRepository.deleteById(id);
    }

    public RoomEntity getById(Long id){
        Optional<RoomEntity> optionalRoom= roomRepository.findById(id);
        if(optionalRoom.isPresent()){
            return optionalRoom.get();
        }else{
            return null;
        }
    }
}
