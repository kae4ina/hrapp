package com.example.employee_management.service;
import com.example.employee_management.models.EmploymentDetails;
import com.example.employee_management.models.Position;
import com.example.employee_management.repository.EmploymentDetailsRepository;
import com.example.employee_management.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public void savePosition(Position position) {
        positionRepository.save(position);
    }

    public Position getPositionById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }
}
