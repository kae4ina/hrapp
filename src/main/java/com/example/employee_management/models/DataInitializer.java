package com.example.employee_management.models;

import com.example.employee_management.repository.DepartmentRepository;
import com.example.employee_management.repository.PositionRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private PositionRepository positionRepository;

    @PostConstruct
    public void init() {
        // Добавление департаментов
        if (departmentRepository.count() == 0) {
            departmentRepository.save(new Department("Отдел разработки"));
            departmentRepository.save(new Department("Отдел тестирования"));
            departmentRepository.save(new Department("Отдел маркетинга"));
        }

        // Добавление позиций
        if (positionRepository.count() == 0) {
            positionRepository.save(new Position("Разработчик"));
            positionRepository.save(new Position("Тестировщик"));
            positionRepository.save(new Position("Менеджер"));
        }
    }
}