package com.javafullstackguru.service;

import com.javafullstackguru.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee getEmployeeById(String id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);
}
