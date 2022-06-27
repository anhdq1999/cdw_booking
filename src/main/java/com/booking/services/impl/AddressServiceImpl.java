package com.booking.services.impl;

import com.booking.converter.AddressConverter;
import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;
import com.booking.repository.AddressRepository;
import com.booking.services.IAddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddressServiceImpl {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressResponse> getAll() {
        return addressRepository.findAll()
                .stream().map(address->AddressConverter.toResponse(address))
                .collect(Collectors.toList());
    }

    @Override
    public AddressResponse getById(Long id) {
        Address entity = addressRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not found address with id:"+id));
        AddressResponse response =AddressConverter.toResponse(entity);
        return response;
    }

    @Override
    public AddressResponse save(AddressRequest addressRequest) {
        Address rawEntity = AddressConverter.toEntity(addressRequest);
        Address entity =addressRepository.save(rawEntity);
        if(entity!=null) return AddressConverter.toResponse(entity);
        return null;
    }

    @Override
    public AddressResponse update(Long id, AddressRequest addressRequest) {
        Address entity = addressRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Not found Address by id:"+id));
        Address rawNewEntity=AddressConverter.toEntity(addressRequest);
        rawNewEntity.setId(entity.getId());
        Address newEntity = addressRepository.save(rawNewEntity);
        if(newEntity!=null) return AddressConverter.toResponse(newEntity);
        return null;
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
