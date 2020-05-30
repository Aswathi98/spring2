package com.spacemap.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.FloorAdminEntity;
import com.spacemap.project.repository.FloorAdminRepository;

@Component
public class FloorAdminDAO {

	@Autowired
	FloorAdminRepository floorAdminRepo;

	public FloorAdminEntity findByFloorId(String floorId) {
		Logger logger = LoggerFactory.getLogger(FacilityDAO.class);
		logger.info("Fetching Floor Id");
		return floorAdminRepo.findByFloorId(floorId);
	}

	public String getAdminId(String floorId) {
		Logger logger = LoggerFactory.getLogger(FacilityDAO.class);
		logger.info("Fetching Admin Id");
		
		return floorAdminRepo.findByFloorId(floorId).getEmpId();
	}
}
