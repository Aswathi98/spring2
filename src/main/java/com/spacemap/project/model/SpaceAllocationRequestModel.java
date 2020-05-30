package com.spacemap.project.model;

import java.util.Date;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;

public class SpaceAllocationRequestModel {

	public int requestId;
	public String empId;
	public Date creationDate;
	public String reccomender;
	public Date recommendedOn;
	public String approver;
	public String status;
	public Date approvedOn;
	public String ip;
	public Date startDate;
	public Date endDate;
	public String type;
	public String spaceId;

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getReccomender() {
		return reccomender;
	}

	public void setReccomender(String reccomender) {
		this.reccomender = reccomender;
	}

	public Date getRecommendedOn() {
		return recommendedOn;
	}

	public void setRecommendedOn(Date recommendedOn) {
		this.recommendedOn = recommendedOn;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	public SpaceAllocationRequestEntity addAllocationEntity() {
		SpaceAllocationRequestEntity allocationEntity = new SpaceAllocationRequestEntity();
		allocationEntity.setApprovedOn(this.approvedOn);
		allocationEntity.setApprover(this.approver);
		allocationEntity.setCreationDate(this.creationDate);
		allocationEntity.setEmpId(this.empId);
		allocationEntity.setEndDate(this.endDate);
		allocationEntity.setIp(this.ip);
		allocationEntity.setReccomender(this.reccomender);
		allocationEntity.setRecommendedOn(this.recommendedOn);
		allocationEntity.setRequestId(this.requestId);
		allocationEntity.setSpaceId(this.spaceId);
		allocationEntity.setStartDate(this.startDate);
		allocationEntity.setStatus(this.status);
		allocationEntity.setType(this.type);

		return allocationEntity;
	}
}
