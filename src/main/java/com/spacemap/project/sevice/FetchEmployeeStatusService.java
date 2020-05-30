package com.spacemap.project.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.model.SpaceModel;

@Service
public class FetchEmployeeStatusService {

	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Autowired
	GetEmployeeDataService getEmpDataservice;

	public SpaceModel fetchEmployeeStatus(String spaceId) {

		String empId = employeeSpaceEntityDAO.fetchEmpId(spaceId);
		if (empId == null) {
			SpaceModel spaceModel = new SpaceModel();
			spaceModel.setEmpId(null);
			spaceModel.setfName(null);
			spaceModel.setlName(null);
			spaceModel.setTeamName(null);
			spaceModel.setClientName(null);
			spaceModel.setSpaceId(spaceId);
			return spaceModel;

		} else {

			SpaceModel spaceModel = getEmpDataservice.fetchdetails(empId);
			spaceModel.setSpaceId(spaceId);
			return spaceModel;
		}
	}
}
