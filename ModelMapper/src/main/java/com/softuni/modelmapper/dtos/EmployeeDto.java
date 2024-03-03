package com.softuni.modelmapper.dtos;

import com.google.gson.annotations.Expose;
import com.softuni.modelmapper.entities.Employee;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private BigDecimal salary;
    @Expose
    private Employee manager;

    public EmployeeDto(String firstName, String lastName, BigDecimal salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeDto: " +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", salary = '" + salary + '\'' +
                ", manager = " + manager.getLastName();
    }
}
