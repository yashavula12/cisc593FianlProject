package com.yashavula.cisc593FianlProject.service;

import com.yashavula.cisc593FianlProject.domain.Employee;

import java.util.List;

public interface EmployeeService {


    public List<Employee> getAllEmployees();

    public Employee saveEmployee(Employee employee);

    public Employee getEmployee(String employeeId);

}
