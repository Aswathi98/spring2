package com.spacemap.project.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.FacilityDAO;
import com.spacemap.project.entity.FacilityEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.CityModel;
import com.spacemap.project.model.FacilityModel;

@Service
public class FacilityDropdownService {
	@Autowired
	FacilityDAO facilityDAO;

	public List<FacilityModel> getFacilities(CityModel cityModel)  {

		List<FacilityModel> facilityModel = new ArrayList<FacilityModel>();
		List<FacilityEntity> facilities = facilityDAO.getFacilities(cityModel.getCityId());

		for (FacilityEntity facility : facilities) {
			FacilityModel model = new FacilityModel();
			model.setFacilityId(facility.getFacilityId());
			model.setFacilityName(facility.getFacitityName());
			facilityModel.add(model);

		}
		Logger logger = LoggerFactory.getLogger(FacilityDropdownService.class);
		logger.info("fetching facilities");
		return facilityModel;

	}

}