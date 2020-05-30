package com.spacemap.project.model;

public class FloorMapDetailsModel {
	private String spaceId;
	private String spaceType;
	private int spaceRow;
	private int spaceColumn;
	private String empId;
	private String floorId;
	private String code;
	private String fname;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	public int getSpaceRow() {
		return spaceRow;
	}

	public void setSpaceRow(int spaceRow) {
		this.spaceRow = spaceRow;
	}

	public int getSpaceColumn() {
		return spaceColumn;
	}

	public void setSpaceColumn(int spaceColumn) {
		this.spaceColumn = spaceColumn;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
