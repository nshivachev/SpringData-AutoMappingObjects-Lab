package com.softuni.modelmapper.services;

import com.softuni.modelmapper.dtos.AddressDto;
import com.softuni.modelmapper.entities.Address;
import com.softuni.modelmapper.repositories.AddressRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper mapper) {
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Address create(AddressDto addressDto) {
        Address address = mapper.map(addressDto, Address.class);

        return addressRepository.save(address);
    }
}
