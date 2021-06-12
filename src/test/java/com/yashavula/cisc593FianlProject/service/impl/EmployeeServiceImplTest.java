package com.yashavula.cisc593FianlProject.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yashavula.cisc593FianlProject.domain.Employee;
import com.yashavula.cisc593FianlProject.repositories.EmployeeRepository;



@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	 private EmployeeRepository employeeRepository;
	
	private Employee employee = new Employee();
	
	@Before
	public void doSetup() {
		
		employee.setId(3);

	}
	
	@Test
	public void testGetAllEmployees() {
		when(employeeRepository.findAll()).thenReturn(Stream.of(employee).collect(Collectors.toList()));
		assertEquals(1, employeeServiceImpl.getAllEmployees().size());
	}
	
	@Test
	public void testSaveEmployee() {
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeServiceImpl.saveEmployee(employee));
	}
	
	@Test
	public void testGetEmployee() {
		when(employeeRepository.findByEmployeeId("Test")).thenReturn(employee);
		assertEquals(employee, employeeServiceImpl.getEmployee("Test"));
	}

}
