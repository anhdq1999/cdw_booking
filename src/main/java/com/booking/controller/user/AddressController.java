package com.booking.controller.user;

import com.booking.payload.response.AddressResponse;
import com.booking.services.impl.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public List<AddressResponse> getAll() {
        return addressService.getAll();
    }
}
