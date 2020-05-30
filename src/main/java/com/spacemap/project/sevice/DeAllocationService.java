package com.spacemap.project.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorAdminDAO;
import com.spacemap.project.dao.SpaceAllocationRequestEntityDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.DeAllocationRequestModel;

@Service
public class DeAllocationService {

	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceDao;

	@Autowired
	SpaceMapDAO spaceMapDao;

	@Autowired
	FloorAdminDAO floorAdminEntityDao;

	@Autowired
	SpaceAllocationRequestEntityDAO spaceAllocationRequestEntityDAO;
	
	@Autowired
	EmployeeEntityDAO employeeeEntityDAO;
	
	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	public Boolean putRequest(DeAllocationRequestModel deAllocationRequestModel) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Logger logger = LoggerFactory.getLogger(DeAllocationService.class);
		String manager = employeeeEntityDAO.getEmployeeDetails(deAllocationRequestModel.getEmpId()).get().getManagerId();
		String spaceId = employeeSpaceEntityDAO.findbyempid(deAllocationRequestModel.getEmpId());
		if(manager.equals(deAllocationRequestModel.getRecommender())){
		if(spaceId != null){
		String empSpace = employeeSpaceDao.getSpaceId(deAllocationRequestModel);

		spaceMapDao.getFloorId(empSpace);

		String floorId = spaceMapDao.getFloorId(empSpace);

		floorAdminEntityDao.getAdminId(floorId);

		String adminId = floorAdminEntityDao.getAdminId(floorId);

		SpaceAllocationRequestEntity spaceAllocationRequestEntity = new SpaceAllocationRequestEntity();

		spaceAllocationRequestEntity.setEmpId(deAllocationRequestModel.getEmpId());
		spaceAllocationRequestEntity.setSpaceId(deAllocationRequestModel.getSpaceId());
		spaceAllocationRequestEntity.setApprover(adminId);
		spaceAllocationRequestEntity.setStatus("Pending");
		spaceAllocationRequestEntity.setType("DeAllocation");
		spaceAllocationRequestEntity.setReccomender(deAllocationRequestModel.getRecommender());
		spaceAllocationRequestEntity.setIp(deAllocationRequestModel.getEmpName());

		SpaceAllocationRequestEntity spaceAllocationRequestEntityResponse = spaceAllocationRequestEntityDAO
				.saveRequest(spaceAllocationRequestEntity);
		logger.info("saving request");
		if (spaceAllocationRequestEntityResponse != null) {
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

}
