package com.booking.services.impl;

import com.booking.converter.OrderConverter;
import com.booking.entity.OrderEntity;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;
import com.booking.repository.OrderRepository;
import com.booking.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderResponse create(OrderRequest request) {
        OrderEntity orderSaved = orderRepository.save(OrderConverter.toEntity(request));
        return OrderConverter.toResponse(orderSaved);
    }

    @Override
    public List<OrderResponse> getAll() {
        List<OrderEntity> entityList = orderRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (OrderEntity order : entityList) {
            orderResponses.add(OrderConverter.toResponse(order));
        }
        return orderResponses;
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        OrderEntity order = orderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found Order by id : " + id)
        );
        return OrderConverter.toResponse(order);
    }

    @Override
    public OrderResponse updateById(Long id, OrderRequest request) {

        OrderEntity order = orderRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found Order by id : " + id)
        );

        order.setAdults(request.getAdults());
        order.setCheckIn(request.getCheckIn());
        order.setCheckOut(request.getCheckOut());
        order.setChild(request.getChild());
        order.setInfants(request.getInfants());
        order.setNote(request.getNote());
        order.setPaymentMethod(request.getPaymentMethod());
        order.setTaxPrice(request.getTaxPrice());
        order.setTotalPrice(request.getTotalPrice());
        order.setPaidAt(request.getPaidAt());
        order.setRefundAt(request.getRefundAt());
        order.setCustomerName(request.getCustomerName());
        order.setCustomerPhone(request.getCustomerPhone());
        return OrderConverter.toResponse(orderRepository.save(order));
    }

}
