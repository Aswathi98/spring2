package com.spacemap.project.sevice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.TeamsEntityDAO;
import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.entity.TeamsEntity;
import com.spacemap.project.model.SpaceModel;

@Service
public class GetEmployeeDataService {

	@Autowired
	EmployeeEntityDAO employeeEntityDAO;

	@Autowired
	TeamsEntityDAO teamsEntityDAO;

	public SpaceModel fetchdetails(String empId) {
		Optional<EmployeeEntity> empEntity = employeeEntityDAO.getEmployeeDetails(empId);
		Optional<TeamsEntity> teamEntity = teamsEntityDAO.getTeamDetails(empEntity.get().getTeamId());

		SpaceModel spaceModel = new SpaceModel();
		spaceModel.setEmpId(empId);
		spaceModel.setfName(empEntity.get().getfName());
		spaceModel.setlName(empEntity.get().getlName());
		spaceModel.setTeamName(teamEntity.get().getTeamName());
		spaceModel.setClientName(teamEntity.get().getClientName());
		Logger logger = LoggerFactory.getLogger(GetEmployeeDataService.class);
		logger.info("returning employee data");
		return spaceModel;
	}

}
