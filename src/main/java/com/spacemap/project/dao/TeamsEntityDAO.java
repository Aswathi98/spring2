package com.spacemap.project.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.TeamsEntity;
import com.spacemap.project.repository.TeamsRepository;

@Component
public class TeamsEntityDAO {

	@Autowired
	TeamsRepository teamsRepository;

	public List<TeamsEntity> listTeams() {
		Logger logger = LoggerFactory.getLogger(TeamsEntityDAO.class);
		logger.info("Fetching Teams Deatils");
		return (List<TeamsEntity>) teamsRepository.findAll();

	}

	public List<String> listTeamNames() {
		Logger logger = LoggerFactory.getLogger(TeamsEntityDAO.class);
		logger.info("Returning Teams Names");		
		return (List<String>) teamsRepository.getAllTeamNames();
	}

	public Optional<TeamsEntity> getTeamDetails(String teamId) {
		Logger logger = LoggerFactory.getLogger(TeamsEntityDAO.class);
		logger.info("Returning Teams Deatils");
		return teamsRepository.findByTeamId(teamId);
	}

}
