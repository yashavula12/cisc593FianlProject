//package com.yashavula.cisc593FianlProject.controller;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.validation.BindingResult;
//
//import com.yashavula.cisc593FianlProject.domain.DailyHours;
//import com.yashavula.cisc593FianlProject.domain.Employee;
//import com.yashavula.cisc593FianlProject.service.DailyHoursService;
//import com.yashavula.cisc593FianlProject.service.EmployeeService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc(addFilters = false)
//@TestPropertySource(locations = "classpath:application.properties")
//public class DailyHoursControllerTest {
//	
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private EmployeeService employeeService;
//	
//	@MockBean
//	private DailyHoursService dailyHoursService;
//
//
//	@MockBean
//	private BindingResult bindingResult;
//	
//	
//	private DailyHours dailyHours;
//	private Employee employee;
//	
//	private List<DailyHours> dailyHoursList;
//	
//	
//	@Before
//	public void doSetup() {
//		
//		employee = new Employee();
//
//		employee.setEmail("yashAvyla1@gmail.com");
//		employee.setEmployeeId("Yash125");
//		employee.setFirstName("Yaswanth");
//		employee.setLastName("Avula");
//		employee.setRole("Manager");
//
//		dailyHours = new DailyHours();
//		dailyHoursList = new ArrayList<DailyHours>();
//
//		given(this.dailyHoursService.saveDailyHours(dailyHours)).willReturn(dailyHours);
//		
//		given(this.employeeService.getEmployee("Yash1")).willReturn(employee);
//
//	}
//	
//	@Test
//	public void testSaveDailyHours() throws Exception {
//		
//		when(bindingResult.hasErrors()).thenReturn(false);
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/dailyHours/saveHours").content("{\r\n" + 
//				"    \"dateOfSubmission\": \"06/12/2021\",\r\n" + 
//				"    \"startTime\": \"06/12/2021 10:20 AM\",\r\n" + 
//				"    \"endTime\": \"06/12/2021 05:20 PM\",\r\n" + 
//				"    \"breakMinutes\": 100,\r\n" + 
//				"    \"employeeId\": \"Yash1\"\r\n" + 
//				"}")
//				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
//
//	}
//
//}
