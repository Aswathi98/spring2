package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPACE_ASSIGNMENT_DETAILS")
public class SpaceAssignmentDetailsEntity {

	private String id;
	private String spaceId;
	private String allocationRequestId;
	private String startDate;
	private String endDate;
	private String deAllocationRequestId;
	private String empId;

	public SpaceAssignmentDetailsEntity() {

	}

	@Id
	@Column(name = "ID", length = 10)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "SPACE_ID", length = 10)
	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	@Column(name = "ALLOCATION_REQUEST_ID", length = 10)
	public String getAllocationRequestId() {
		return allocationRequestId;
	}

	public void setAllocationRequestId(String allocationRequestId) {
		this.allocationRequestId = allocationRequestId;
	}

	@Column(name = "START_DATE")
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Column(name = "DEALLOCATION_REQUEST_ID")
	public String getDeAllocationRequestId() {
		return deAllocationRequestId;
	}

	public void setDeAllocationRequestId(String deAllocationRequestId) {
		this.deAllocationRequestId = deAllocationRequestId;
	}

	@Column(name = "EMP_ID")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
