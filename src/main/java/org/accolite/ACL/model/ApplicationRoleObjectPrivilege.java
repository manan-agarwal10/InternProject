package org.accolite.ACL.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ApplicationRoleObjectPrivilege {

	private int applicationRoleObjectPrivilegeId;
	private int applicationObjectId;
	private int Roleid;
	private int privilegeId;

	private LocalDateTime lastModifiedDate;

	public int getApplicationRoleObjectPrivilegeId() {
		return applicationRoleObjectPrivilegeId;
	}

	public void setApplicationRoleObjectPrivilegeId(int applicationRoleObjectPrivilegeId) {
		this.applicationRoleObjectPrivilegeId = applicationRoleObjectPrivilegeId;
	}

	public int getApplicationObjectId() {
		return applicationObjectId;
	}

	public void setApplicationObjectId(int applicationObjectId) {
		this.applicationObjectId = applicationObjectId;
	}

	public int getRoleid() {
		return Roleid;
	}

	public void setRoleid(int roleid) {
		Roleid = roleid;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

}
