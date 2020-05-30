package com.spacemap.project.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.SpaceMapEntity;
import com.spacemap.project.repository.SpaceMapRepository;

@Component
public class SpaceMapDAO {

	@Autowired
	SpaceMapRepository spaceMapRepo;

	public SpaceMapEntity findBySpaceId(String spaceId) {
		Logger logger = LoggerFactory.getLogger(SpaceMapDAO.class);
		logger.info("Fetching Space Id");
		return spaceMapRepo.findBySpaceId(spaceId);
	}

	public String getFloorId(String empSpace) {
		Logger logger = LoggerFactory.getLogger(SpaceMapDAO.class);
		logger.info("Fetching Floor Id");
		return spaceMapRepo.findBySpaceId(empSpace).getFloorId();
	}

	public Iterable<SpaceMapEntity> getSpaceMap(String floorId) {
		Logger logger = LoggerFactory.getLogger(SpaceMapDAO.class);
		logger.info("Getting SpaceMap");
		return spaceMapRepo.getSpaceMap(floorId);
	}
}
