package com.spacemap.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.FloorMapAllocationEntity;

@Repository
public interface FloorMapAllocationRepository extends CrudRepository<FloorMapAllocationEntity, String> {

	@Query("select t from FloorMapAllocationEntity t where spaceId=:spaceId")
	public Optional<FloorMapAllocationEntity> getTeamId(@Param("spaceId") String spaceId);

	@Query("select t from FloorMapAllocationEntity t where spaceId=:spaceId")
	public FloorMapAllocationEntity getEntity(@Param("spaceId") String spaceId);
	/*
	 * @Modifying
	 * 
	 * @Query(value=
	 * "update FLOORMAP_ALLOCATION SET  TEAM_ID=: teamid	 where SPACE_ID =:spaceid"
	 * , nativeQuery = true) public FloorMapAllocationEntity
	 * update(@Param("teamid") String teamId, @Param("spaceid")String spaceId);
	 */
	//
}
