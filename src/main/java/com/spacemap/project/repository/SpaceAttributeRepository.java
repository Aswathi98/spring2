package com.spacemap.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spacemap.project.entity.SpaceAttributeEntity;

@Repository
public interface SpaceAttributeRepository extends CrudRepository<SpaceAttributeEntity, Integer> {

}
