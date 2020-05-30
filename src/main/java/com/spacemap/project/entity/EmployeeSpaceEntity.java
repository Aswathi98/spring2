package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_SPACE")
public class EmployeeSpaceEntity {

	@Override
	public String toString() {
		return "EmployeeSpaceEntity [id=" + id + ", spaceId=" + spaceId + ", empId=" + empId + "]";
	}

	private int id;
	private String spaceId;
	private String empId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "SPACE_ID")
	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	@Column(name = "EMP_ID")
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
