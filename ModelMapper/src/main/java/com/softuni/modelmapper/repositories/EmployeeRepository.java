package com.softuni.modelmapper.repositories;

import com.softuni.modelmapper.dtos.EmployeeDto;
import com.softuni.modelmapper.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select new com.softuni.modelmapper.dtos.EmployeeDto(e.firstName, e.lastName, e.salary, e.manager)" +
            " from Employee e where year(e.birthday) < year(:birthday)" +
            " order by e.salary desc ")
    List<EmployeeDto> findAllByBirthdayBeforeOrderBySalaryDesc(LocalDate birthday);
}
