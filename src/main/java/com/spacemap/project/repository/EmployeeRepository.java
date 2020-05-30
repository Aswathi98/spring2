package com.spacemap.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

	@Query(value = "select t from EmployeeEntity t where t.empId=:empId")
	public Optional<EmployeeEntity> findByEmpId(@Param("empId") String empId);

	@Query("SELECT u FROM EmployeeEntity u where u.fName =:empName")
	Optional<EmployeeEntity> findByName(@Param("empName") String empName);

	Optional<List<EmployeeEntity>> findByfNameIgnoreCaseContaining(String empName);

}
