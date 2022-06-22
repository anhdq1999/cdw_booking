package com.booking.converter;

import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;

public class AddressConverter {
    private static AddressConverter instance;

    public static AddressConverter getInstance() {
        if (instance == null) {
            instance = new AddressConverter();
        }
        return instance;
    }

    public AddressResponse toResponse(Address entity) {
        return AddressResponse.builder()
                .country(entity.getCountry())
                .province(entity.getProvince())
                .district(entity.getDistrict())
                .ward(entity.getWard())
                .street(entity.getStreet())
                .googleAddress(entity.getGoogleAddress())
                .build();
    }

    public Address toEntity(AddressRequest request) {
        return Address.builder()
                .country(request.getCountry())
                .province(request.getProvince())
                .district(request.getDistrict())
                .ward(request.getWard())
                .street(request.getStreet())
                .googleAddress(request.getGoogleAddress())
                .build();
    }
}
