package com.example.employee_management.controller;



import com.example.employee_management.models.Department;
import com.example.employee_management.models.Employee;
import com.example.employee_management.models.Position;
import com.example.employee_management.service.DepartmentService;
import com.example.employee_management.service.EmployeeService;
import com.example.employee_management.service.EmploymentDetailsService;
import com.example.employee_management.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final EmploymentDetailsService employmentDetailsService;

    @Autowired
    public EmployeeController(EmployeeService employeeService,
                              DepartmentService departmentService,
                              PositionService positionService,
                              EmploymentDetailsService employmentDetailsService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.positionService = positionService;
        this.employmentDetailsService = employmentDetailsService;
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee/list";
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee/add";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/edit/{id}")
    public String showEditEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departmentService.getAllDepartments());
        model.addAttribute("positions", positionService.getAllPositions());
        return "employee/edit";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }
    @ModelAttribute("departments")
    public List<Department> populateDepartments() {
        return departmentService.getAllDepartments();
    }

    @ModelAttribute("positions")
    public List<Position> populatePositions() {
        return positionService.getAllPositions();
    }
}


