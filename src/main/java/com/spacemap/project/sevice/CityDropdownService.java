package com.spacemap.project.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.CityDAO;
import com.spacemap.project.entity.CityEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.CityModel;

@Service
public class CityDropdownService {

	@Autowired
	CityDAO cityDAO;

	public List<CityModel> getCities() {
		List<CityModel> cityList = new ArrayList<CityModel>();
		List<CityEntity> cities = cityDAO.getCities();

		for (CityEntity city : cities) {
			CityModel cityModel = new CityModel();
			cityModel.setCityId(city.getCityId());
			cityModel.setCityName(city.getCityName());
			cityList.add(cityModel);
		}
		Logger logger = LoggerFactory.getLogger(CityDropdownService.class);
		logger.info("fetching cities");
		return cityList;

	}

}
