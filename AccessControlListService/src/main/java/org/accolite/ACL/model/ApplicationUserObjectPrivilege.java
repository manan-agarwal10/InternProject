package org.accolite.ACL.model;

import org.springframework.stereotype.Component;

@Component
public class ApplicationUserObjectPrivilege {

	private int applicationUserObjectPrivilegeId;

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

	private int applicationObjectId;

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

	private int userid;

	private int privilegeId;

}
