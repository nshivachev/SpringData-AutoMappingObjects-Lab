package com.softuni.modelmapper.services;

import com.softuni.modelmapper.dtos.CreateEmployeeDto;
import com.softuni.modelmapper.dtos.EmployeeDto;
import com.softuni.modelmapper.entities.Address;
import com.softuni.modelmapper.entities.Employee;
import com.softuni.modelmapper.repositories.AddressRepository;
import com.softuni.modelmapper.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final ModelMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AddressRepository addressRepository, ModelMapper mapper) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void createEmployee(CreateEmployeeDto createEmployeeDto) {
        Employee employee = mapper.map(createEmployeeDto, Employee.class);

        //In case the address field cannot be mapped due to a different name
        Optional<Address> address = addressRepository.findByName(createEmployeeDto.getAddress().getName());
        address.ifPresent(employee::setAddress);

        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate birthday) {
        return this.employeeRepository.findAllByBirthdayBeforeOrderBySalaryDesc(birthday);
    }
}
