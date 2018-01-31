package org.accolite.ACL.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private LocalDateTime lastModifiedDate;

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

// user dao
// request ApplicationObject
// response map userid username privilegetypeall

// applicationuserobjectprivilege
// requestmap applicationid objectid userid privillegetype (add)
// reponse same map

// view privilege
// request appid userid objectid
// response privilege
