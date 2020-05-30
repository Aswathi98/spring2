package com.spacemap.project.sevice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
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
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.dao.TeamsEntityDAO;
import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.entity.SpaceMapEntity;
import com.spacemap.project.entity.TeamsEntity;
import com.spacemap.project.model.FloorMapDetailsModel;


@RunWith(MockitoJUnitRunner.class)
public class FloorMapOccupationDetailsServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(FloorMapOccupationDetailsServiceTest.class);

	@Mock
	private SpaceMapDAO spaceMapDAO;

	@Mock
	private EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Mock
	private EmployeeEntityDAO employeeEntityDAO;

	@Mock
	private TeamsEntityDAO teamsEntityDAO;

	@InjectMocks
	private FloorMapOccupationDetailsService floorMapOccupationDetailsService;

	@Before
	public void setUp()  {	
		 MockitoAnnotations.initMocks(this);
		 
	}
	@Test
	public void spaceMapLayoutReturnTest(){
		SpaceMapEntity spaceMapEntity = new SpaceMapEntity();
		List<SpaceMapEntity> list = new ArrayList<>();
		list.add(spaceMapEntity);
		doReturn(list).when(spaceMapDAO).getSpaceMap(any(String.class));
		floorMapOccupationDetailsService.getMapDetails(anyString());
		log.info("FloorMapOccupationDetailsServiceTest::spaceMapLayoutReturnTest()");
	}
	@Test
	public void spaceMapLayoutReturn_With_spaceId_Test(){
		SpaceMapEntity spaceMapEntity = new SpaceMapEntity();
		spaceMapEntity.setSpaceId("A01");
		List<SpaceMapEntity> list = new ArrayList<>();
		list.add(spaceMapEntity);
		doReturn(list).when(spaceMapDAO).getSpaceMap(any(String.class));
		floorMapOccupationDetailsService.getMapDetails(anyString());
		log.info("FloorMapOccupationDetailsServiceTest::spaceMapLayoutReturn_With_spaceId_Test");
	}
	
	@Test
	public void spaceMapLayoutReturn_With_spaceId_empId_Test(){
		FloorMapDetailsModel floorMapDetailsModel=new FloorMapDetailsModel();
		SpaceMapEntity spaceMapEntity = new SpaceMapEntity();
		spaceMapEntity.setSpaceId("A01");
		List<SpaceMapEntity> list = new ArrayList<SpaceMapEntity>();
		list.add(spaceMapEntity);
		floorMapDetailsModel.setEmpId("A9356");
		//doReturn(list).when(spaceMapDAO).getSpaceMap(any(String.class));
		//Mockito.doReturn("A").when(employeeSpaceEntityDAO).getEmployeeId("A01");
		floorMapOccupationDetailsService.getMapDetails(any(String.class));	
		log.info("FloorMapOccupationDetailsServiceTest::spaceMapLayoutReturn_With_spaceId_empId_Test");
	}
	
	@Test
	public void spaceMapLayoutReturn_With_spaceId_empId_teamId_Test(){
		String empId=new String();
		TeamsEntity teamsEntity = new TeamsEntity();
		EmployeeEntity employeeEntity=new EmployeeEntity();
		SpaceMapEntity spaceMapEntity = new SpaceMapEntity();
		spaceMapEntity.setSpaceId("A01");
		List<SpaceMapEntity> list = new ArrayList<>();
		list.add(spaceMapEntity);
		doReturn(list).when(spaceMapDAO).getSpaceMap(any(String.class));
		doReturn(empId).when(employeeSpaceEntityDAO).getEmployeeId(spaceMapEntity.getSpaceId());
		
		doReturn(Optional.of(employeeEntity)).when(employeeEntityDAO).getEmployeeDetails(any(String.class));
		
		doReturn(Optional.of(teamsEntity)).when(teamsEntityDAO).getTeamDetails(employeeEntity.getTeamId());
        //String code=Optional.of(teamsEntity).get().getTeamId();
		floorMapOccupationDetailsService.getMapDetails(anyString());	
		log.info("FloorMapOccupationDetailsServiceTest::spaceMapLayoutReturn_With_spaceId_empId_teamId_Test");
	}
	
	
}