package com.booking.services;

import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;

import java.util.List;

public interface IAddressServiceImpl {


    List<AddressResponse> getAllAddress();

    AddressResponse findAddressById(Long id);

    AddressResponse createAddress(AddressRequest addressRequest);

//    AddressResponse createAddress(Address address);

    Address createAddress(Address address);

    AddressResponse editAddress(Long id, AddressRequest addressRequest);

    AddressResponse deleteAddress(AddressRequest addressRequest);
}
