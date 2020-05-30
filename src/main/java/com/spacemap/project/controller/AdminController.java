package com.spacemap.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.entity.TransferRequestEntity;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.TransferRequestModel;
import com.spacemap.project.sevice.SpaceAllocationRequestService;
import com.spacemap.project.sevice.TransferDecisionService;
import com.spacemap.project.sevice.TransferRequestService;

@RestController
@CrossOrigin
public class AdminController {

	@Autowired
	SpaceAllocationRequestService spaceAllocationRequestService;
	
	@Autowired
	TransferRequestService transferrequestservice;
	
	@Autowired
	TransferDecisionService transferdecisionservice;

	@GetMapping(value = "/pendingRequests")
	public Iterable<SpaceAllocationRequestEntity> getPendingRequest() throws RecordNotFoundException {
		/*try{
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestService.getPendingRequest();
		}catch(RecordNotFoundException exception){
			throw new RecordNotFoundException("No pending requests");
		}*/
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestService.getPendingRequest();
	}

	@GetMapping(value = "/approvedRequests")
	public Iterable<SpaceAllocationRequestEntity> getApprovedRequest() {
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestService.getApprovedRequest();
	}

	@GetMapping(value = "/declinedRequests")
	public Iterable<SpaceAllocationRequestEntity> getDeclinedRequest() {
		return (List<SpaceAllocationRequestEntity>) spaceAllocationRequestService.getDeclinedRequest();
	}
	
	@GetMapping(value = "/pendingTransferRequests")
	public Iterable<TransferRequestEntity> getPendingTransferRequest() {
		return (List<TransferRequestEntity>) transferrequestservice.getPendingTransferRequest();
	}

	@GetMapping(value = "/approvedTransferRequests")
	public Iterable<TransferRequestEntity> getApprovedTransferRequest() {
		return (List<TransferRequestEntity>) transferrequestservice.getApprovedTransferRequest();
	}
	
	@GetMapping(value = "/declinedTransferRequests")
	public Iterable<TransferRequestEntity> getDeclinedTransferRequest() {
		return (List<TransferRequestEntity>) transferrequestservice.getDeclinedTransferRequest();
	}
	
	@PostMapping("/transferApprove")
	public Boolean approveTransferRequst(@RequestBody TransferRequestModel transferrequestmodel) {
		return transferdecisionservice.approveTransfer(transferrequestmodel);
	}
	
	@PostMapping("/transferDecline")
	public Boolean declineTransferRequst(@RequestBody TransferRequestModel transferrequestmodel) {
		return transferdecisionservice.declineTransfer(transferrequestmodel);
	}
	
}
