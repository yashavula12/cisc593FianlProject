package com.yashavula.cisc593FianlProject.service.impl;

import com.yashavula.cisc593FianlProject.domain.DailyHours;
import com.yashavula.cisc593FianlProject.repositories.DailyHoursRepository;
import com.yashavula.cisc593FianlProject.service.DailyHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DailyHoursServiceImpl  implements DailyHoursService {

    @Autowired
    private DailyHoursRepository dailyHoursRepository;

    @Override
    public List<DailyHours> findByDateOfSubmission(String dateOfSubmission) {
        return dailyHoursRepository.findByDateOfSubmission(dateOfSubmission);
    }

    @Override
    public DailyHours saveDailyHours(DailyHours dailyHours) {
      return  dailyHoursRepository.save(dailyHours);
    }

    @Override
    public List<DailyHours> findEmployeeHoursByWeek(String employeeId) {
        return null;
    }
}
