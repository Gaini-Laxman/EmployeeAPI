package com.javafullstackguru.service;

import com.javafullstackguru.entity.Employee;
import com.javafullstackguru.exception.EmployeeAlreadyExistException;
import com.javafullstackguru.exception.EmployeeNotFoundException;
import com.javafullstackguru.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private static final String EMPLOYEE_NOT_FOUND_MSG = "Employee Not Available with ID : ";
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            logger.warn("Attempt to creating Existing Employee with ID :" + employee.getId());
            throw new EmployeeAlreadyExistException(" " + employee.getId());
        }
        logger.info("Creating Employee: {}", employee);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(String id) {
        logger.info("Fetching Employee By ID : {}", id);
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND_MSG + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        logger.info("Fetching All Employee : ");
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            logger.warn("Attempt to updating non existing employee with ID : {}", id);
            throw new EmployeeAlreadyExistException("Cant Update, Employee Not Found with ID : {} " + id);
        }
        employee.setId(id);
        logger.warn("Updating employee with ID : {}", id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        var employeeDelete = employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Cant Delete Employee Not found with ID : " + id));
         employeeRepository.delete(employeeDelete);
    }
}
