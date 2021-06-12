package com.yashavula.cisc593FianlProject.service.impl;

import com.yashavula.cisc593FianlProject.domain.Employee;
import com.yashavula.cisc593FianlProject.repositories.EmployeeRepository;
import com.yashavula.cisc593FianlProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
      return  employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }
}
