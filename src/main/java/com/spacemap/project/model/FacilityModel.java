package com.spacemap.project.model;

import org.springframework.stereotype.Component;

@Component
public class FacilityModel {
	private String facilityId;
	private String facilityName;

	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

}
