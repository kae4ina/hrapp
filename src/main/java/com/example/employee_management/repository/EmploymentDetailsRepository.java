package com.example.employee_management.repository;

import com.example.employee_management.models.EmploymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentDetailsRepository extends JpaRepository<EmploymentDetails, Long> {
}
