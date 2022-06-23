package com.booking.services.impl;

import com.booking.converter.OrderConverter;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;
import com.booking.repository.OrderRepository;
import com.booking.services.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderServiceImpl implements IOderService {
    @Autowired
    private OrderRepository repository;

    private OrderConverter orderConverter;


    @Override
    public OrderResponse createOrder(OrderRequest request) {

        return null;
    }

}
