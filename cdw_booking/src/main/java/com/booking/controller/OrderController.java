package com.booking.controller;

import com.booking.common.Response;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;
import com.booking.services.email.MailService;
import com.booking.services.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;



    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(Response.success("GET All Success", orderService.getAll()));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.create(request);

        return ResponseEntity.ok().body(Response.success("Create order successfully ", response));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(Response.success("Get order by id successfully", orderService.getOrderById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrderRequest request) {
        OrderResponse response = orderService.updateById(id, request);
        return ResponseEntity.ok().body(Response.success("Update order by id successfully", response));
    }
}

