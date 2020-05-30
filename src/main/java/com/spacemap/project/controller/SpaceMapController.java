package com.spacemap.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.entity.TeamsEntity;
import com.spacemap.project.exception.AccessDeniedException;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.EmployeeDetailsModel;
import com.spacemap.project.model.LoginModel;
import com.spacemap.project.model.SpaceAllocationRequestModel;
import com.spacemap.project.model.SpaceModel;
import com.spacemap.project.model.TransferRequestModel;
import com.spacemap.project.sevice.AdminApproveService;
import com.spacemap.project.sevice.FetchEmployeeStatusService;
import com.spacemap.project.sevice.GetTeamNamesService;
import com.spacemap.project.sevice.LoginService;
import com.spacemap.project.sevice.SearchService;
import com.spacemap.project.sevice.SpaceAllocationRequestService;
import com.spacemap.project.sevice.TransferRequestService;

@RestController
@CrossOrigin
public class SpaceMapController {

	@Autowired
	SpaceAllocationRequestService spaceAllocationRequestService;

	@Autowired
	GetTeamNamesService getTeamNamesService;

	@Autowired
	LoginService loginService;

	@Autowired
	FetchEmployeeStatusService fetchEmployeeStatusService;

	@Autowired
	SearchService searchService;

	@Autowired
	AdminApproveService adminApproveService;

	@Autowired
	TransferRequestService transferrequestservice;

	@CrossOrigin
	@PostMapping(value = "/spaceRequest")
	public Boolean putRequest(@RequestBody SpaceAllocationRequestModel spaceAllocationRequestmodel) throws Exception{
		try{
		return spaceAllocationRequestService.putRequest(spaceAllocationRequestmodel);
		}catch(Exception e){
			throw e;
		}
		}

	@CrossOrigin
	@GetMapping(value = "/request")
	public Iterable<SpaceAllocationRequestEntity> getRequest() {
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestService.getRequest();
	}

	@CrossOrigin
	@GetMapping(value = "/teams")
	public Iterable<TeamsEntity> getTeam() {
		return (List<TeamsEntity>) getTeamNamesService.getTeams();
	}

	@CrossOrigin
	@PostMapping(value = "/login")
	public LoginModel login(@RequestBody LoginModel loginModel) throws AccessDeniedException  {
		/*
		 * LoginModel loginmodel = loginService.authenticate(loginModel);
		 * if(loginmodel == null){ throw new RecordNotFoundException(
		 * "no such user"); }
		 */
		try {
			// LoginModel loginmodel = loginService.authenticate(loginModel);
			return loginService.authenticate(loginModel);
		} catch (AccessDeniedException exception) {
			//throw new RecordNotFoundException("Invalid Username");
			throw new AccessDeniedException("Invalid User");
		}
	}

	@CrossOrigin
	@PostMapping("/approve")
	public Boolean approveRequst(@RequestBody SpaceAllocationRequestModel smodel) {
		return adminApproveService.admin(smodel);
	}

	@CrossOrigin
	@PostMapping("/decline")
	public Boolean declineRequest(@RequestBody SpaceAllocationRequestModel smodel) {
		// adminApproveService.admin1(smodel);
		return adminApproveService.admin1(smodel);
		// adminApproveService.AdminApprove(approveModel);
	}

	@CrossOrigin
	@PostMapping("/employeeDetails/{spaceId}")
	public SpaceModel getDetails(@PathVariable String spaceId) {
		SpaceModel spaceModel = fetchEmployeeStatusService.fetchEmployeeStatus(spaceId);
		// System.out.println(spaceModel);
		return spaceModel;
	}

	@PostMapping(value = "/search")
	public EmployeeDetailsModel empfetchOne(@RequestBody EmployeeDetailsModel emp) throws RecordNotFoundException {
		try {
			return searchService.findByName(emp.getfName());
		} catch (RecordNotFoundException exception) {
			throw new RecordNotFoundException("no employee found");
		}
	}

	@PostMapping(value = "/searchAll")
	public List<EmployeeDetailsModel> empfetch(@RequestBody EmployeeDetailsModel emp) {
		return searchService.findByNameStart(emp.getfName());
	}

	@PostMapping(value = "/transferRequest")
	public Boolean puttransferRequest(@RequestBody TransferRequestModel transferrequestmodel) {
		return transferrequestservice.puttransferRequest(transferrequestmodel);
	}
}