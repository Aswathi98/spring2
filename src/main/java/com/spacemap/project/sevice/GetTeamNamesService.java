package com.spacemap.project.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.TeamsEntityDAO;
import com.spacemap.project.entity.TeamsEntity;

@Service
public class GetTeamNamesService {
	@Autowired
	TeamsEntityDAO teamsEntityDAO;

	public List<String> getTeamNames() {
		return (List<String>) teamsEntityDAO.listTeamNames();
	}

	public List<TeamsEntity> getTeams() {
		return (List<TeamsEntity>) teamsEntityDAO.listTeams();
	}
}
