package com.spacemap.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;

@Repository
public interface SpaceAllocationRequestRepository extends CrudRepository<SpaceAllocationRequestEntity, Integer> {
	@Query(value = "select t from SpaceAllocationRequestEntity t where t.status=:status order by creationDate DESC")
	public List<SpaceAllocationRequestEntity> findByStatus(@Param("status") String status);
}
