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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/dailyHours")
public class DailyHoursController {

	@Autowired
	private DailyHoursService dailyHoursService;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveHours")
	public ResponseEntity<Object> saveEmployee(@Valid @RequestBody DailyHours dailyHours, BindingResult result) {

		if (result.hasErrors()) {
			return ResponseEntity.badRequest().body(result.getAllErrors());
		} else {

			Employee emp = employeeService.getEmployee(dailyHours.getEmployeeId());

			if (emp != null) {
				try {

					int totalMinutes = (int) getDateDiff(dailyHours.getStartTime(), dailyHours.getEndTime(),
							TimeUnit.MINUTES);
					dailyHours.setTotalMinutes(totalMinutes);
					dailyHours.setPayableMinutes(totalMinutes - dailyHours.getBreakMinutes());

					return ResponseEntity.ok().body(dailyHoursService.saveDailyHours(dailyHours));
				} catch (Exception e) {
					return ResponseEntity.ok().body(e.getMessage());
				}
			} else {
				return ResponseEntity.ok().body("Invalid Employee Id");
			}

		}
	}

	@GetMapping("/getHoursBydateOdSunmission")
	public ResponseEntity<Object> getByDateOfSubmission() {

		String newstring = new SimpleDateFormat("mm/dd/yyyy").format(new Date());

		return ResponseEntity.ok().body(dailyHoursService.findByDateOfSubmission(newstring));

	}

	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		long diffInMillies = date2.getTime() - date1.getTime();
		return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
	}

}
