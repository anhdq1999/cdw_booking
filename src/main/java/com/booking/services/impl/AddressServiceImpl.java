package com.booking.services.impl;

import com.booking.converter.AddressConverter;
import com.booking.entity.Address;
import com.booking.payload.request.AddressRequest;
import com.booking.payload.response.AddressResponse;
import com.booking.repository.AddressRepository;
import com.booking.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;

    private AddressConverter addressConverter;

    @Override
    public List<AddressResponse> getAllAddress() {
        List<Address> listAddressRepository = addressRepository.findAll();
        List<AddressResponse> listAddressResponse = new ArrayList<>();
        for (Address address : listAddressRepository) {
            listAddressResponse.add(addressConverter.toResponse(address));
        }
        return listAddressResponse;
    }

    @Override
    public AddressResponse findAddressById(Long id) {
        Address addressRepo = addressRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found address by id : " + id));
        return addressConverter.toResponse(addressRepo);
    }

    @Override
    public AddressResponse createAddress(AddressRequest addressRequest) {
        Address address = addressConverter.toEntity(addressRequest);
        Address saved = addressRepository.save(address);
        return addressConverter.toResponse(saved);
    }
//
//    @Override
//    public AddressResponse createAddress(Address address) {
//        Address saved = addressRepository.save(address);
//        return addressConverter.toResponse(saved);
//    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }


    @Override
    public AddressResponse editAddress(Long id, AddressRequest addressRequest) {
        Optional<Address> addressRepo = addressRepository.findById(id);
        Address address = addressConverter.toEntity(addressRequest);
        if (addressRepo.isPresent()) {
            Address _address = addressRepo.get();
            _address.setCountry(address.getCountry());
            _address.setProvince(address.getProvince());
            _address.setDistrict(address.getDistrict());
            _address.setWard(address.getWard());
            _address.setStreet(address.getWard());
            _address.setStreet(address.getStreet());
            addressRepository.save(_address);
            return addressConverter.toResponse(_address);
        }
        return null;
    }

    @Override
    public AddressResponse deleteAddress(AddressRequest addressRequest) {
        return null;
    }
}
