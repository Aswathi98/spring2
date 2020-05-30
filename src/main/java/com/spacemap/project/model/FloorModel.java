package com.spacemap.project.model;

import org.springframework.stereotype.Component;

@Component
public class FloorModel {
	private String floorId;
	private String floorName;

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

}
