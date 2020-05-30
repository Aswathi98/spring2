package com.spacemap.project.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.CityEntity;
import com.spacemap.project.repository.CityRepository;

@Component
public class CityDAO {

	@Autowired
	CityRepository cityRepository;

	public List<CityEntity> getCities() {
		Logger logger = LoggerFactory.getLogger(CityDAO.class);
		logger.info("fetching cities");
		return (List<CityEntity>)cityRepository.findAll();
	}
}
