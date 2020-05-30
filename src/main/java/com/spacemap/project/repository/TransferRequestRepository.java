package com.spacemap.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spacemap.project.entity.TransferRequestEntity;

public interface TransferRequestRepository extends JpaRepository<TransferRequestEntity, Integer> {
	@Query(value = "select t from TransferRequestEntity t where t.status=:status order by creationDate DESC")
	public List<TransferRequestEntity> findByStatus(@Param("status") String status);
}
