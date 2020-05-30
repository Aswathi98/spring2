package com.spacemap.project.sevice;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.TeamsEntityDAO;
import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.entity.TeamsEntity;

@RunWith(MockitoJUnitRunner.class)
public class GetEmployeeDataServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(FloorMapOccupationDetailsServiceTest.class);
	
	@InjectMocks
	GetEmployeeDataService getEmployeeDataService;

	@Mock
	EmployeeEntityDAO employeeEntityDAO;

	@Mock
	TeamsEntityDAO teamsEntityDAO;

	@Before
	public void setUp()  {	
		 MockitoAnnotations.initMocks(this);
	}
	@Test
	public void whenEmpId_ReturnEmployee() {
		EmployeeEntity employeeEntity=new EmployeeEntity();
		TeamsEntity teamsEntity=new TeamsEntity();
		doReturn(Optional.of(employeeEntity)).when(employeeEntityDAO).getEmployeeDetails(any(String.class));
		doReturn(Optional.of(teamsEntity)).when(teamsEntityDAO).getTeamDetails(employeeEntity.getTeamId());
		getEmployeeDataService.fetchdetails(anyString());
		log.info("GetEmployeeDataServiceTest::whenEmpId_ReturnEmployee");
	}
	
	@Test
	public void whenEmpId_ReturnEmployee_with_teamsEntity() {
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setTeamId("1001");
		TeamsEntity teamsEntity=new TeamsEntity();
		doReturn(Optional.of(employeeEntity)).when(employeeEntityDAO).getEmployeeDetails(any(String.class));
		doReturn(Optional.of(teamsEntity)).when(teamsEntityDAO).getTeamDetails(employeeEntity.getTeamId());
		getEmployeeDataService.fetchdetails(anyString());
		log.info("GetEmployeeDataServiceTest::whenEmpId_ReturnEmployee_with_teamsEntity");
	}

}
