package com.spacemap.project.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.SpaceAllocationRequestEntityDAO;
import com.spacemap.project.entity.SpaceAllocationRequestEntity;

@Service
public class GetSpaceAllocationRequestService {

	@Autowired
	SpaceAllocationRequestEntityDAO spaceAllocationRequestEntityDAO;

	public List<SpaceAllocationRequestEntity> getRequest() {
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestEntityDAO.getRequest();

	}

}
