package com.spacemap.project.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TRANSFER_REQUEST")
public class TransferRequestEntity {
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
	public String status = "Pending";
	public Date creationDate;
	

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 1, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "ID")
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	
	@Column(name = "RECOMMENDER")
	public String getRecommender() {
		return recommender;
	}
	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}
	
	@Column(name = "EMP_ID")
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	@Column(name = "EMP_NAME")
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(name = "APPROVER")
	public String getApprover() {
		return approver;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	
	@Column(name = "CURRENT_SPACE_ID")
	public String getCurrentspaceId() {
		return currentSpaceId;
	}
	public void setCurrentspaceId(String currentspaceId) {
		this.currentSpaceId = currentspaceId;
	}
	
	@Column(name = "REQUESTED_SPACE_ID")
	public String getRequestedspaceId() {
		return requestedSpaceId;
	}
	public void setRequestedspaceId(String requestedspaceId) {
		this.requestedSpaceId = requestedspaceId;
	}
	
	@Column(name = "EMP_ID2")
	public String getEmpId2() {
		return empId2;
	}
	public void setEmpId2(String empId2) {
		this.empId2 = empId2;
	}
	
	@Column(name = "EMP_NAME2")
	public String getEmpName2() {
		return empName2;
	}
	public void setEmpName2(String empName2) {
		this.empName2 = empName2;
	}
	
	@Column(name = "MANAGER")
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATION_DATE")
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
