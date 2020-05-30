package com.spacemap.project.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.FloorsEntity;
import com.spacemap.project.repository.FloorsRepository;

@Component
public class FloorsDAO {
	@Autowired
	FloorsRepository floorsRepository;

	public Iterable<FloorsEntity> getFloors(String facilityId) {
		Logger logger = LoggerFactory.getLogger(FloorsDAO.class);
		logger.info("Fetching Floors");
		return floorsRepository.findByFacilityId(facilityId);
	}

	public Optional<FloorsEntity> getTeamID(String floorName) {
		Logger logger = LoggerFactory.getLogger(FloorsDAO.class);
		logger.info("Fetching Floor Name");
		return floorsRepository.findByFloorName(floorName);

	}

}
