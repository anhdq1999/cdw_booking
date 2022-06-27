package com.booking.converter;

import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;

public class AddressConverter {

    public static AddressResponse toResponse(Address entity) {
        return AddressResponse.builder()
                .id(entity.getId())
                .country(entity.getCountry())
                .province(entity.getProvince())
                .district(entity.getDistrict())
                .ward(entity.getWard())
                .street(entity.getStreet())
                .googleAddress(entity.getGoogleAddress())
                .build();
    }

    public static Address toEntity(AddressRequest request) {
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
