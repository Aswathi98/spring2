package com.spacemap.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.LoginEntity;

@Repository
public interface LoginRepository extends CrudRepository<LoginEntity, Integer> {

	@Query(value = "select t from LoginEntity t where t.employeeId=:employeeId")
	public Optional<LoginEntity> findByEmpId(@Param("employeeId") String employeeId);

}
