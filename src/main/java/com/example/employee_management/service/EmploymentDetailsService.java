package com.example.employee_management.service;

import com.example.employee_management.models.EmploymentDetails;
import com.example.employee_management.repository.EmploymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmploymentDetailsService {
    private final EmploymentDetailsRepository employmentDetailsRepository;

    @Autowired
    public EmploymentDetailsService(EmploymentDetailsRepository employmentDetailsRepository) {
        this.employmentDetailsRepository = employmentDetailsRepository;
    }

    public List<EmploymentDetails> getAllEmploymentDetails() {
        return employmentDetailsRepository.findAll();
    }

    public void saveEmploymentDetails(EmploymentDetails details) {
        employmentDetailsRepository.save(details);
    }

    public EmploymentDetails getEmploymentDetailsById(Long id) {
        return employmentDetailsRepository.findById(id).orElse(null);
    }

    public void deleteEmploymentDetails(Long id) {
        employmentDetailsRepository.deleteById(id);
    }
}