package com.yashavula.cisc593FianlProject.controller;


import com.yashavula.cisc593FianlProject.domain.DailyHours;
import com.yashavula.cisc593FianlProject.domain.Employee;
import com.yashavula.cisc593FianlProject.service.DailyHoursService;
import com.yashavula.cisc593FianlProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DailyHoursService dailyHoursService;

    @GetMapping("/getEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }


    @PostMapping("/saveEmployee")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        } else {
            try {
                return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
            } catch (Exception e) {
                return ResponseEntity.ok().body(e.getMessage());
            }
        }
    }

    @GetMapping("/getEmployee/{employeeId}")
    public ResponseEntity<Object> getEmployee(@PathVariable("employeeId") String employeeId) {
        try {
            return ResponseEntity.ok().body(employeeService.getEmployee(employeeId));
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        } else {
            try {
                Employee emp = employeeService.getEmployee(employee.getEmployeeId());

                if (emp == null || emp.getEmail() == null) {
                    return ResponseEntity.ok().body("Invalid Employee Id");
                } else {
                    employee.setId(emp.getId());
                    return ResponseEntity.ok().body(employeeService.saveEmployee(employee));
                }
            } catch (Exception e) {
                return ResponseEntity.ok().body(e.getMessage());
            }
        }
    }



}
