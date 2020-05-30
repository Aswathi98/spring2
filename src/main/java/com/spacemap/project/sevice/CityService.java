package com.spacemap.project.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.CityDAO;

@Service("registerService")
public class CityService {

	@Autowired
	CityDAO cityDAO;

}
