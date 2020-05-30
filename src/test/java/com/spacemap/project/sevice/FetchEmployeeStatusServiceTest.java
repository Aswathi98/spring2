package com.spacemap.project.sevice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.model.SpaceModel;

@RunWith(MockitoJUnitRunner.class)
public class FetchEmployeeStatusServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(FetchEmployeeStatusServiceTest.class);

	@Mock
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Mock
	GetEmployeeDataService getEmpDataService;
	
	@InjectMocks
	FetchEmployeeStatusService fetchEmployeeStatusService;
	
	@Before
	public void setUp()  {	
		 MockitoAnnotations.initMocks(this);
		 
	}
	
	@Test
	public void WhenSpaceId_ReturnEmployeeStatus_empId_null() {
		doReturn(null).when(employeeSpaceEntityDAO).fetchEmpId(any(String.class));
		fetchEmployeeStatusService.fetchEmployeeStatus(anyString());	
		log.info("FetchEmployeeStatusServiceTest::WhenSpaceId_ReturnEmployeeStatus_empId_null");
	

	}
	@Test
	public void WhenSpaceId_ReturnEmployeeStatus_spaceId_empId() {
		SpaceModel spaceModel=new SpaceModel();
		doReturn(" ").when(employeeSpaceEntityDAO).fetchEmpId(any(String.class));
		doReturn(spaceModel).when(getEmpDataService).fetchdetails(anyString());
		fetchEmployeeStatusService.fetchEmployeeStatus(anyString());	
		log.info("FetchEmployeeStatusServiceTest::WhenSpaceId_ReturnEmployeeStatus_spaceId_empId");
	

	}
	

}
