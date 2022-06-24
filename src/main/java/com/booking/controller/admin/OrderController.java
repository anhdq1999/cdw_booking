package com.booking.controller.admin;

import com.booking.common.Response;
import com.booking.converter.OrderConverter;
import com.booking.entity.OrderEntity;
import com.booking.payload.request.OrderRequest;
import com.booking.payload.response.OrderResponse;
import com.booking.services.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/admin/order")
//@PreAuthorize("hasRole('ADMIN')")
@Slf4j
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    private OrderConverter orderConverter;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<OrderResponse> listOrder = orderService.getAll().stream().map(orderEntity -> orderConverter.toResponse(orderEntity)).collect(Collectors.toList());
        return ResponseEntity.ok().body(Response.success("Get all order successfully", listOrder));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        OrderEntity order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok().body(Response.success("Get Order by id successfully", orderConverter.toResponse(order)));
        } else {
            return ResponseEntity.status(500).body(Response.fail("Get Order by id Failed"));
        }
    }

    @PostMapping
    public void createOrder(@RequestBody OrderRequest request) {
        log.info("[ORDER] {}", request);
    }


}
