package com.softuni.modelmapper.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Basic
    private BigDecimal salary;

    @Basic
    private LocalDate birthday;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Address address;

    @Column(name = "is_on_holiday")
    private boolean isOnHoliday;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Employee manager;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Employee> employees;
}
