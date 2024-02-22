package com.softuni.modelmapper.services;

import com.softuni.modelmapper.dtos.CreateEmployeeDto;
import com.softuni.modelmapper.dtos.EmployeeDto;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {
    void createEmployee(CreateEmployeeDto createEmployeeDto);

    List<EmployeeDto> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate birthday);
}
