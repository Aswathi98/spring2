package com.spacemap.project.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.FloorMapAllocationEntity;
import com.spacemap.project.repository.FloorMapAllocationRepository;

@Component
public class FloorMapAllocationEntityDAO {

	@Autowired
	FloorMapAllocationRepository floorMapAllocationRepository;

	public Optional<FloorMapAllocationEntity> getTeamId(String spaceId) {
		Logger logger = LoggerFactory.getLogger(FloorMapAllocationEntityDAO.class);
		logger.info("Fetching Team Id");
		return floorMapAllocationRepository.getTeamId(spaceId);

	}

	/*
	 * @Autowired FloorMapAllocationRepository floorMapAllocationRepository;
	 * 
	 * @Transactional public Optional<FloorMapAllocationEntity>
	 * floordetails(ApproveModel approveModel ) { return
	 * floorMapAllocationRepository.findById(approveModel.getEmpId()); } public
	 * Optional<FloorMapAllocationEntity> floordetail(ApproveModel approveModel
	 * ) { Optional<FloorMapAllocationEntity> empId = null; try { empId =
	 * floorMapAllocationRepository.findById(approveModel.getEmpId()); } catch
	 * (Exception e) { e.printStackTrace(); } return empId; }
	 */

	public FloorMapAllocationEntity getEntity(String spaceId) {
		Logger logger = LoggerFactory.getLogger(FloorMapAllocationEntityDAO.class);
		logger.info("fetching floormap allocation details");
		return floorMapAllocationRepository.getEntity(spaceId);
	}

	public FloorMapAllocationEntity saveEntity(FloorMapAllocationEntity floorMapAllocationEntity) {
		Logger logger = LoggerFactory.getLogger(FloorMapAllocationEntityDAO.class);
		logger.info("Saving data");
		return floorMapAllocationRepository.save(floorMapAllocationEntity);
	}

}
