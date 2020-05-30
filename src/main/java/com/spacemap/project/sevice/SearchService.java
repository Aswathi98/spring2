package com.spacemap.project.sevice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.EmployeeDetailsModel;

@Service
public class SearchService {

	@Autowired
	private EmployeeEntityDAO employeeEntityDAO;

	@Autowired
	private EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Autowired
	private TeamsEntityDAO teamsEntityDAO;

	public EmployeeDetailsModel findByName(String empName) throws RecordNotFoundException {
		try {
			Logger logger = LoggerFactory.getLogger(SearchService.class);
			EmployeeDetailsModel empModel = new EmployeeDetailsModel();

			EmployeeEntity optionalEmp = employeeEntityDAO.findByName(empName).get();
			if (optionalEmp != null) {
				empModel.setEmpId(optionalEmp.getEmpId());
				empModel.setfName(optionalEmp.getfName());
				empModel.setlName(optionalEmp.getlName());
				String teamId = optionalEmp.getTeamId();
				TeamsEntity teams = teamsEntityDAO.getTeamDetails(teamId).get();
				empModel.setClientName(teams.getClientName());
				empModel.setTeamName(teams.getTeamName());

				String spaceid = employeeSpaceEntityDAO.findbyempid(optionalEmp.getEmpId());
				empModel.setSpaceId(spaceid);
				logger.info("returning search results");
				return empModel;
			} else {
				logger.info("threw exception");
				throw new RecordNotFoundException("No employee present");
			}
			//return empModel;
		} catch (NoSuchElementException exception) {
			throw new RecordNotFoundException("No employee present");
		}

	}

	public List<EmployeeDetailsModel> findByNameStart(String empName) {
		Logger logger = LoggerFactory.getLogger(SearchService.class);
		logger.info("searching names");
		Optional<List<EmployeeEntity>> o = employeeEntityDAO.findByNameStart(empName);
		if (o.isPresent()) {
			List<EmployeeEntity> optionalEmp = o.get();
			List<EmployeeDetailsModel> out = new ArrayList<EmployeeDetailsModel>();

			for (EmployeeEntity entity : optionalEmp) {
				EmployeeDetailsModel empModel = new EmployeeDetailsModel();

				String spaceid = employeeSpaceEntityDAO.findbyempid(entity.getEmpId());
				String teamId = entity.getTeamId();
				TeamsEntity teams = teamsEntityDAO.getTeamDetails(teamId).get();

				empModel.setEmpId(entity.getEmpId());
				empModel.setfName(entity.getfName());
				empModel.setlName(entity.getlName());
				empModel.setClientName(teams.getClientName());
				empModel.setTeamName(teams.getTeamName());

				empModel.setSpaceId(spaceid);

				out.add(empModel);
			}
			logger.info("returning employee names");
			return out;
		}
		return new ArrayList<EmployeeDetailsModel>();
	}

}
