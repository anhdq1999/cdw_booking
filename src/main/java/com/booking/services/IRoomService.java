package com.booking.services;

import com.booking.payload.request.RoomRequest;
import com.booking.payload.response.RoomResponse;

import java.util.List;

public interface IRoomService {

    List<RoomResponse> getAll();

    RoomResponse save(RoomRequest roomRequest);

    RoomResponse update(Long id, RoomRequest roomRequest);

    void delete(Long id);

    RoomResponse getById(Long id);
}
