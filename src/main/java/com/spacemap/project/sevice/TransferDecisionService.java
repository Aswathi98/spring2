package com.spacemap.project.sevice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorMapAllocationEntityDAO;
import com.spacemap.project.dao.TransferRequestDAO;
import com.spacemap.project.entity.EmployeeSpaceEntity;
import com.spacemap.project.entity.FloorMapAllocationEntity;
import com.spacemap.project.entity.TransferRequestEntity;
import com.spacemap.project.model.TransferRequestModel;

@Service
public class TransferDecisionService {

	@Autowired
	TransferRequestDAO transferrequestdao;
	
	@Autowired
	EmployeeSpaceEntityDAO employeespaceentitydao;
	
	@Autowired
	EmployeeEntityDAO employeeEntityDAO;
	
	@Autowired
	FloorMapAllocationEntityDAO floormapallocationenitydao;
	
	public Boolean approveTransfer(TransferRequestModel transferrequestmodel) {
		Logger logger = LoggerFactory.getLogger(TransferDecisionService.class);
		TransferRequestEntity transferrequestentity = transferrequestdao.getTransferRequest(transferrequestmodel.getRequestId()).get();
		transferrequestentity.setStatus("Approved");
		String currentSpaceId = transferrequestmodel.getCurrentspaceId();
		String requestedspaceId = transferrequestmodel.getRequestedspaceId();
		EmployeeSpaceEntity employeespaceentity1 = employeespaceentitydao.findEntityBySpaceId(currentSpaceId);
		EmployeeSpaceEntity employeespaceentity2 = employeespaceentitydao.findEntityBySpaceId(requestedspaceId);
		employeespaceentity1.setEmpId(transferrequestmodel.getEmpId2());
		employeespaceentity2.setEmpId(transferrequestmodel.getEmpId());
		System.out.println(transferrequestmodel.getEmpId2()+ "+" +transferrequestmodel.getEmpId());
		String teamid1 = employeeEntityDAO.getEmployeeDetails(transferrequestmodel.getEmpId()).get().getTeamId();
		String teamid2 = employeeEntityDAO.getEmployeeDetails(transferrequestmodel.getEmpId2()).get().getTeamId();
		FloorMapAllocationEntity floormapallocationentity1 =  floormapallocationenitydao.getEntity(currentSpaceId);
		FloorMapAllocationEntity floormapallocationentity2 =  floormapallocationenitydao.getEntity(requestedspaceId);
		floormapallocationentity1.setteamId(teamid2);
		floormapallocationentity2.setteamId(teamid1);
		Boolean saverequest = transferrequestdao.saverequest(transferrequestentity);
		employeespaceentity1 = employeespaceentitydao.saveEntity(employeespaceentity1);
		employeespaceentity2 = employeespaceentitydao.saveEntity(employeespaceentity2);
		floormapallocationentity1 = floormapallocationenitydao.saveEntity(floormapallocationentity1);
		floormapallocationentity2 = floormapallocationenitydao.saveEntity(floormapallocationentity2);
		if(saverequest = true &&employeespaceentity1 != null &&employeespaceentity2 != null &&floormapallocationentity1 != null &&floormapallocationentity2 != null ){
			logger.info("database updated for transfer");
			return true;
		}else{
			return false;
		}
	}

	public Boolean declineTransfer(TransferRequestModel transferrequestmodel) {
		TransferRequestEntity transferrequestentity = transferrequestdao.getTransferRequest(transferrequestmodel.getRequestId()).get();
		transferrequestentity.setStatus("Declined");
		return transferrequestdao.saverequest(transferrequestentity);
		}

}
