package com.spacemap.project.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.repository.EmployeeRepository;

@Component
public class EmployeeEntityDAO {

	@Autowired
	EmployeeRepository employeeRepository;

	public Optional<EmployeeEntity> getEmployeeDetails(String empId) {
		Logger logger = LoggerFactory.getLogger(EmployeeEntityDAO.class);
		logger.info("Fetching Employee details");
		System.out.println(employeeRepository.findByEmpId(empId));
		return employeeRepository.findByEmpId(empId);
	}

	public Optional<EmployeeEntity> findByName(String empName) {
		Logger logger = LoggerFactory.getLogger(EmployeeEntityDAO.class);
		logger.info("Fetching Employee details");
		return employeeRepository.findByName(empName);
	}

	public Optional<List<EmployeeEntity>> findByNameStart(String empName) {
		Logger logger = LoggerFactory.getLogger(EmployeeEntityDAO.class);
		logger.info("Fetching Employee Names");
		return employeeRepository.findByfNameIgnoreCaseContaining(empName);
	}
}
