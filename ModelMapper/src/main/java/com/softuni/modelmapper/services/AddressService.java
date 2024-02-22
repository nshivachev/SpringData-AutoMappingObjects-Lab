package com.softuni.modelmapper.services;

import com.softuni.modelmapper.dtos.AddressDto;
import com.softuni.modelmapper.entities.Address;

public interface AddressService {
    Address create(AddressDto addressDto);
}
