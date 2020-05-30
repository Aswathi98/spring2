package com.spacemap.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.EmployeeSpaceEntity;

@Repository
public interface EmployeeSpaceRepository extends CrudRepository<EmployeeSpaceEntity, Integer> {

	@Query(value = "select t.empId from EmployeeSpaceEntity t where t.spaceId=:spaceId")
	public String findBySpaceId(@Param("spaceId") String spaceId);

	@Query(value = "select t from EmployeeSpaceEntity t where t.spaceId=:spaceId")
	public EmployeeSpaceEntity findEntityBySpaceId(@Param("spaceId") String spaceId);

	/*
	 * @Modifying
	 * 
	 * @Query(value =
	 * "update employee_space t SET t.emp_id =:empid where t.space_id =:spaceId"
	 * , nativeQuery = true) public Optional<EmployeeSpaceEntity>
	 * update(@Param("empid") String empId, @Param("spaceId") String spaceId);
	 */

	@Query(value = "select t.spaceId from EmployeeSpaceEntity t where t.empId=:empId")
	public String findbyempid(@Param("empId") String empId);

}