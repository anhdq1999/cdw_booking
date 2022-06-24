package com.booking.services.impl;

import com.booking.converter.OrderConverter;
import com.booking.entity.OrderEntity;
import com.booking.repository.OrderRepository;
import com.booking.services.IOderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOderService {
    @Autowired
    private OrderRepository repository;

    private OrderConverter orderConverter;

    @Override
    public OrderEntity createOrder(OrderEntity request) {

        return null;
    }

    @Override
    public List<OrderEntity> getAll() {
        return repository.findAll();

    }

    @Override
    public OrderEntity getOrderById(Long id) {
        Optional<OrderEntity> orderEntity = repository.findById(id);
        return orderEntity.orElse(null);
    }


}
