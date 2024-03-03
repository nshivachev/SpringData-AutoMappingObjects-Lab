package com.softuni.modelmapper.dtos;

import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ManagerDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<EmployeeDto> employees;

    public ManagerDto() {
        this.employees = new ArrayList<>();
    }

    public ManagerDto(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("%s %s | Employees: %d%n", firstName, lastName, employees.size()));
        employees.forEach(employee ->
                sb.append(String.format("    - %s %s %.2f%n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getSalary())));

        return sb.toString().trim();
    }
}
