package org.accolite.ACL.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class RoleUser {
	private int roleUserId;
	private int roleId;
	private int userId;
	private LocalDateTime lastModifiedDate;

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getRoleUserId() {
		return roleUserId;
	}

	public void setRoleUserId(int roleUserId) {
		this.roleUserId = roleUserId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
