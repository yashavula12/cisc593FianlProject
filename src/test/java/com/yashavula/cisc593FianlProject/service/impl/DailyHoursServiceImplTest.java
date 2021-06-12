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

import com.yashavula.cisc593FianlProject.domain.DailyHours;
import com.yashavula.cisc593FianlProject.repositories.DailyHoursRepository;

@RunWith(MockitoJUnitRunner.class)
public class DailyHoursServiceImplTest {
	
	@InjectMocks
	private DailyHoursServiceImpl dailyHoursServiceImpl;

	@Mock
	private DailyHoursRepository dailyHoursRepository;
	
	private DailyHours dailyHours = new DailyHours();
	
	@Before
	public void doSetup() {
		
		dailyHours.setId(3);

	}
	
	@Test
	public void testSaveDailyHours() {
		when(dailyHoursRepository.save(dailyHours)).thenReturn(dailyHours);
		assertEquals(dailyHours, dailyHoursServiceImpl.saveDailyHours(dailyHours));
	}
	
	@Test
	public void testFindByDateOfSubmission() {
		when(dailyHoursRepository.findByDateOfSubmission("06/12/2021")).thenReturn(Stream.of(dailyHours).collect(Collectors.toList()));
		assertEquals(1, dailyHoursServiceImpl.findByDateOfSubmission("06/12/2021").size());
	}

}
