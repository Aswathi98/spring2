package com.spacemap.project.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.RolesEntity;
import com.spacemap.project.model.LoginModel;
import com.spacemap.project.repository.RolesRepository;

@Component
public class RolesDAO {
	@Autowired
	RolesRepository rolesRepository;

	public Optional<RolesEntity> getRoleName(LoginModel log) {
		Logger logger = LoggerFactory.getLogger(RolesDAO.class);
		logger.info("Fetching Role Name");
		return rolesRepository.findByRoleId(log.getRoleId());
	}
}
