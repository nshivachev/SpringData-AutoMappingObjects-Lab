package com.softuni.modelmapper.dtos;

import com.google.gson.annotations.Expose;
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
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private BigDecimal salary;
    @Expose
    private LocalDate birthday;
    @Expose
    private AddressDto address;
    @Expose
    private ManagerDto manager;

    public CreateEmployeeDto(String firstName, LocalDate birthday) {
        this.firstName = firstName;
        this.birthday = birthday;
    }

    public CreateEmployeeDto(String firstName, String lastName, BigDecimal salary, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.birthday = birthday;
    }
}
