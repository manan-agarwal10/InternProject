package org.accolite.ACL.model;

import java.time.LocalDateTime;

public class ApplicationRolePrivilege {

	private int applicationRolePrivilegeId;
	private int applicationId;
	private int roleId;
	private Privilege privilege;
	private LocalDateTime lastModifiedDate;

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getApplicationRolePrivilegeId() {
		return applicationRolePrivilegeId;
	}

	public void setApplicationRolePrivilegeId(int applicationRolePrivilegeId) {
		this.applicationRolePrivilegeId = applicationRolePrivilegeId;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Privilege getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	
}
