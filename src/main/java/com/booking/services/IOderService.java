package com.booking.services;

import com.booking.entity.OrderEntity;

import java.util.List;

public interface IOderService {
    OrderEntity createOrder(OrderEntity request);

    List<OrderEntity> getAll();

    OrderEntity getOrderById(Long id);


}
