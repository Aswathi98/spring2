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

import com.spacemap.project.dao.FacilityDAO;
import com.spacemap.project.entity.FacilityEntity;
import com.spacemap.project.model.CityModel;


@RunWith(MockitoJUnitRunner.class)
public class FacilityDropdownServiceTest {

	private static final Logger log = LoggerFactory.getLogger(CityDropdownServiceTest.class);

	@Mock
	private FacilityDAO facilityDAO;

	@InjectMocks
	private FacilityDropdownService facilityDropdownService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void returnFacilitiesTest() {
		CityModel cityModel = new CityModel();
		facilityDropdownService.getFacilities(cityModel);
		log.info("FacilityDropdownServiceTest::returnFacilitiesTest");
	}

	@Test
	public void returnFacilities_when_cityId_Test() {
		CityModel cityModel = new CityModel();
		List<FacilityEntity> facilityEntityList = new ArrayList<FacilityEntity>();
		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntityList.add(facilityEntity);
		doReturn(facilityEntityList).when(facilityDAO).getFacilities(cityModel.getCityId());
		facilityDropdownService.getFacilities(cityModel);
		log.info("FacilityDropdownServiceTest::returnFacilities_when_cityId_Test");

	}

}
