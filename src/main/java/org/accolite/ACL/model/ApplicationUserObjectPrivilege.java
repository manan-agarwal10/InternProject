package org.accolite.ACL.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ApplicationUserObjectPrivilege {

	private int applicationUserObjectPrivilegeId;
	private int applicationObjectId;
	private int userid;
	private int privilegeId;

	private LocalDateTime lastModifiedDate;

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getApplicationUserObjectPrivilegeId() {
		return applicationUserObjectPrivilegeId;
	}

	public void setApplicationUserObjectPrivilegeId(int applicationUserObjectPrivilegeId) {
		this.applicationUserObjectPrivilegeId = applicationUserObjectPrivilegeId;
	}	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getApplicationObjectId() {
		return applicationObjectId;
	}

	public void setApplicationObjectId(int applicationObjectId) {
		this.applicationObjectId = applicationObjectId;
	}

	public int getPrivilegeId() {
		return privilegeId;
	}

	public void setPrivilegeId(int privilegeId) {
		this.privilegeId = privilegeId;
	}

}
