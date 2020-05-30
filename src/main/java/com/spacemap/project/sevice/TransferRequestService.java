package com.spacemap.project.sevice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorAdminDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.dao.TransferRequestDAO;
import com.spacemap.project.entity.SpaceAllocationRequestEntity;
import com.spacemap.project.entity.TransferRequestEntity;
import com.spacemap.project.model.TransferRequestModel;
@Service
public class TransferRequestService {
	
	@Autowired
	EmployeeEntityDAO employeeentitydao;
	
	@Autowired
	EmployeeSpaceEntityDAO employeespaceentitydao;
	
	@Autowired
	TransferRequestDAO transferrequestdao;
	
	@Autowired
	SpaceMapDAO spacemapdao;
	
	@Autowired
	FloorAdminDAO flooradmindao;
	
	public Boolean puttransferRequest(TransferRequestModel transferrequestmodel) {
		Logger logger = LoggerFactory.getLogger(TransferRequestService.class);
		TransferRequestEntity transferrequestentity = new TransferRequestEntity();
		transferrequestentity.setEmpId(transferrequestmodel.getEmpId());
		transferrequestentity.setRecommender(transferrequestmodel.getRecommender());
		transferrequestentity.setRequestedspaceId(transferrequestmodel.getRequestedspaceId());
		System.out.println(transferrequestmodel.getEmpId());
		transferrequestentity.setEmpName(employeeentitydao.getEmployeeDetails(transferrequestmodel.getEmpId()).get().getfName());
		String spaceId = employeespaceentitydao.findbyempid(transferrequestmodel.getEmpId());
		transferrequestentity.setCurrentspaceId(spaceId);
		String empId2 = employeespaceentitydao.fetchEmpId(transferrequestmodel.getRequestedspaceId());
		transferrequestentity.setEmpId2(employeespaceentitydao.fetchEmpId(transferrequestmodel.getRequestedspaceId()));
		if(empId2 == null){
			transferrequestentity.setEmpName2(null);
		}else{
		transferrequestentity.setEmpName2(employeeentitydao.getEmployeeDetails(empId2).get().getfName());
		}
		transferrequestentity.setManager(employeeentitydao.getEmployeeDetails(transferrequestmodel.getEmpId()).get().getManagerId());
		String floorId = spacemapdao.findBySpaceId(transferrequestmodel.getRequestedspaceId()).getFloorId();
		transferrequestentity.setApprover(flooradmindao.getAdminId(floorId));
		Boolean status = transferrequestdao.saverequest(transferrequestentity);
		logger.info("saving request");
		return status;
	}

	public List<TransferRequestEntity> getPendingTransferRequest() {
		return transferrequestdao.getPendingTransferRequest();
	}
	
	public List<TransferRequestEntity> getApprovedTransferRequest() {
		return transferrequestdao.getApprovedTransferRequest();
	}
	
	public List<TransferRequestEntity> getDeclinedTransferRequest() {
		return transferrequestdao.getDeclinedTransferRequest();
	}

	
}
