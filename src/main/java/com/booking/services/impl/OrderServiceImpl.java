package com.booking.services.impl;

import com.booking.converter.OrderConverter;
import com.booking.entity.OrderDetailsEntity;
import com.booking.entity.OrderEntity;
import com.booking.repository.OrderDetailsRepository;
import com.booking.repository.OrderRepository;
import com.booking.services.IOderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements IOderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderConverter orderConverter;

    @Override
    public OrderEntity createOrder(OrderEntity request) {
        OrderEntity order = repository.save(request);
        log.info("request {}", request);
        return order;
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
