package com.softuni.modelmapper.dtos;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAddressDto {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private BigDecimal salary;
    private String addressName;

    @Override
    public String toString() {
        return "EmployeeDto: " +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", birthday = '" + birthday + '\'' +
                ", address = '" + addressName + '\'' +
                ", salary = " + salary;
    }
}
