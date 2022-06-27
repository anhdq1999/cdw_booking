package com.booking.services;

import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;

import java.util.List;

public interface IAddressServiceImpl {


    List<AddressResponse> getAll();

    AddressResponse getById(Long id);

    AddressResponse save(AddressRequest addressRequest);

    AddressResponse update(Long id, AddressRequest addressRequest);

    void delete(Long id);
}
