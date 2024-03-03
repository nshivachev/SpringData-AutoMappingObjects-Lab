package com.softuni.modelmapper;

import com.google.gson.*;
import com.softuni.modelmapper.dtos.EmployeeAddressDto;
import com.softuni.modelmapper.dtos.ManagerDto;
import com.softuni.modelmapper.entities.Address;
import com.softuni.modelmapper.entities.Employee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class ModelMapperMain implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(LocalDate.class, (JsonSerializer<LocalDate>) (localDate, type, jsonSerializationContext) -> new JsonPrimitive(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE)))
                .registerTypeAdapter(LocalDate.class, (JsonDeserializer<LocalDate>) (jsonElement, type, jsonDeserializationContext) -> LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString()))
                .create();

        //Task 1
        Employee employee = Employee.builder()
                .firstName("Niki")
                .lastName("Sh")
                .salary(BigDecimal.TEN)
                .birthday(LocalDate.of(1990, 10, 31))
                .address(Address.builder().name("21 str, Yambol").build())
                .isOnHoliday(true)
                .build();

        EmployeeAddressDto employeeAddressDto = modelMapper.map(employee, EmployeeAddressDto.class);
        System.out.println(employeeAddressDto);

        EmployeeAddressDto employeeAddressDtoFromJson = gson.fromJson("{\"firstName\":\"Niki\",\"lastName\":\"Sh\",\"salary\":10,\"birthday\":\"1990-10-31\",\"addressName\":\"21 str, Yambol\"}", EmployeeAddressDto.class);
        System.out.println(gson.toJson(employeeAddressDtoFromJson));

//        //PropertyMapper
//        PropertyMap<Employee, EmployeeAddressDto> propertyMap = new PropertyMap<Employee, EmployeeAddressDto>() {
//            @Override
//            protected void configure() {
//                map().setAddressOutOfConvention(source.getAddress().getName());
//            }
//        };
//        modelMapper.addMappings(propertyMap);
//        EmployeeAddressDto employeeAddressDto = modelMapper.map(employee, EmployeeAddressDto.class);
//
//        //TypeMapper
//        TypeMap<Employee, EmployeeAddressDto> typeMap = modelMapper.createTypeMap(Employee.class, EmployeeAddressDto.class);
//        typeMap.addMappings(mapping -> mapping.map(
//                source -> source.getAddress().getName(),
//                EmployeeAddressDto::setAddressOutOfConvention));//
//        typeMap.validate();
//        EmployeeAddressDto employeeAddressDto = typeMap.map(employee);

        //Task 2
        List<Employee> employeesFirstGroups = List.of(
                Employee.builder().firstName("Stephen").lastName("Bjorn").address(new Address("11 str.")).salary(new BigDecimal(43000)).build(),
                Employee.builder().firstName("Kirilyc").lastName("Lefi").address(new Address("12 str.")).salary(new BigDecimal(40000)).build());

        List<Employee> employeesSecondGroups = List.of(
                Employee.builder().firstName("Jurgen").lastName("Straus").address(new Address("13 str.")).salary(new BigDecimal("1000.45")).build(),
                Employee.builder().firstName("Moni").lastName("Kozinac").address(new Address("14 str.")).salary(new BigDecimal("2030.99")).build());

        List<Employee> managers = List.of(
                Employee.builder().firstName("Steve").lastName("Jobbsen").address(new Address("15 str.")).employees(employeesFirstGroups).build(),
                Employee.builder().firstName("Carl").lastName("Kormac").address(new Address("16 str.")).employees(employeesSecondGroups).build());

        managers.stream().map(e -> modelMapper.map(e, ManagerDto.class)).forEach(System.out::println);

        List<ManagerDto> managerDtoFromJson = List.of(
                gson.fromJson("{\"firstName\":\"Steve\",\"lastName\":\"Jobbsen\",\"address\":{\"name\":\"15 str.\"}, employees:[{\"firstName\":\"Stephen\",\"lastName\":\"Bjorn\", \"salary\":150}]}", ManagerDto.class),
                gson.fromJson("{\"firstName\":\"Carl\",\"lastName\":\"Kormac\",\"address\":{\"name\":\"16 str.\"}, \"employees\":[{\"firstName\":\"Jurgen\",\"lastName\":\"Straus\", \"salary\":200}]}", ManagerDto.class));

        System.out.println(gson.toJson(managerDtoFromJson));
    }
}
