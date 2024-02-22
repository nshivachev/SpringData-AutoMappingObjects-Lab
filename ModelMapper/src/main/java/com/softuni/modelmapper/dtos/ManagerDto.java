package com.softuni.modelmapper.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManagerDto {
    private String firstName;
    private String lastName;
    private List<EmployeeDto> employees;

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
