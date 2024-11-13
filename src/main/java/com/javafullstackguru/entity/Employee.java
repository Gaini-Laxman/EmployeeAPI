package com.javafullstackguru.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee_tbl")
public class Employee {

    @Column(name = "Employee_ID", nullable = false)
    @Id
    private String id;

    @Column(name = "Employee_Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Salary", nullable = false)
    private Double salary;
}
