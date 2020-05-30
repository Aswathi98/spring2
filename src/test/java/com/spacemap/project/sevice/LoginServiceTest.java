package com.spacemap.project.sevice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spacemap.project.dao.EmployeeEntityDAO;
import com.spacemap.project.dao.EmployeeRolesDAO;
import com.spacemap.project.dao.EmployeeSpaceEntityDAO;
import com.spacemap.project.dao.LoginDAO;
import com.spacemap.project.dao.RolesDAO;
import com.spacemap.project.dao.SpaceMapDAO;
import com.spacemap.project.entity.EmployeeEntity;
import com.spacemap.project.entity.EmployeeRolesEntity;
import com.spacemap.project.entity.LoginEntity;
import com.spacemap.project.entity.RolesEntity;
import com.spacemap.project.exception.AccessDeniedException;
import com.spacemap.project.exception.RecordNotFoundException;
import com.spacemap.project.model.LoginModel;

public class LoginServiceTest {
	
	    private static final Logger log = LoggerFactory.getLogger(FloorMapOccupationDetailsServiceTest.class);

	
        @InjectMocks
	    LoginService loginService;

		@Mock
		LoginDAO loginDAO;

		@Mock
		EmployeeEntityDAO employeeEntityDAO;

		@Mock
		EmployeeRolesDAO employeeRolesDAO;

		@Mock
		RolesDAO rolesDAO;

		@Mock
		EmployeeSpaceEntityDAO employeeSpaceEntityDAO;

		@Mock
		SpaceMapDAO spaceMapDAO;
		
		@Before
		public void setUp() {
			MockitoAnnotations.initMocks(this);
		}

		@Test
		public void loginAuthenticate_when_loginModel() throws AccessDeniedException{
			LoginEntity loginEntity=new LoginEntity();
			LoginModel loginModel=new LoginModel();
			loginModel.setPassword(null);
			loginModel.setAccess(false);
			loginModel.setEmployeeId("A9422");
			loginModel.setFloorId("COK");
			loginModel.setfName("Reshma");
			loginModel.setRoleId("M01");
			loginModel.setRoleName("Manager");
			loginEntity.setPassword("jjdbDdag");
			loginEntity.setId(10);
			loginEntity.setEmployeeId("A9422");
			doThrow(AccessDeniedException.class).when(loginDAO).getUser(loginModel);
			doReturn(Optional.of(loginEntity)).when(loginDAO).getUser(loginModel);
			loginService.authenticate(loginModel);	
			log.info("LoginServiceTest::loginAuthenticate_when_loginModel");
		}
	
		
	@Test
	public void loginAuthenticate_with_loginModel_empEntity_rolesEntity() throws AccessDeniedException{
		EmployeeEntity employeeEntity=new EmployeeEntity();
		EmployeeRolesEntity employeeRolesEntity=new EmployeeRolesEntity();
		LoginEntity loginEntity=new LoginEntity();
		LoginModel loginModel=new LoginModel();
		RolesEntity rolesEntity=new RolesEntity();
		rolesEntity.setRoleId("m01");
		loginModel.setPassword("jjdbDdag");
		loginModel.setAccess(true);
		loginModel.setEmployeeId("A9422");
		loginModel.setFloorId("COK");
		loginModel.setfName("Reshma");
		
		loginModel.setRoleName("Manager");
		loginEntity.setPassword("jjdbDdag");
		loginEntity.setId(10);
		loginEntity.setEmployeeId("A9422");
		doThrow(AccessDeniedException.class).when(loginDAO).getUser(loginModel);
		doReturn(Optional.of(loginEntity)).when(loginDAO).getUser(loginModel);
		doReturn(Optional.of(employeeEntity)).when(employeeEntityDAO).getEmployeeDetails(loginModel.getEmployeeId());
		doReturn(Optional.of(employeeRolesEntity)).when(employeeRolesDAO).getRoleId(loginModel);
		doReturn(Optional.of(rolesEntity)).when(rolesDAO).getRoleName(loginModel);
        loginModel.setRoleId("M01");
        doReturn("").when(employeeSpaceEntityDAO).findbyempid(loginModel.getEmployeeId());
        doReturn("").when(spaceMapDAO).getFloorId(any(String.class));
		loginService.authenticate(loginModel);
		log.info("LoginServiceTest::loginAuthenticate_with_loginModel_empEntity_rolesEntity");

	}


}
