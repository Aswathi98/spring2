package com.spacemap.project.model;

import java.util.Date;

public class TransferRequestModel {
	public int requestId;
	public String recommender;
	public String empId;
	public String empName;
	public String approver;
	public String currentSpaceId;
	public String requestedSpaceId;
	public String empId2;
	public String empName2;
	public String manager;
	public String status;
	public Date creationDate;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public String getCurrentspaceId() {
		return currentSpaceId;
	}
	public void setCurrentspaceId(String currentspaceId) {
		this.currentSpaceId = currentspaceId;
	}
	public String getRequestedspaceId() {
		return requestedSpaceId;
	}
	public void setRequestedspaceId(String requestedspaceId) {
		this.requestedSpaceId = requestedspaceId;
	}
	public String getEmpId2() {
		return empId2;
	}
	public void setEmpId2(String empId2) {
		this.empId2 = empId2;
	}
	public String getEmpName2() {
		return empName2;
	}
	public void setEmpName2(String empName2) {
		this.empName2 = empName2;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
