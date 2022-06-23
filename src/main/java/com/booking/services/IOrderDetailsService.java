package com.booking.services;

import com.booking.payload.response.OrderDetailsResponse;

import java.util.List;

public interface IOrderDetailsService {
    List<OrderDetailsResponse> getAll();


}
