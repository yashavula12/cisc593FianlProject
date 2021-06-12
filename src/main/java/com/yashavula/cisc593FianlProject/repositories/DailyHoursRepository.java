package com.yashavula.cisc593FianlProject.repositories;

import com.yashavula.cisc593FianlProject.domain.DailyHours;
import com.yashavula.cisc593FianlProject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("dailyHoursRepository")
public interface DailyHoursRepository extends JpaRepository<DailyHours, Long> {

    @Query(value = "SELECT * FROM TBL_DAILY_HOURS  where trunc(DATE_OF_SUBMISSION)  = to_date(:dateOfSubmission,'mm/dd/yyyy')  ", nativeQuery = true)
    public List<DailyHours> findByDateOfSubmission(@Param("dateOfSubmission") String dateOfSubmission);
    


}
