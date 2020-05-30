package com.spacemap.project.sevice;

import java.util.ArrayList;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.FloorMapAllocationEntityDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.dao.TeamsEntityDAO;
import com.spacemap.project.entity.SpaceMapEntity;
import com.spacemap.project.model.FloorMapDetailsModel;

@Service
public class FloorMapOccupationDetailsService {

	@Autowired
	SpaceMapDAO spaceMapEntityDAO;

	@Autowired
	EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

	@Autowired
	EmployeeEntityDAO employeeentitydao;
 
	@Autowired
	TeamsEntityDAO teamsEntityDAO;

	@Autowired
	FloorMapAllocationEntityDAO floorMapAllocationEntityDAO;

	public Iterable<FloorMapDetailsModel> getMapDetails(String floorId) {
		Logger logger = LoggerFactory.getLogger(FloorMapOccupationDetailsService.class);
		//Iterator<SpaceMapEntity> spaceMap = spaceMapEntityDAO.getSpaceMap(floorId).iterator();
		ArrayList<FloorMapDetailsModel> spaceDetalis = new ArrayList<FloorMapDetailsModel>();
		spaceMapEntityDAO.getSpaceMap(floorId).forEach(spaceMapEntity -> {
			FloorMapDetailsModel floorMapDetailsModel = new FloorMapDetailsModel();
			String code = null;
			String fname = null;
			System.out.println(spaceMapEntity.getSpaceId());
			if (spaceMapEntity.getSpaceId() == null) {
				floorMapDetailsModel.setCode("s");

			} else {
                
				String empId = employeeSpaceEntityDAO.getEmployeeId(spaceMapEntity.getSpaceId());
				System.out.println(empId);
				if (empId == null) {
					floorMapDetailsModel.setEmpId(spaceMapEntity.getSpaceId());
					code = "n";
				}
				/*
				 * String teamId=
				 * floorMapAllocationEntityDAO.getTeamId(spaceMapEntity
				 * .getSpaceId()).get().getteamId(); System.out.println(teamId);
				 * String code=
				 * teamsEntityDAO.getTeamDetails(teamId).get().getCode();
				 * System.out.println(code);
				 */
				/* floorMapDetailsModel.setCode(code); */
				else {
					floorMapDetailsModel.setEmpId(empId);
					fname = employeeentitydao.getEmployeeDetails(empId).get().getfName();
					String teamId = employeeentitydao.getEmployeeDetails(empId).get().getTeamId();
					code = teamsEntityDAO.getTeamDetails(teamId).get().getCode();
				}
			}
			
			floorMapDetailsModel.setSpaceColumn(spaceMapEntity.getSpaceColumn());
			floorMapDetailsModel.setSpaceId(spaceMapEntity.getSpaceId());
			floorMapDetailsModel.setSpaceRow(spaceMapEntity.getSpaceRow());
			floorMapDetailsModel.setSpaceType(spaceMapEntity.getSpaceType());
			floorMapDetailsModel.setFloorId(spaceMapEntity.getFloorId());
			if(fname != null){
			floorMapDetailsModel.setFname(fname);
			}else{
			floorMapDetailsModel.setFname("");
			}
			floorMapDetailsModel.setCode(code);
			spaceDetalis.add(floorMapDetailsModel);
			// System.out.println(spaceMap.next().toString());
			});
		logger.info("returning space details");
		return spaceDetalis;
	}

}
// while (spaceMap.hasNext()) {
// SpaceMapEntity spaceMapEntity = spaceMap.next();
//
// String empId =
// employeeSpaceEntityDAO.getEmployeeId(spaceMapEntity.getSpaceId());
// String teamId=
// floorMapAllocationEntityDAO.getTeamId(spaceMapEntity.getSpaceId()).get().getteamId();
// String code= teamsEntityDAO.getTeamDetails(teamId).get().getCode();
// FloorMapDetailsModel floorMapDetailsModel = new FloorMapDetailsModel();
// floorMapDetailsModel.setEmpId(empId);
// floorMapDetailsModel.setSpaceColumn(spaceMapEntity.getSpaceColumn());
// floorMapDetailsModel.setSpaceId(spaceMapEntity.getSpaceId());
// floorMapDetailsModel.setSpaceRow(spaceMapEntity.getSpaceRow());
// floorMapDetailsModel.setSpaceType(spaceMapEntity.getSpaceType());
// floorMapDetailsModel.setFloorId(spaceMapEntity.getFloorId());
// floorMapDetailsModel.setCode(code);
// spaceDetalis.add(floorMapDetailsModel);
// System.out.println(spaceMap.next().toString());
// }