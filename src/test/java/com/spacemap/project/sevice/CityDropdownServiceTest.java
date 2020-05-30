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

import com.spacemap.project.dao.CityDAO;
import com.spacemap.project.entity.CityEntity;

@RunWith(MockitoJUnitRunner.class)
public class CityDropdownServiceTest {

	private static final Logger log = LoggerFactory.getLogger(CityDropdownServiceTest.class);

	@Mock
	private CityDAO cityDAO;

	@InjectMocks
	private CityDropdownService cityDropdownService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getCitiesTest() {
		List<CityEntity> list = new ArrayList<CityEntity>();
		doReturn(list).when(cityDAO).getCities();
		cityDropdownService.getCities();
		log.info("CityDropdownServiceTest::getCitiesTest");

	}

	@Test
	public void getCitiesTest_with_cityEntity() {
		List<CityEntity> list = new ArrayList<CityEntity>();
		CityEntity cityEntity = new CityEntity();
		list.add(cityEntity);
		doReturn(list).when(cityDAO).getCities();
		cityDropdownService.getCities();
		log.info("CityDropdownServiceTest::getCitiesTest_with_cityEntity");

	}
	
}
