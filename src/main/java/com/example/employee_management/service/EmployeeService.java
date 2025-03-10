package com.example.employee_management.service;

import com.example.employee_management.models.Employee;
import com.example.employee_management.repository.EmployeeRepository;
import com.example.employee_management.repository.EmploymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmploymentDetailsRepository employmentDetailsRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EmploymentDetailsRepository employmentDetailsRepository) {
        this.employeeRepository = employeeRepository;
        this.employmentDetailsRepository = employmentDetailsRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
