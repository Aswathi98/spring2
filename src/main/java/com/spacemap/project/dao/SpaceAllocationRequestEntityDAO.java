package com.spacemap.project.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.repository.SpaceAllocationRequestRepository;

@Component
public class SpaceAllocationRequestEntityDAO {

	@Autowired
	SpaceAllocationRequestRepository spaceAllocationRequestRepository;

	@Transactional
	public SpaceAllocationRequestEntity saveRequest(SpaceAllocationRequestEntity spaceAllocationRequestEntity) {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Saving Data");
		return spaceAllocationRequestRepository.save(spaceAllocationRequestEntity);
	}

	public List<SpaceAllocationRequestEntity> getRequest() {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Getting Request");		
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestRepository.findAll();
	}

	public SpaceAllocationRequestEntity fetchrequest(int requestId) {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Fetching Request");
		SpaceAllocationRequestEntity sentity = spaceAllocationRequestRepository.findById(requestId).get();
		return sentity;
	}

	public List<SpaceAllocationRequestEntity> getPendingRequest() {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Fetching Pending Request");
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestRepository.findByStatus("Pending");
	}

	public List<SpaceAllocationRequestEntity> getApprovedRequest() {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Fetching Approved Request");
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestRepository.findByStatus("approved");
	}

	public List<SpaceAllocationRequestEntity> getDeclinedRequest() {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestEntityDAO.class);
		logger.info("Fetching Declined Request");
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestRepository.findByStatus("declined");
	}

}
