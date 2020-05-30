package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALLOCATION_ATTRIBUTE")
public class AllocationAttributeEntity {
	private int id;
	private String attributeId;
	private String attributeValue;
	private String spaceAllocationId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "ATTRIBUTE_ID")
	public String getAttributeId() {
		return attributeId;
	}

	public void setAttributeId(String attributeId) {
		this.attributeId = attributeId;
	}

	@Column(name = "ATTRIBUTE_VALUE")
	public String getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(String attributeValue) {
		this.attributeValue = attributeValue;
	}

	@Column(name = "SPACE_ALLOCATION_ID")
	public String getSpaceAllocationId() {
		return spaceAllocationId;
	}

	public void setSpaceAllocationId(String spaceAllocationId) {
		this.spaceAllocationId = spaceAllocationId;
	}

}
