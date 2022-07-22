package com.booking.services;

import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse create(OrderRequest request);

    List<OrderResponse> getAll();

    OrderResponse getOrderById(Long id);

}
