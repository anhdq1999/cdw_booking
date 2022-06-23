package com.booking.services;

import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;

public interface IOderService {
    OrderResponse createOrder(OrderRequest request);

}
