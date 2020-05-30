package com.spacemap.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.SpaceMapEntity;

@Repository
public interface SpaceMapRepository extends JpaRepository<SpaceMapEntity, Integer> {

	@Query(value = "select t from SpaceMapEntity t where t.spaceId=:spaceId")
	public SpaceMapEntity findBySpaceId(@Param("spaceId") String spaceId);

	@Query("SELECT t FROM SpaceMapEntity t WHERE t.floorId=:floorId ORDER BY spaceRow ASC,spaceColumn ASC")
	Iterable<SpaceMapEntity> getSpaceMap(@Param("floorId") String floorId);
}
