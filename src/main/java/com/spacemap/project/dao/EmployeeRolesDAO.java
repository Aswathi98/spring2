package com.spacemap.project.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.EmployeeRolesEntity;
import com.spacemap.project.model.LoginModel;
import com.spacemap.project.repository.EmployeeRolesRepository;

@Component
public class EmployeeRolesDAO {

	@Autowired
	EmployeeRolesRepository employeeRolesRepository;

	public Optional<EmployeeRolesEntity> getRoleId(LoginModel log) {
		Logger logger = LoggerFactory.getLogger(EmployeeRolesDAO.class);
		logger.info("Fetching RoleID");
		return employeeRolesRepository.findByEmpId(log.getEmployeeId());
	}

}
