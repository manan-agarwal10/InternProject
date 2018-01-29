package org.accolite.ACL.model;


import org.springframework.stereotype.Component;

@Component
public class ApplicationUserPrivilege {

	public ApplicationUserPrivilege() {
		//empty constructor
	}
	private int applicationUserPrivilegeId ;
	private int  applicationId;
	private int  userId;
	private Privilege privilege;
	public int getApplicationUserPrivilegeId() {
		return applicationUserPrivilegeId;
	}
	public void setApplicationUserPrivilegeId(int applicationUserPrivilegeId) {
		this.applicationUserPrivilegeId = applicationUserPrivilegeId;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
		
}

