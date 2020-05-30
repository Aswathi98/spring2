package com.spacemap.project.sevice;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spacemap.project.dao.FloorsDAO;
import com.spacemap.project.entity.FloorsEntity;
import com.spacemap.project.model.FacilityModel;

@RunWith(MockitoJUnitRunner.class)
public class FloorDropdownServiceTest {
	private static final Logger log = LoggerFactory.getLogger(CityDropdownServiceTest.class);

	@Mock
	private FloorsDAO floorsDAO;

	@InjectMocks
	private FloorDropdownService floorDropdownService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void returnFloorsTest() {
		FacilityModel facilityModel = new FacilityModel();
		floorDropdownService.getFloor(facilityModel);
	}

	@Test
	public void returnFloorsTesting() {
		FacilityModel facilityModel = new FacilityModel();
		List<FloorsEntity> floorlist = new ArrayList<FloorsEntity>();
		FloorsEntity floorsEntity = new FloorsEntity();
		floorlist.add(floorsEntity);
		doReturn(floorlist).when(floorsDAO).getFloors(facilityModel.getFacilityId());
		floorDropdownService.getFloor(facilityModel);
	}

}
