package org.accolite.ACL.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Application{

	public Application() {
		//empty constructor
	}
	
	private int applicationId;
	private String applicationName;
	
	public int getApplicationId() {
		return applicationId;
	}


	public void setApplicationId(int appId) {
		this.applicationId = appId;
	}


	public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	


}
