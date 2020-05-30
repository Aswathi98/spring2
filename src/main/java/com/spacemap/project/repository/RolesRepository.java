package com.spacemap.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spacemap.project.entity.RolesEntity;

public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {

	@Query(value = "select t from RolesEntity t where t.roleId=:roleId")
	public Optional<RolesEntity> findByRoleId(@Param("roleId") String roleId);
}
