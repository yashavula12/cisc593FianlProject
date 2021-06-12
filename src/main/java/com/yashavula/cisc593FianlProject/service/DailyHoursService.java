package com.yashavula.cisc593FianlProject.service;

import com.yashavula.cisc593FianlProject.domain.DailyHours;

import java.util.Date;
import java.util.List;

public interface DailyHoursService {

    public List<DailyHours> findByDateOfSubmission(String dateOfSubmission);

    public DailyHours saveDailyHours(DailyHours dailyHours);

    public List<DailyHours> findEmployeeHoursByWeek(String employeeId);
}
