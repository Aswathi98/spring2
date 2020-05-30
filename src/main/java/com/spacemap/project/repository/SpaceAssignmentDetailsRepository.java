package com.spacemap.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.SpaceAssignmentDetailsEntity;

@Repository
public interface SpaceAssignmentDetailsRepository extends CrudRepository<SpaceAssignmentDetailsEntity, Integer> {

}
