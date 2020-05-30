package com.spacemap.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.EmployeeRolesEntity;

@Repository
public interface EmployeeRolesRepository extends CrudRepository<EmployeeRolesEntity, Integer> {

	@Query(value = "select t from EmployeeRolesEntity t where t.empId=:empId")
	public Optional<EmployeeRolesEntity> findByEmpId(@Param("empId") String empId);
}
