package com.spacemap.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.FloorsEntity;

@Repository
public interface FloorsRepository extends CrudRepository<FloorsEntity, Integer> {

	@Query("select t from FloorsEntity t where facilityId=:facilityId")
	Iterable<FloorsEntity> findByFacilityId(@Param("facilityId") String facilityId);

	@Query(value = "select t.floor_id from floors t where floor_name=:floorName", nativeQuery = true)
	public Optional<FloorsEntity> findByFloorName(@Param("floorName") String floorName);

}
