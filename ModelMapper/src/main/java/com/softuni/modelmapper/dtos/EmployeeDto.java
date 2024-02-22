package com.softuni.modelmapper.dtos;

import com.softuni.modelmapper.entities.Employee;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private Employee manager;

    @Override
    public String toString() {
        return "EmployeeDto: " +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", salary = '" + salary + '\'' +
                ", manager = " + manager.getLastName();
    }
}
