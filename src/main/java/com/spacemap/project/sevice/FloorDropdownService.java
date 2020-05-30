package com.spacemap.project.sevice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.FloorsDAO;
import com.spacemap.project.entity.FloorsEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.FacilityModel;
import com.spacemap.project.model.FloorModel;

@Service
public class FloorDropdownService {
	@Autowired
	FloorsDAO floorsDAO;

	public List<FloorModel> getFloor(FacilityModel facilityModel)  {

		List<FloorModel> floorModel = new ArrayList<FloorModel>();
		List<FloorsEntity> floorslist = (List<FloorsEntity>) floorsDAO.getFloors(facilityModel.getFacilityId());

		for (FloorsEntity floor : floorslist) {

			FloorModel model = new FloorModel();
			model.setFloorId(floor.getFloorId());
			model.setFloorName(floor.getFloorName());
			floorModel.add(model);

		}
		Logger logger = LoggerFactory.getLogger(FloorDropdownService.class);
		logger.info("fetching floors");
		return floorModel;

	}
}
