package com.booking.services.impl;

import com.booking.converter.OrderConverter;
import com.booking.entity.OrderEntity;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;
import com.booking.repository.OrderRepository;
import com.booking.repository.RoomRepository;
import com.booking.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public OrderResponse create(OrderRequest request) {

        OrderEntity orderSaved = orderRepository.save(OrderConverter.toEntity(request));
        return OrderConverter.toResponse(orderSaved);
//        return null;
    }

    @Override
    public List<OrderResponse> getAll() {
        return null;
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found Order by id : " + id)
        );
        return OrderConverter.toResponse(order);
    }

}
