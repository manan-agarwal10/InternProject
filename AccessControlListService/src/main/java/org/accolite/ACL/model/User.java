package org.accolite.ACL.model;

import org.springframework.stereotype.Component;

@Component
public class User {
	
	private int userId;
	private String userName;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
//user dao
//reques ApplicationObject
//response map userid username privilegetypeall



//applicationuserobjectprivilege
//requestmap applicationid objectid userid privillegetype (add)
//reponse same map


//view privilege
//request appid userid objectid
//response privilege



