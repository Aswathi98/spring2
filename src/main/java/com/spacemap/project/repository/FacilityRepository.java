package com.spacemap.project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.FacilityEntity;

@Repository
public interface FacilityRepository extends CrudRepository<FacilityEntity, Integer> {

	@Query("SELECT f FROM FacilityEntity f WHERE cityId=:cityId")
	Iterable<FacilityEntity> findAllByCityId(@Param("cityId") String cityId);
}
