package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SPACE_MAP")
public class SpaceMapEntity {

	private int id;
	private String spaceId;
	private String spaceType;
	private String floorId;
	private int spaceRow;
	private int spaceColumn;

	public SpaceMapEntity() {
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

	@Column(name = "SPACE_ID")
	public String getSpaceId() {
		return spaceId;
	}

	public void setSpaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	@Column(name = "SPACE_TYPE")
	public String getSpaceType() {
		return spaceType;
	}

	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}

	@Column(name = "FLOOR_ID")
	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	@Column(name = "SPACE_ROW")
	public int getSpaceRow() {
		return spaceRow;
	}

	public void setSpaceRow(int spaceRow) {
		this.spaceRow = spaceRow;
	}

	@Column(name = "SPACE_COLUMN")
	public int getSpaceColumn() {
		return spaceColumn;
	}

	public void setSpaceColumn(int spaceColumn) {
		this.spaceColumn = spaceColumn;
	}

	@Override
	public String toString() {
		return "SpaceMapEntity [id=" + id + ", spaceId=" + spaceId + ", spaceType=" + spaceType + ", floorId="
				+ floorId + ", spaceRow=" + spaceRow + ", spaceColumn=" + spaceColumn + "]";
	}
}
