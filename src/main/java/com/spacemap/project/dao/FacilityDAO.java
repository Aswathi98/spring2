package com.spacemap.project.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.FacilityEntity;
import com.spacemap.project.repository.FacilityRepository;

@Component
public class FacilityDAO {

	@Autowired
	FacilityRepository facilityRepo;

	public List<FacilityEntity> getFacilities(String cityId) {
		Logger logger = LoggerFactory.getLogger(FacilityDAO.class);
		logger.info("Fetching Facilities");
		return (List<FacilityEntity>)facilityRepo.findAllByCityId(cityId);
	}

}
