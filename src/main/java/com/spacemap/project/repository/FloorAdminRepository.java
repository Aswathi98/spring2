package com.spacemap.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.FloorAdminEntity;

@Repository
public interface FloorAdminRepository extends CrudRepository<FloorAdminEntity, Integer> {

	@Query(value = "select t from FloorAdminEntity t where t.floorId=:floorId")
	public FloorAdminEntity findByFloorId(@Param("floorId") String floorId);
}
