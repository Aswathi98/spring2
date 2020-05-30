package com.spacemap.project.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.CityDAO;
import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorMapAllocationEntityDAO;
import com.spacemap.project.dao.SpaceAllocationRequestEntityDAO;
import com.spacemap.project.entity.EmployeeSpaceEntity;
import com.spacemap.project.entity.FloorMapAllocationEntity;
import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.SpaceAllocationRequestModel;
import com.spacemap.project.repository.FloorMapAllocationRepository;
import com.spacemap.project.repository.SpaceAllocationRequestRepository;

@Service
public class AdminApproveService {

	@Autowired
	FloorMapAllocationEntityDAO floorMapAllocationEntityDAO;

	@Autowired
	EmployeeEntityDAO employeeEntityDAO;

	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Autowired
	FloorMapAllocationRepository allocationRepository;

	@Autowired
	SpaceAllocationRequestEntityDAO spaceAllocationRequestEntityDAO;

	@Autowired
	SpaceAllocationRequestRepository spaceAllocationRequestRepository;

	public Boolean admin(SpaceAllocationRequestModel spaceAllocationRequestModel) {

		if (spaceAllocationRequestModel.getType().equals("Allocation")) {
			SpaceAllocationRequestEntity spaceAllocationRequestEntity = spaceAllocationRequestEntityDAO
					.fetchrequest(spaceAllocationRequestModel.getRequestId());
			Logger logger = LoggerFactory.getLogger(AdminApproveService.class);
			logger.info("fetching Allocation Request");
			spaceAllocationRequestEntity.setStatus("approved");
			logger.info("Changing Request Status");
			EmployeeSpaceEntity employeeSpaceEntity = employeeSpaceEntityDAO
					.findEntityBySpaceId(spaceAllocationRequestModel.getSpaceId());
			employeeSpaceEntity.setEmpId(spaceAllocationRequestModel.getEmpId());
			employeeSpaceEntity = employeeSpaceEntityDAO.saveEntity(employeeSpaceEntity);
			String teamId = employeeEntityDAO.getEmployeeDetails(spaceAllocationRequestModel.getEmpId()).get()
					.getTeamId();
			FloorMapAllocationEntity floorMapAllocationEntity = floorMapAllocationEntityDAO
					.getEntity(spaceAllocationRequestModel.getSpaceId());
			floorMapAllocationEntity.setteamId(teamId);
			floorMapAllocationEntity = floorMapAllocationEntityDAO.saveEntity(floorMapAllocationEntity);
			spaceAllocationRequestEntity = spaceAllocationRequestRepository.save(spaceAllocationRequestEntity);
			logger.info("database updated");
			if (spaceAllocationRequestEntity != null && employeeSpaceEntity != null && floorMapAllocationEntity != null) {
				return true;
			} else {
				return false;
			}
		}

		else {
			SpaceAllocationRequestEntity spaceAllocationRequestEntity = spaceAllocationRequestEntityDAO
					.fetchrequest(spaceAllocationRequestModel.getRequestId());
			Logger logger = LoggerFactory.getLogger(AdminApproveService.class);
			logger.info("fetching request");
			spaceAllocationRequestEntity.setStatus("approved");
			logger.info("Changing Request Status");
			EmployeeSpaceEntity employeeSpaceEntity = employeeSpaceEntityDAO
					.findEntityBySpaceId(spaceAllocationRequestModel.getSpaceId());
			employeeSpaceEntity.setEmpId(null);
			employeeSpaceEntity = employeeSpaceEntityDAO.saveEntity(employeeSpaceEntity);
			FloorMapAllocationEntity floorMapAllocationEntity = floorMapAllocationEntityDAO
					.getEntity(spaceAllocationRequestModel.getSpaceId());
			floorMapAllocationEntity.setteamId(null);
			floorMapAllocationEntity = floorMapAllocationEntityDAO.saveEntity(floorMapAllocationEntity);
			spaceAllocationRequestEntity = spaceAllocationRequestRepository.save(spaceAllocationRequestEntity);
			logger.info("database updated");
			if (spaceAllocationRequestEntity != null && employeeSpaceEntity != null && floorMapAllocationEntity != null) {
				return true;
			} else {
				return false;
			}
		}

	}

	public Boolean admin1(SpaceAllocationRequestModel smodespaceAllocationRequestModell) {
		SpaceAllocationRequestEntity spaceAllocationRequestEntity = spaceAllocationRequestEntityDAO
				.fetchrequest(smodespaceAllocationRequestModell.getRequestId());
		Logger logger = LoggerFactory.getLogger(AdminApproveService.class);
		logger.info("fetching request");
		spaceAllocationRequestEntity.setStatus("declined");
		logger.info("changing status");
		spaceAllocationRequestEntity = spaceAllocationRequestRepository.save(spaceAllocationRequestEntity);
		if (spaceAllocationRequestEntity != null) {
			return true;
		} else {
			return false;
		}
	}

}
