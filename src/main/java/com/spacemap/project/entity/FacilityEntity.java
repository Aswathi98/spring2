package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FACILITY")
public class FacilityEntity {

	private int id;
	private String facilityId;
	private String facitityName;
	private String cityId;

	public FacilityEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "FACILITY_ID", length = 10)
	public String getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(String facilityId) {
		this.facilityId = facilityId;
	}

	@Column(name = "FACILITY_NAME", length = 20)
	public String getFacitityName() {
		return facitityName;
	}

	public void setFacitityName(String facitityName) {
		this.facitityName = facitityName;
	}

	@Column(name = "CITY_ID", length = 10)
	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}