package com.yashavula.cisc593FianlProject.repositories;

import com.yashavula.cisc593FianlProject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmployeeId(String employeeId);
}
