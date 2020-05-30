package com.spacemap.project.dao;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.EmployeeSpaceEntity;
import com.spacemap.project.model.DeAllocationRequestModel;
import com.spacemap.project.repository.EmployeeSpaceRepository;

@Component
public class EmployeeSpaceEntityDAO {
	@Autowired
	EmployeeSpaceRepository employeeSpaceRepository;

	/*
	 * public Optional<EmployeeSpaceEntity> getEmployeeId(String spaceid) {
	 * return employeeSpaceRepository.findBySpaceId(spaceid); }
	 */

	public String fetchEmpId(String spaceId) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("Fetching Employee Id");
		/* Optional<EmployeeSpaceEntity> eentity */
		String empId = employeeSpaceRepository.findBySpaceId(spaceId);
		/* String empId = eentity.get().getEmpId(); */
		System.out.println(empId);
		return empId;
	}

	/*
	 * public Boolean updateEmployee (ApproveModel approveModel){
	 * Optional<EmployeeSpaceEntity> employeeSpaceEntity
	 * =employeeSpaceRepository.update(approveModel.getEmpId(),
	 * approveModel.getSpaceId()); if(employeeSpaceEntity==null) return false;
	 * else return true; }
	 */

	public String findbyempid(String empId) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("fetching spaceid");
		return employeeSpaceRepository.findbyempid(empId);
	}

	public String getSpaceId(DeAllocationRequestModel deAllocationRequestModel) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("fetching spaceid");
		return employeeSpaceRepository.findbyempid(deAllocationRequestModel.getEmpId());
	}

	@Transactional
	public String getEmployeeId(String spaceId) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("Fetching Employee Id");
		// System.out.println(employeeSpaceRepository.findBySpaceId(spaceId).getEmpId());
		return employeeSpaceRepository.findBySpaceId(spaceId);
	}

	public EmployeeSpaceEntity findEntityBySpaceId(String spaceId) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("Fetching Space Id");
		EmployeeSpaceEntity employeespaceEntity = employeeSpaceRepository.findEntityBySpaceId(spaceId);
		return employeespaceEntity;
	}

	public EmployeeSpaceEntity saveEntity(EmployeeSpaceEntity employeeSpaceEntity) {
		Logger logger = LoggerFactory.getLogger(EmployeeSpaceEntityDAO.class);
		logger.info("Updating Database");
		return employeeSpaceRepository.save(employeeSpaceEntity);
	}
}