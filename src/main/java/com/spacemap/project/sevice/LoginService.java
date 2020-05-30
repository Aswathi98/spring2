package com.spacemap.project.sevice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeRolesDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.LoginDAO;
import com.spacemap.project.dao.RolesDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.entity.EmployeeRolesEntity;
import com.spacemap.project.entity.LoginEntity;
import com.spacemap.project.entity.RolesEntity;
import com.spacemap.project.exception.AccessDeniedException;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.LoginModel;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Autowired
	EmployeeEntityDAO employeeEntityDAO;

	@Autowired
	EmployeeRolesDAO employeeRolesDAO;

	@Autowired
	RolesDAO rolesDAO;

	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Autowired
	SpaceMapDAO spaceMapDAO;

	public LoginModel authenticate(LoginModel loginModel) throws AccessDeniedException  {
		//LoginModel loginmodel = new LoginModel();
		//loginmodel.setEmployeeId(loginModel.getEmployeeId());
		Logger logger = LoggerFactory.getLogger(LoginService.class);
		try{
		loginModel.setAccess(false);
		Optional<LoginEntity> user;
	      user = loginDAO.getUser(loginModel);
		if (user.isPresent()) {
			if (user.get().getPassword().equals(loginModel.getPassword())) {
				loginModel.setAccess(true);
				Optional<EmployeeEntity> empEntity = employeeEntityDAO.getEmployeeDetails(loginModel.getEmployeeId());
				loginModel.setfName(empEntity.get().getfName());
				Optional<EmployeeRolesEntity> empRolesEntity = employeeRolesDAO.getRoleId(loginModel);
				loginModel.setRoleId(empRolesEntity.get().getRoleId());
				Optional<RolesEntity> rolesEntity = rolesDAO.getRoleName(loginModel);
				loginModel.setRoleName(rolesEntity.get().getRoleName());
				loginModel.setFloorId(spaceMapDAO.getFloorId(employeeSpaceEntityDAO.findbyempid(loginModel
						.getEmployeeId())));
				loginModel.setPassword(null);
			}else{
				throw new AccessDeniedException("Invalid password");
			}
		}else{
			logger.info("throwing exception");
			throw new AccessDeniedException("Invalid User");
			//loginModel = null;
		}
		logger.info("returning login details");
		return loginModel;
	}catch(AccessDeniedException exception){
		throw new AccessDeniedException("Invalid User");
	}
	}
}