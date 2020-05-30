package com.spacemap.project.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.LoginEntity;
import com.spacemap.project.exception.AccessDeniedException;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.LoginModel;
import com.spacemap.project.repository.LoginRepository;

@Component
public class LoginDAO {

	@Autowired
	LoginRepository loginRepository;

	/*
	 * @Autowired EmployeeRepository employeeRepository;
	 */
	/*
	 * @Autowired EmployeeRolesRepository employeeRolesRepository;
	 */

	/*
	 * @Autowired RolesRepository rolesRepository;
	 */

	public Optional<LoginEntity> getUser(LoginModel log) throws AccessDeniedException {
		Logger logger = LoggerFactory.getLogger(LoginDAO.class);
		logger.info("Fetching User");
		//try{
		//	loginRepository.findByEmpId(log.getEmployeeId());
			return loginRepository.findByEmpId(log.getEmployeeId());
		//}catch(Exception e){
		//	throw new RecordNotFoundException("no such user");
		//}
		
	}

	/*
	 * public Optional<EmployeeEntity>getEmployeeName(LoginModel log){ return
	 * employeeRepository.findByEmpId(log.getEmployeeId()); }
	 */

	/*
	 * public Optional<EmployeeRolesEntity>getRoleId(LoginModel log){ return
	 * employeeRolesRepository.findByEmpId(log.getEmployeeId()); }
	 */

	/*
	 * public Optional<RolesEntity>getRoleName(LoginModel log){ return
	 * rolesRepository.findByRoleId(log.getRoleId()); }
	 */

}
