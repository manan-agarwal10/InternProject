package org.accolite.model;

import java.util.Date;

public class Application{

	public Application() {
	}
	
	private int appId;

	
	
	private String applicationName;
	

	private int lastModifiedBy;
	
	private Date lastModifiedDate;
	
	



	public int getAppId() {
		return appId;
	}


	public void setAppId(int appId) {
		this.appId = appId;
	}


	public String getApplicationName() {
		return applicationName;
	}


	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}


	public int getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}


	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}



}
