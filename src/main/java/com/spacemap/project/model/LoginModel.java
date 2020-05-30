package com.spacemap.project.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {

	@NotNull
	private String employeeId;

	@NotNull
	@Size(min = 8)
	private String password;

	private Boolean access;

	private String fName;
	private String roleName;
	private String roleId;
	private String floorId;

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAccess() {
		return access;
	}

	public void setAccess(Boolean access) {
		this.access = access;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "LoginModel(employeeId=" + employeeId + ",password=" + password + ",access=" + access + ",firstName="
				+ fName + ",roleName=" + roleName + ")";
	}

}
