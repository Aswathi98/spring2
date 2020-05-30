package com.spacemap.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLOORMAP_ALLOCATION")
public class FloorMapAllocationEntity {

	private int id;
	private String spaceId;
	private String teamId;

	public FloorMapAllocationEntity() {

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

	@Column(name = "SPACE_ID", length = 10)
	public String getspaceId() {
		return spaceId;
	}

	public void setspaceId(String spaceId) {
		this.spaceId = spaceId;
	}

	@Column(name = "TEAM_ID", length = 10)
	public String getteamId() {
		return teamId;
	}

	public void setteamId(String teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "FloorMapAllocationEntity [spaceId=" + spaceId + ", teamId=" + teamId + "]";
	}
}
