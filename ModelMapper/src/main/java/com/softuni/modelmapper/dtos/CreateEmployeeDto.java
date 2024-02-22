package com.softuni.modelmapper.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private LocalDate birthday;
    private AddressDto address;
    private ManagerDto manager;
}
