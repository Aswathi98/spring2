package com.spacemap.project.sevice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorAdminDAO;
import com.spacemap.project.dao.SpaceAllocationRequestEntityDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.entity.FloorAdminEntity;
import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.entity.SpaceMapEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.SpaceAllocationRequestModel;

@Service
public class SpaceAllocationRequestService {

	@Autowired
	SpaceAllocationRequestEntityDAO spaceAllocationRequestEntityDAO;

	@Autowired
	SpaceMapDAO spaceMapDAO;

	@Autowired
	FloorAdminDAO floorAdminDAO;
	
	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;
	
	@Autowired
	EmployeeEntityDAO employeeeEntityDAO;

	public Boolean putRequest(SpaceAllocationRequestModel spaceAllocationRequestmodel) throws RecordNotFoundException {
		Logger logger = LoggerFactory.getLogger(SpaceAllocationRequestService.class);
		String manager = employeeeEntityDAO.getEmployeeDetails(spaceAllocationRequestmodel.getEmpId()).get().getManagerId();
		System.out.println(manager);
		System.out.println(spaceAllocationRequestmodel.getReccomender());
		String spaceId = employeeSpaceEntityDAO.findbyempid(spaceAllocationRequestmodel.getEmpId());
		if(manager.equals(spaceAllocationRequestmodel.getReccomender())){
		if(spaceId == null){
		SpaceAllocationRequestEntity spaceAllocationRequestEntity = spaceAllocationRequestmodel.addAllocationEntity();

		SpaceMapEntity spacemapentity = spaceMapDAO.findBySpaceId(spaceAllocationRequestmodel.getSpaceId());
		String floorId = spacemapentity.getFloorId();
		// System.out.println(floorId);

		FloorAdminEntity flooradminentity = floorAdminDAO.findByFloorId(floorId);
		spaceAllocationRequestEntity.setApprover(flooradminentity.getEmpId());

		SpaceAllocationRequestEntity status = spaceAllocationRequestEntityDAO.saveRequest(spaceAllocationRequestEntity);
		logger.info("saving request");
		if (status != null) {
			return true;
		} else {
			return false;
		}}else{
			throw new RecordNotFoundException("employee already exist");
		}
		}else{
			throw new RecordNotFoundException("manager does not have required privilage");
		}
	}

	public List<SpaceAllocationRequestEntity> getRequest() {
		return spaceAllocationRequestEntityDAO.getRequest();
	}

	public List<SpaceAllocationRequestEntity> getPendingRequest() throws RecordNotFoundException {
		/*List<SpaceAllocationRequestEntity> list = spaceAllocationRequestEntityDAO.getPendingRequest();
		Boolean status = list.isEmpty();
		System.out.println(status);
		try{
		if(status == false){
			return spaceAllocationRequestEntityDAO.getPendingRequest();
		}else{
			throw new RecordNotFoundException("No pending requests");
		}
		}catch(RecordNotFoundException exception){
			throw new RecordNotFoundException("No pending requests");
		}*/
		return spaceAllocationRequestEntityDAO.getPendingRequest();
	}

	public List<SpaceAllocationRequestEntity> getApprovedRequest() {
		return spaceAllocationRequestEntityDAO.getApprovedRequest();
	}

	public List<SpaceAllocationRequestEntity> getDeclinedRequest() {
		return spaceAllocationRequestEntityDAO.getDeclinedRequest();
	}
}