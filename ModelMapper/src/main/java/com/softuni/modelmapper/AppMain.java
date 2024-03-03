package com.softuni.modelmapper;

import com.google.gson.Gson;
import com.softuni.modelmapper.dtos.AddressDto;
import com.softuni.modelmapper.dtos.CreateEmployeeDto;
import com.softuni.modelmapper.dtos.ManagerDto;
import com.softuni.modelmapper.services.AddressService;
import com.softuni.modelmapper.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

@Component
public class AppMain implements CommandLineRunner {
    private final AddressService addressService;
    private final EmployeeService employeeService;
    private final Scanner scanner;
    private final Gson gson;

    @Autowired
    public AppMain(AddressService addressService, EmployeeService employeeService, Gson gson) {
        this.addressService = addressService;
        this.employeeService = employeeService;
        this.gson = gson;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        //Task 3
        employeeService
                .createEmployee(new CreateEmployeeDto(
                                "FirstNameDTO",
                                "LastNameDTO",
                                BigDecimal.TEN,
                                LocalDate.of(1890, 1, 1),
                                new AddressDto("AddressDTO"),
                                new ManagerDto("FirstNameManagerDTO", "LastNameManagerDTO", new ArrayList<>())
                        )
                );

        CreateEmployeeDto createEmployeeDtoFromJson = gson.fromJson("{\"firstName\":\"FirstNameDTO\",\"lastName\":\"LastNameDTO\",\"salary\":10,\"birthday\":\"1890-01-01\",\"address\":{\"name\":\"AddressDTO\"},\"manager\":{\"firstName\":\"FirstNameManagerDTO\",\"lastName\":\"LastNameManagerDTO\",\"employees\":[]}}", CreateEmployeeDto.class);

        System.out.println(gson.toJson(createEmployeeDtoFromJson));

        employeeService.createEmployee(createEmployeeDtoFromJson);

        employeeService
                .findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate.of(1990, 1, 1))
                .forEach(System.out::println);

        System.out.println(gson.toJson(employeeService
                .findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate.of(1990, 1, 1))));
    }
}
