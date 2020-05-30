package com.spacemap.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spacemap.project.model.DeAllocationRequestModel;
import com.spacemap.project.sevice.DeAllocationService;

@RestController
@CrossOrigin
public class DeAllocationController {

	@Autowired
	DeAllocationService deAllocationService;

	@PostMapping(value = "/deAllocationRequest")
	public Boolean putRequest(@RequestBody DeAllocationRequestModel deAllocationRequestModel) throws Exception {
		try{
		return deAllocationService.putRequest(deAllocationRequestModel);
		}catch(Exception e){
			throw e;
		}
	}
}