package com.softuni.modelmapper.dtos;

import com.google.gson.annotations.Expose;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeAddressDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private LocalDate birthday;
    @Expose
    private BigDecimal salary;
    @Expose
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
