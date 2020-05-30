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
@Table(name = "SPACE_ALLOCATION_REQUEST")
public class SpaceAllocationRequestEntity {

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

	public SpaceAllocationRequestEntity() {

	}

	@Id
	@SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 1, allocationSize = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
	@Column(name = "REQUEST_ID")
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	@Column(name = "EMP_ID")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
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

	@Column(name = "RECOMMENDER")
	public String getReccomender() {
		return reccomender;
	}

	public void setReccomender(String reccomender) {
		this.reccomender = reccomender;
	}

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "RECOMMENDED_ON")
	public Date getRecommendedOn() {
		return recommendedOn;
	}

	public void setRecommendedOn(Date recommendedOn) {
		this.recommendedOn = recommendedOn;
	}

	@Column(name = "APPROVER")
	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	@Column(name = "STATUS")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "APPROVED_ON")
	public Date getApprovedOn() {
		return approvedOn;
	}

	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}

	@Column(name = "IP")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "START_DATE")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(name = "END_DATE")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "SPACE_ID")
	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

}
