package com.spacemap.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.TeamsEntity;

@Repository
public interface TeamsRepository extends CrudRepository<TeamsEntity, Integer> {

	@Query(value = "select t from TeamsEntity t where t.teamId=:teamId")
	public Optional<TeamsEntity> findByTeamId(@Param("teamId") String teamId);

	@Query(value = "select distinct t.team_name from teams t", nativeQuery = true)
	public List<String> getAllTeamNames();

}
