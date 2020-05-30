package com.spacemap.project.dao;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.entity.TransferRequestEntity;
import com.spacemap.project.repository.TransferRequestRepository;
@Component
public class TransferRequestDAO {

	@Autowired
	TransferRequestRepository transferrequestrepository;
	
	public Boolean saverequest(TransferRequestEntity transferrequestentity) {
		Logger logger = LoggerFactory.getLogger(TransferRequestDAO.class);
		logger.info("Saving Transfer Request");		
		TransferRequestEntity transferrequestentity1 = transferrequestrepository.save(transferrequestentity);
		if(transferrequestentity1!=null){
			return true;
		}else{
			return false;
		}
	}

	public Optional<TransferRequestEntity> getTransferRequest(int id) {
		Logger logger = LoggerFactory.getLogger(TransferRequestDAO.class);
		logger.info("Fetching Transfer Request");
		return (Optional<TransferRequestEntity>) transferrequestrepository.findById(id);
	}
	
	public List<TransferRequestEntity> getPendingTransferRequest() {
		Logger logger = LoggerFactory.getLogger(TransferRequestDAO.class);
		logger.info("Fetching Pending Transfer Request");
		return (List<TransferRequestEntity>) transferrequestrepository.findByStatus("Pending");
	}

	public List<TransferRequestEntity> getApprovedTransferRequest() {
		Logger logger = LoggerFactory.getLogger(TransferRequestDAO.class);
		logger.info("Fetching Approved Transfer Request");
		return (List<TransferRequestEntity>) transferrequestrepository.findByStatus("Approved");
	}

	public List<TransferRequestEntity> getDeclinedTransferRequest() {
		Logger logger = LoggerFactory.getLogger(TransferRequestDAO.class);
		logger.info("Fetching Declined Transfer Request");
		return (List<TransferRequestEntity>) transferrequestrepository.findByStatus("Declined");
	}

}
